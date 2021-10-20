package br.unipar.plano.domain.solicitacaoliberacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model.SolicitacaoLiberacaoProcedimento
import br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model.StatusSolicitacaoLiberacaoProcedimento
import org.springframework.stereotype.Service

@Service
class SolicitacaoLiberacaoProcedimentoService {

    fun insert(solicitacaoLiberacaoProcedimento: SolicitacaoLiberacaoProcedimento) {
//        validar carteirinha
//        verificar procedimento restrito
//        verificar se o medico ta diferente de null
    }

    fun liberarSoliciatacao(usuario: String, procedimentoID: Long, solicitacaoID: Long) {
        // consultar se ha alguma solicitacao para o procedimento naquele mes
        // consultar solicitacao e atualizar para liberada
    }

    fun rejeitarSolicitacao(solicitacaoLiberacaoProcedimento: SolicitacaoLiberacaoProcedimento) {
        solicitacaoLiberacaoProcedimento.statusSolicitacao = StatusSolicitacaoLiberacaoProcedimento.REJEITADO;
    }
}