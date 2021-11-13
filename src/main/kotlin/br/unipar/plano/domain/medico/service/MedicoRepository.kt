package br.unipar.plano.domain.solicitacaoprocedimento.service

import br.unipar.plano.domain.solicitacaoprocedimento.model.SolicitacaoProcedimento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MedicoRepository : JpaRepository<SolicitacaoProcedimento, Long> {

}