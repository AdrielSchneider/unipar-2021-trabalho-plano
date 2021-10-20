package br.unipar.plano.domain.solicitacaoliberacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model.SolicitacaoLiberacaoProcedimento
import br.unipar.plano.domain.solicitacaoliberacaoprocedimento.model.StatusSolicitacaoLiberacaoProcedimento
import org.springframework.stereotype.Service

@Service
class SolicitacaoLiberacaoProcedimentoService {

    fun insert(solicitacaoLiberacaoProcedimento: SolicitacaoLiberacaoProcedimento){
        //fazer DTO para validar os dados

    }

    fun liberarSoliciatacao(solicitacaoLiberacaoProcedimento: SolicitacaoLiberacaoProcedimento){
        solicitacaoLiberacaoProcedimento.statusSolicitacao = StatusSolicitacaoLiberacaoProcedimento.LIBERADO;
    }

    fun rejeitarSolicitacao(solicitacaoLiberacaoProcedimento: SolicitacaoLiberacaoProcedimento){
        solicitacaoLiberacaoProcedimento.statusSolicitacao = StatusSolicitacaoLiberacaoProcedimento.REJEITADO;
    }
}