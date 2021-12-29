package com.meli.domain.pessoa.usecase


interface PessoaAllGetCpf {
    fun process(cpfPessoa: Long): Any?
}