package com.meli.domain.pessoa.usecase

import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PessoaAllSaveUseCase(
    private val pessoaGateway: PessoaGateway,
    private val pessoaAllGetCpf: PessoaAllGetCpf
): PessoaAllSave {
    override fun process(pessoa: Pessoa) =
        when(pessoaAllGetCpf.process(pessoa.cpf)) {
        null -> pessoaGateway.save(pessoa)
        else -> null

    }





}