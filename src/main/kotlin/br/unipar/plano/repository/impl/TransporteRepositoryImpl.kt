package br.unipar.plano.repository.impl

import br.unipar.plano.domain.model.Transporte
import br.unipar.plano.repository.TransporteRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TransporteRepositoryImpl: TransporteRepository {
    private var dados: MutableList<Transporte> = ArrayList()

    override fun findAll(): MutableIterable<Transporte> = dados

    override fun findById(id: UUID): Transporte = dados.first { it.id == id }

    override fun save(transporte: Transporte): Transporte {
        val index = dados.indexOfFirst { it.id == transporte.id }
        if (index == -1)
            dados.add(transporte)
        else
            dados[index] = transporte
        return transporte
    }
}