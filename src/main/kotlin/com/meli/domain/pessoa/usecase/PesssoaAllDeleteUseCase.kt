package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PesssoaAllDeleteUseCase(
    private val pessoaGateway: PessoaGateway
): PesssoaAllDelete {
    override fun process(idPessoa: Long) {
        pessoaGateway.delete(idPessoa)
    }

}