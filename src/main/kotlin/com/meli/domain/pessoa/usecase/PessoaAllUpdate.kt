package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.entity.Pessoa

interface PessoaAllUpdate {
    fun process(
        pessoa:Pessoa
    ): Any
}