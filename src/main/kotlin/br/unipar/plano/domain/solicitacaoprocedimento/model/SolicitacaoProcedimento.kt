package br.unipar.plano.domain.solicitacaoprocedimento.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class SolicitacaoProcedimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao_liberacao_procedimento")
    val id: Long,

    @Column(name = "id_procedimento")
    val procedimento: String,

    @Column(name = "statusSolicitacao")
    var statusSolicitacao: StatusSolicitacaoProcedimento = StatusSolicitacaoProcedimento.ABERTO,

    @Column(name = "id_usuario")
    val usuario: String,

    @Column(name = "id_agente")
    val agente: String,

    @Column(name = "id_medico")
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val medico: Medico,

    @Column(name = "id_carteirinha")
    val carteirinha: String,

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    val data: LocalDate,

    @Column(name = "descricao_rejeicao")
    val descricaoRejeicao: String
) {
}