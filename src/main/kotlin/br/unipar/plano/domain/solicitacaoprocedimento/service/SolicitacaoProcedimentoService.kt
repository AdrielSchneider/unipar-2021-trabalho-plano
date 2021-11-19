package br.unipar.plano.domain.solicitacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoprocedimento.model.IdSolicitacaoProcedimento
import br.unipar.plano.interfaces.rest.solicitacaoprocedimento.SolicitacaoProcedimentoDTO
import org.springframework.stereotype.Service

@Service
interface SolicitacaoProcedimentoService {

    fun insert(dto: SolicitacaoProcedimentoDTO): IdSolicitacaoProcedimento
    fun liberarSolicitacao(solicitacaoID: Long)
    fun rejeitarSolicitacao(solicitacaoID: Long, descricaoRejeicao: String)

}