package br.unipar.plano.domain.solicitacaoprocedimento.service.impl;

import br.unipar.plano.domain.solicitacaoprocedimento.model.IdSolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.model.SolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.model.StatusSolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.service.SolicitacaoProcedimentoRepository
import br.unipar.plano.domain.solicitacaoprocedimento.service.SolicitacaoProcedimentoService
import br.unipar.plano.interfaces.rest.solicitacaoprocedimento.SolicitacaoProcedimentoDTO
import org.springframework.stereotype.Service

@Service
public class SolicitacaoProcedimentoServiceImpl (
    private val solicitacaoProcedimentoRepository: SolicitacaoProcedimentoRepository
) : SolicitacaoProcedimentoService {

    override fun insert(dto:SolicitacaoProcedimentoDTO): IdSolicitacaoProcedimento {
//        validar carteirinha
//        verificar procedimento restrito
//        verificar se o agente ta diferente de null
        val solicitacaoProcedimento = toModel(IdSolicitacaoProcedimento(), dto)
        val novaSolicitacao = solicitacaoProcedimentoRepository.save(solicitacaoProcedimento);
        return novaSolicitacao.id
    }

    override fun liberarSolicitacao(solicitacaoID: Long) {

        //validar usuario //TODO
        val solicitacaoProcedimento = solicitacaoProcedimentoRepository.findById(solicitacaoID);

        if (solicitacaoProcedimento.isPresent
            && !solicitacaoProcedimento.get().statusSolicitacao.equals(StatusSolicitacaoProcedimento.LIBERADO)) {

            val solicitacoes = solicitacaoProcedimentoRepository.findByProcedimentoAndStatusSolicitacaoEquals("1L",
                StatusSolicitacaoProcedimento.LIBERADO);

            //perguntar se a solicitacao liberada para a verificacao
            if (!existeDuasSolitacoesLiberadasNoMesmoMes(solicitacoes, solicitacaoProcedimento.get())) {
                solicitacaoProcedimento.get().statusSolicitacao = StatusSolicitacaoProcedimento.LIBERADO;
                solicitacaoProcedimentoRepository.save(solicitacaoProcedimento);
            }
        }
    }

    override fun rejeitarSolicitacao(solicitacaoID: Long, descricaoRejeicao: String) {
        val solicitacaoProcedimento = solicitacaoProcedimentoRepository.findById(solicitacaoID);

        if(solicitacaoProcedimento.isPresent && solicitacaoProcedimento.get().statusSolicitacao.equals(StatusSolicitacaoProcedimento.ABERTO)){
            solicitacaoProcedimento.get().statusSolicitacao = StatusSolicitacaoProcedimento.REJEITADO;
            solicitacaoProcedimento.get().descricaoRejeicao = descricaoRejeicao;

            solicitacaoProcedimentoRepository.save(solicitacaoProcedimento);
        }
    }

    private fun existeDuasSolitacoesLiberadasNoMesmoMes(solicitacoesProcecimentos:List<SolicitacaoProcedimento>,
                                                        solicitacaoProcedimento: SolicitacaoProcedimento): Boolean {

        val solicitacaoProcedimentoMesmoMes =
            solicitacoesProcecimentos.filter { solicitacao -> solicitacao.data.dayOfMonth == solicitacaoProcedimento.data.dayOfMonth };

        return solicitacaoProcedimentoMesmoMes.size > 1;
    }

    private fun toModel(id: IdSolicitacaoProcedimento, dto: SolicitacaoProcedimentoDTO) = SolicitacaoProcedimento(
        id = id,
        procedimento = dto.procedimento,
        statusSolicitacao = dto.statusSolicitacao,
        usuario = dto.usuario,
        agente = dto.agente,
        carteirinha = dto.carteirinha,
        data = dto.data,
        descricaoRejeicao = dto.descricaoRejeicao
    )
}