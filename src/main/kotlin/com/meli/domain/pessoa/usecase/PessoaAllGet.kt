package com.meli.domain.pessoa.usecase

import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa


interface PessoaAllGet {
    fun process(): ArrayList<Pessoa>
}