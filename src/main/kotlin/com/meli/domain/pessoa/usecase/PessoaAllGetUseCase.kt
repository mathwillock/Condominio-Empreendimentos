package com.meli.domain.pessoa.usecase

import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa
import com.meli.domain.pessoa.gateway.PessoaGateway
import javax.inject.Singleton

@Singleton
class PessoaAllGetUseCase(
    private val pessoaGateway: PessoaGateway
): PessoaAllGet {
    override fun process(): ArrayList<Pessoa> {
        return pessoaGateway.findAll()
    }
}