package com.meli.domain.pessoa.usecase

interface PessoaAllUpdate {
    fun process(
        idPessoa: Long,
        nomePessoa: String,
        sobrenomePessoa:String,
        carroPessoa:String?,
        cpfPessoa: Long
    )
}