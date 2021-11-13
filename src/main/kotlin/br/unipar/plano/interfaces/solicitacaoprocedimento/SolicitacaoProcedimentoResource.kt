package br.unipar.plano.interfaces.solicitacaoprocedimento

import br.unipar.plano.domain.solicitacaoprocedimento.service.SolicitacaoProcedimentoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/solicitacao-liberacao-procedimento")
class SolicitacaoProcedimentoResource(val solicitacaoProcedimentoService: SolicitacaoProcedimentoService) {

    //TODO anotações
    fun insert(dto: SolicitacaoProcedimentoDTO): Long {
        return solicitacaoProcedimentoService.insert(dto);
    }

    //TODO anotações
    fun liberarSolicitacao(usuario: String, solicitacaoId: Long) {
        solicitacaoProcedimentoService.liberarSolicitacao(usuario, solicitacaoId);
    }
}