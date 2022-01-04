package com.meli.domain.pessoa.usecase

interface PessoaAllGet {
    fun process(): ArrayList<com.meli.domain.pessoa.entity.Pessoa>
}