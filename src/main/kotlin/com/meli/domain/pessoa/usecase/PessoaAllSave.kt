package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.entity.Pessoa


interface PessoaAllSave {
    fun process(
        pessoa: Pessoa
    ): Any?
}