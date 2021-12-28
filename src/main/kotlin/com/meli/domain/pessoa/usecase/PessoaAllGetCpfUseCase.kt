package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PessoaAllGetCpfUseCase(
    private val pessoaGateway: PessoaGateway
): PessoaAllGetCpf {
    override fun process(cpfPessoa: Int): Any? {
        return pessoaGateway.findByCpf(cpfPessoa)
    }

}