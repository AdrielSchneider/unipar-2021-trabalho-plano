package br.unipar.plano.domain.solicitacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoprocedimento.model.SolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.model.StatusSolicitacaoProcedimento
import br.unipar.plano.interfaces.solicitacaoprocedimento.SolicitacaoProcedimentoDTO
import org.springframework.stereotype.Service

@Service
class SolicitacaoProcedimentoService(
    val solicitacaoProcedimentoRepository: SolicitacaoProcedimentoRepository
) {

    fun insert(dto: SolicitacaoProcedimentoDTO): Long {
//        validar carteirinha
//        verificar procedimento restrito
//        verificar se o medico ta diferente de null
        return 1L;
    }

    fun liberarSolicitacao(usuario: String, solicitacaoID: Long) {

        //validar usuario //TODO
        val solicitacaoProcedimento = solicitacaoProcedimentoRepository.findById(solicitacaoID);

        if (solicitacaoProcedimento.isPresent
            && !solicitacaoProcedimento.get().statusSolicitacao.equals(StatusSolicitacaoProcedimento.LIBERADO)) {

            val solicitacoes = solicitacaoProcedimentoRepository.findByProcedimentoAndStatusSolicitacaoEquals("1L",
                StatusSolicitacaoProcedimento.LIBERADO);

            if (!existeDuasSolitacoesLiberadasNoMesmoMes(solicitacoes, solicitacaoProcedimento.get())) {
                solicitacaoProcedimento.get().statusSolicitacao = StatusSolicitacaoProcedimento.LIBERADO;
                solicitacaoProcedimentoRepository.save(solicitacaoProcedimento);
            }
        }
    }

    fun rejeitarSolicitacao(solicitacaoProcedimento: SolicitacaoProcedimento) {
        solicitacaoProcedimento.statusSolicitacao = StatusSolicitacaoProcedimento.REJEITADO;
    }

    private fun existeDuasSolitacoesLiberadasNoMesmoMes(solicitacoesProcecimentos: List<SolicitacaoProcedimento>,
        solicitacaoProcedimento: SolicitacaoProcedimento): Boolean {

        val solicitacaoProcedimentoMesmoMes =
            solicitacoesProcecimentos.filter { f -> f.data.dayOfMonth == solicitacaoProcedimento.data.dayOfMonth };

        return solicitacaoProcedimentoMesmoMes.size > 1;
    }
}