package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.entity.Pessoa

interface PessoaAllGetCpf {
    fun process(cpfPessoa: Long): Pessoa?
}