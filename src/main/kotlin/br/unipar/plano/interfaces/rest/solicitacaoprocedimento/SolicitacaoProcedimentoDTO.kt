package br.unipar.plano.interfaces.rest.solicitacaoprocedimento

import br.unipar.plano.domain.solicitacaoprocedimento.model.IdSolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.model.StatusSolicitacaoProcedimento
import java.time.LocalDate

data class SolicitacaoProcedimentoDTO(
    val id: IdSolicitacaoProcedimento,
    val procedimento: String,
    val statusSolicitacao: StatusSolicitacaoProcedimento,
    val usuario: String,
    val agente: String,
    val carteirinha: String,
    val data: LocalDate,
    val descricaoRejeicao: String
)