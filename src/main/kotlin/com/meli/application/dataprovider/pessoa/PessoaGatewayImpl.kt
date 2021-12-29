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
    override fun findById(id: Long): Pessoa? {
        return try {
            val pessoa = pessoaRepository.findById(id).get()
            Pessoa(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
        } catch( e: NoSuchElementException )  {
            null
        }

    }

    override fun save(pessoa: Pessoa): PessoaForm? {

        return pessoaRepository.save(
            PessoaForm(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
        )

    }

    override fun delete(id: Long) {
        pessoaRepository.delete(
            pessoaRepository.findById(id).get()
        )
    }

    override fun update(pessoa: Pessoa) {
        pessoaRepository.update(
            PessoaForm(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
        )
    }

    override fun findByCpf(cpf: Long): Any? =
        pessoaRepository.findByCpf(cpf)?.let {
                pessoa -> Pessoa(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
        }

}


