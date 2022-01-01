package com.meli.domain.pessoa.gateway

import com.meli.domain.pessoa.entity.Pessoa

interface PessoaGateway {
    fun findById(id: Long): Pessoa?

    fun save(pessoa: Pessoa): Any?

    fun delete(id: Long): Any?

    fun update(pessoa: Pessoa): Any

    fun findByCpf(cpf: Long): Any?

}