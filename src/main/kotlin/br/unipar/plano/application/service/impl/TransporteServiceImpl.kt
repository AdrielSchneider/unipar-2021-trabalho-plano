package br.unipar.plano.application.service.impl

import br.unipar.plano.application.service.interfaces.TransporteService
import br.unipar.plano.domain.model.Carteirinha
import br.unipar.plano.domain.model.Estado
import br.unipar.plano.domain.model.Municipio
import br.unipar.plano.domain.model.Transporte
import br.unipar.plano.domain.valueobjects.StatusTransporte
import br.unipar.plano.domain.valueobjects.TipoTransporte
import br.unipar.plano.dto.TransporteDTO
import br.unipar.plano.repository.TransporteRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class TransporteServiceImpl(
    private val repository: TransporteRepository,
) : TransporteService {

    override fun buscaTodos(): MutableIterable<Transporte> = repository.findAll()

    override fun buscarPorId(id: UUID): Transporte = repository.findById(id)

    override fun solicitarTransporte(dto: TransporteDTO): Transporte {

        val solicitante = Carteirinha(
            id = UUID.randomUUID()
        )

        val estado = Estado(
            id = UUID.randomUUID(),
            codigoUf = 0,
            uf = "PR",
            nome = "Parana"
        )

        val cidadeOrigem = Municipio(
            id = UUID.randomUUID(),
            codigoIBGE = "12345",
            nome = "Toledo",
            estado = estado,
        )

        val cidadeDestino = Municipio(
            id = UUID.randomUUID(),
            codigoIBGE = "54321",
            nome = "Cascavel",
            estado = estado,
        )

        val transporte = Transporte(
            id = UUID.randomUUID(),
            solicitante = solicitante,
            cidadeOrigem=  dto.cidadeOrigem,
            cidadeDestino = dto.cidadeDestino,
            tipoTransporte = TipoTransporte.AMBULANCIA,
        )

        return repository.save(transporte)
    }

    override fun cancelarSolicitacaoTransporte(dto: TransporteDTO): Transporte {
        val solicitante = Carteirinha(
            id = UUID.randomUUID()
        )

        val transporte = Transporte(
            id = UUID.randomUUID(),
            solicitante = solicitante,
            cidadeOrigem=  dto.cidadeOrigem,
            cidadeDestino = dto.cidadeDestino,
            status= StatusTransporte.CANCELADO,
            tipoTransporte = TipoTransporte.AMBULANCIA,
        )

        return repository.save(transporte)
    }

}