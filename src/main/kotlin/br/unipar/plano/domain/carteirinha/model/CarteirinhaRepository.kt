package br.unipar.plano.domain.carteirinha.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarteirinhaRepository : JpaRepository<Carteirinha, IdCarteirinha>