package br.unipar.plano.resource.impl

import br.unipar.plano.application.service.interfaces.TransporteService
import br.unipar.plano.domain.model.Transporte
import br.unipar.plano.dto.TransporteDTO
import br.unipar.plano.resource.TransporteResource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/transporte")
class TransporteResourceImpl(private val service: TransporteService) : TransporteResource {

    @GetMapping
    @ApiResponses(ApiResponse(description = "ok.", responseCode = "200"))
    @Operation(description = "Retorna todas os transportes já registrados.")
    override fun buscaTodos(): ResponseEntity<MutableIterable<Transporte>> = ResponseEntity.ok(service.buscaTodos())

    @GetMapping("/{id}")
    @ApiResponses(
        ApiResponse(description = "ok.", responseCode = "200"),
        ApiResponse(description = "Caso não exista o transporte.", responseCode = "404")
    )
    @Operation(description = "Retorna o trasnporte a partir do ID informado.")
    override fun buscaPorId(@PathVariable("id") id: UUID): ResponseEntity<Transporte> = ResponseEntity.ok(service.buscarPorId(id))

    @PostMapping
    @ApiResponses(
        ApiResponse(description = "ok.", responseCode = "200"),
        //ApiResponse(description = "Caso já exista uma cobrança não cancelada no mês e ano informado.", responseCode = "400"),
        //ApiResponse(description = "Caso seja requisitado um registro de cobrança com data futura.", responseCode = "400")
    )
    @Operation(description = "Registra uma solicitação de transporte.")
    override fun solicitarTransporte(@RequestBody dto: TransporteDTO): ResponseEntity<Void> {
        val transporte = service.solicitarTransporte(dto)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transporte.id).toUri()
        return ResponseEntity.created(uri).build()
    }

}