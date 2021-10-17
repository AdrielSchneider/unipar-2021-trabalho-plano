package br.unipar.plano.dto

import br.unipar.plano.domain.model.Municipio
import java.util.*

class TransporteDTO(
    val carteirinhaId: UUID,
    val cidadeOrigem: String,
    val cidadeDestino: String
)