package br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model

import java.time.LocalDate

data class SolicitacaoLiberacaoProcedimento(
    var procedimento: String,
    var statusSolicitacao: StatusSolicitacaoLiberacaoProcedimento = StatusSolicitacaoLiberacaoProcedimento.ABERTO,
    var usuario: String,
    var agente: String,
    var medico: String,
    var carteirinha: String,
    var data: LocalDate,
    var descricaoRejeicao: String
)