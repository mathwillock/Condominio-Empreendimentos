package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PessoaAllUpdateUseCase(
    private val pessoaGateway: PessoaGateway
): PessoaAllUpdate {
    override fun process(
        idPessoa: Long,
        nomePessoa: String,
        sobrenomePessoa: String,
        carroPessoa: String?,
        cpfPessoa: Long
    ) {
        pessoaGateway.update(
            Pessoa(idPessoa, nomePessoa, sobrenomePessoa, carroPessoa, cpfPessoa)
        )
    }
}