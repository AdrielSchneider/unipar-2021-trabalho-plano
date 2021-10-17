package br.unipar.plano.domain.model

import java.util.*

// https://github.com/kelvins/Municipios-Brasileiros/blob/main/csv/municipios.csv
class Municipio(
    val id: UUID,
    val codigoIBGE: String,
    val nome: String,
    val estado: Estado,
) {

}