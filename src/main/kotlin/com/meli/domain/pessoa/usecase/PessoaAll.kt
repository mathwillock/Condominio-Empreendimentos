package com.meli.domain.pessoa.usecase

import com.meli.domain.entity.GetAllPessoa as Pessoa

interface PessoaAll {
    fun process(idPessoa: Long): Pessoa
}