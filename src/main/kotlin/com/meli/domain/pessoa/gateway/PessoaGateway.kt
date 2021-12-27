package com.meli.domain.pessoa.gateway

import com.meli.domain.pessoa.entity.Pessoa

interface PessoaGateway {
    fun findById(id: Long): Pessoa

    fun save(pessoa: Pessoa)

    fun delete(id: Long)
}