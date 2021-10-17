package br.unipar.plano.domain.model

import java.util.*

// https://github.com/kelvins/Municipios-Brasileiros/blob/main/csv/estados.csv
class Estado(
    val id: UUID,
    val codigoUf: Int ,
    val uf: String,
    val nome: String,
) {

}