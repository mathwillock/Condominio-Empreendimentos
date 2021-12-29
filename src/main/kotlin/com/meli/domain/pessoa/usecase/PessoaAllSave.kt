package com.meli.domain.pessoa.usecase


interface PessoaAllSave {
    fun process(
        idPessoa: Long,
        nomePessoa: String,
        sobrenomePessoa: String,
        carroPessoa: String?,
        cpfPessoa: Long
    )
}