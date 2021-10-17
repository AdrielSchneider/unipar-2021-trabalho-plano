package br.unipar.plano.domain.model

import br.unipar.plano.domain.valueobjects.StatusTransporte
import br.unipar.plano.domain.valueobjects.TipoTransporte
import java.time.LocalDate
import java.util.*

class Transporte(
    val id: UUID = UUID.randomUUID(),
    val solicitante: Carteirinha,
    val dataSolicitacao: LocalDate = LocalDate.now(),
    var status: StatusTransporte = StatusTransporte.PENDENTE,
    val cidadeOrigem: String,
    val cidadeDestino: String,
    val tipoTransporte: TipoTransporte,
) {
}