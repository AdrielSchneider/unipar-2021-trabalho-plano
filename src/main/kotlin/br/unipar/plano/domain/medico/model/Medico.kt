package br.unipar.plano.domain.solicitacaoprocedimento.model

import javax.persistence.*

@Entity
data class Medico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medido")
    val id: Long
) {
}