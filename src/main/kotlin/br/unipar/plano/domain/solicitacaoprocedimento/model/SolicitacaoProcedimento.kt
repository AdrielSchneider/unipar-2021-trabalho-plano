package br.unipar.plano.domain.solicitacaoprocedimento.model

import br.unipar.plano.domain.centrais.model.Central
import br.unipar.plano.domain.centrais.model.Endereco
import br.unipar.plano.domain.centrais.model.IdCentral
import br.unipar.plano.domain.centrais.model.StatusCentral
import java.time.LocalDate
import javax.persistence.*

@Entity
class SolicitacaoProcedimento(
    @field:EmbeddedId
    val id: IdSolicitacaoProcedimento,

    @OneToMany(orphanRemoval = true)
    val procedimento: String,

    @Column(nullable = false)
    var statusSolicitacao: StatusSolicitacaoProcedimento = StatusSolicitacaoProcedimento.ABERTO,

    @OneToMany(orphanRemoval = true)
    val usuario: String,

    @OneToMany(orphanRemoval = true)
    val agente: String,

    @Column(name = "id_carteirinha")
    val carteirinha: String,

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    val data: LocalDate,

    @Column(name = "descricao_rejeicao")
    var descricaoRejeicao: String
) {

    fun with(
        id: IdSolicitacaoProcedimento = this.id,
        procedimento: String = this.procedimento,
        statusSolicitacao: StatusSolicitacaoProcedimento = this.statusSolicitacao,
        usuario: String = this.usuario,
        agente: String = this.agente,
        carteirinha: String = this.carteirinha,
        data: LocalDate = this.data,
        descricaoRejeicao: String = this.descricaoRejeicao
    ) = copy(
        id = id,
        procedimento = procedimento,
        statusSolicitacao = statusSolicitacao,
        usuario = usuario,
        agente = agente,
        medico = medico,
        carteirinha = carteirinha,
        data = data,
        descricaoRejeicao = descricaoRejeicao
    )

    private fun copy(
        id: IdSolicitacaoProcedimento = this.id,
        procedimento: String = this.procedimento,
        statusSolicitacao: StatusSolicitacaoProcedimento = this.statusSolicitacao,
        usuario: String = this.usuario,
        agente: String = this.agente,
        carteirinha: String = this.carteirinha,
        data: LocalDate = this.data,
        descricaoRejeicao: String = this.descricaoRejeicao
    ) = SolicitacaoProcedimento(
        id = id,
        procedimento = procedimento,
        statusSolicitacao = statusSolicitacao,
        usuario = usuario,
        agente = agente,
        carteirinha = carteirinha,
        data = data,
        descricaoRejeicao = descricaoRejeicao
    )
}