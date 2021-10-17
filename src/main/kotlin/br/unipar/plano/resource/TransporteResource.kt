package br.unipar.plano.resource

import br.unipar.plano.domain.model.Transporte
import br.unipar.plano.dto.TransporteDTO
import org.springframework.http.ResponseEntity
import java.util.*

interface TransporteResource {

    fun buscaTodos(): ResponseEntity<MutableIterable<Transporte>>
    fun buscaPorId(id: UUID): ResponseEntity<Transporte>
    fun solicitarTransporte(dto: TransporteDTO): ResponseEntity<Void>

}