package br.unipar.plano.domain.solicitacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoprocedimento.model.SolicitacaoProcedimento
import br.unipar.plano.domain.solicitacaoprocedimento.model.StatusSolicitacaoProcedimento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SolicitacaoProcedimentoRepository : JpaRepository<SolicitacaoProcedimento, Long> {

    fun findByProcedimentoAndStatusSolicitacaoEquals(
        procedimento: String,
        statusSolicitacao: StatusSolicitacaoProcedimento
    ): List<SolicitacaoProcedimento>;

    fun save(solicitacaoProcedimento: Optional<SolicitacaoProcedimento>)
}