package com.meli.domain.pessoa.usecase

import com.meli.domain.entity.GetAllPessoa
import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PessoaAllUseCase(
    private val pessoaGateway: PessoaGateway
): PessoaAll {
    override fun process(idPessoa: Long): GetAllPessoa? {
        val pessoa = pessoaGateway.findById(idPessoa)

        return if (pessoa != null ) GetAllPessoa(pessoa) else null

    }
}