package br.unipar.plano.interfaces.rest.solicitacaoprocedimento.factories

import br.unipar.plano.interfaces.rest.centrais.CentralDTO
import br.unipar.plano.interfaces.rest.centrais.EnderecoDTO
import br.unipar.plano.interfaces.rest.centrais.factories.enderecoDTO

fun SolicitacaoProcedimentoDTO(
    nome: String = "Costa Oeste PR",
    cnpj: String = "69.036.127/0001-67",
    endereco: EnderecoDTO = enderecoDTO()
) = CentralDTO(
    nome = nome,
    cnpj = cnpj,
    endereco = endereco
)