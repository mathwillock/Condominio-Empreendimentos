package com.meli.domain.pessoa.usecase

import com.meli.domain.entity.GetAllPessoa

interface PesssoaAllDelete {
    fun process(idPessoa: Long)
}