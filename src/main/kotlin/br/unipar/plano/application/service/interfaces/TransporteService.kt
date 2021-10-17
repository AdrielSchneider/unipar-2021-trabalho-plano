package br.unipar.plano.application.service.interfaces

import java.util.*
import br.unipar.plano.domain.model.Transporte
import br.unipar.plano.application.exception.NegocioException
import br.unipar.plano.application.exception.RegistroNaoEncontradoException
import br.unipar.plano.dto.TransporteDTO

interface TransporteService {

    fun buscaTodos(): MutableIterable<Transporte>

    @Throws(RegistroNaoEncontradoException::class)
    fun buscarPorId(id: UUID): Transporte

    @Throws(NegocioException::class)
    fun solicitarTransporte(dto: TransporteDTO): Transporte

    @Throws(NegocioException::class)
    fun cancelarSolicitacaoTransporte(dto: TransporteDTO): Transporte
}