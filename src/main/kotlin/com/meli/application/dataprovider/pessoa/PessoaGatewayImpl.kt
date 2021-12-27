package com.meli.application.dataprovider.pessoa

import com.meli.application.dataprovider.pessoa.repository.PessoaRepository
import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.gateway.PessoaGateway
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import jakarta.inject.Singleton

@Singleton
class PessoaGatewayImpl(
    private val pessoaRepository: PessoaRepository
): PessoaGateway {
    override fun findById(id: Long): Pessoa {
        val pessoa = pessoaRepository.findById(id).get()
        return Pessoa(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
    }

    override fun save(pessoa: Pessoa) {
        pessoaRepository.save(PessoaForm(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf))

    }

    override fun delete(id: Long) {
        val pessoa = pessoaRepository.findById(id).get()
        pessoaRepository.delete(pessoa)

    }
}