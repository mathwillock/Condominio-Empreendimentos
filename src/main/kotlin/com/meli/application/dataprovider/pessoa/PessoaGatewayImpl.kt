package com.meli.application.dataprovider.pessoa
import com.meli.application.dataprovider.pessoa.repository.PessoaRepository
import com.meli.application.dataprovider.pessoa.repository.entity.mapper.PessoaMappers
import com.meli.domain.pessoa.entity.Pessoa
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import com.meli.domain.pessoa.gateway.PessoaGateway
import jakarta.inject.Singleton

@Singleton
class PessoaGatewayImpl(
    private val pessoaRepository: PessoaRepository,
    private val pessoaMappers: PessoaMappers
): PessoaGateway {

    override fun findById(id: Long) = try {
        pessoaMappers.toDomain(
            pessoaRepository.findById(id).get()
        )
    } catch( e: NoSuchElementException )  {
        null
    }

    override fun save(pessoa: Pessoa) = pessoaRepository.save(
        pessoaMappers.toApplication(pessoa)
    )

    override fun delete(id: Long) = pessoaRepository.delete(
        pessoaRepository.findById(id).get()
    )

    override fun update(pessoa: Pessoa): PessoaForm = pessoaRepository.update(
        PessoaForm(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
    )

    override fun findByCpf(cpf: Long) = pessoaRepository
    .findByCpf(cpf)?.let {
        pessoaMappers.toDomain(it)
    }

    override fun findAll(): ArrayList<Pessoa> {
        val pessoaAll = arrayListOf<Pessoa>()
        for (item in pessoaRepository.findAll()){
            pessoaAll.add(pessoaMappers.toDomain(item))
        }
        return pessoaAll
    }

}


