package br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model

data class SolicitacaoLiberacaoProcedimento(
    var procedimento: String,
    var statusSolicitacao: StatusSolicitacaoLiberacaoProcedimento = StatusSolicitacaoLiberacaoProcedimento.ABERTO,
    var usuario: String,
    var agente: String,
    var medico: String,
    var carteirinha: String
)