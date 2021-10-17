package br.unipar.plano.repository

import br.unipar.plano.domain.model.Transporte
import java.util.*

interface TransporteRepository {
    fun findAll(): MutableIterable<Transporte>
    fun findById(id: UUID): Transporte
    fun save(transporte: Transporte): Transporte
}