package com.meli.application.entrypoint

import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.usecase.*
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/pessoa")
class PessoaEntryPoint(
    private val pessoaAll: PessoaAll,
    private val pessoaAllSave: PessoaAllSave,
    private val pessoaAllDelete: PesssoaAllDelete,
    private val pessoaAllUpdate: PessoaAllUpdate,
    private val pessoaAllGetCpf: PessoaAllGetCpf,
) {
    @Get("/{idPessoa}")
    fun getPessoa(@QueryValue idPessoa: Long): Any? {
        val response = pessoaAll.process(idPessoa)

        val ok = HttpResponse.ok(
            response ?: "Pessoa não encontrada!"
        )
        return ok
    }

    @Post("/salvar")
    fun savePessoa(@Body pessoa: PessoaForm): Any {
        val getCpf = pessoaAllGetCpf.process(pessoa.cpf)

        return if (getCpf != null ) {
            HttpResponse.ok(
                "Pessoa já cadastrada"
            )
        } else {
            pessoaAllSave.process(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
            HttpResponse.created(
                "Nome:${pessoa.nome} CPF:${pessoa.cpf}, está salvo no relatório!"
            )
        }
    }

    @Delete("/deletar/{idPessoa}")
    fun deletePessoa(@QueryValue idPessoa: Long) = try {
        pessoaAllDelete.process(idPessoa)
         HttpResponse.ok(
             "O Id: $idPessoa, está excluído do relatório!"
         )
    } catch (e: NoSuchElementException) {
        HttpResponse.ok(
            "O Id: $idPessoa, não foi encontrado!"
        )
    }

    @Put("/atualizar")
    fun updatePessoa(@Body pessoa: Pessoa): String {

        val getPessoa = pessoaAll.process(pessoa.id)

        if(getPessoa == null ) {
            return "Cheque o id!"
        } else {
            HttpResponse.ok(
                pessoaAllUpdate.process(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
            )
        }
        return "Id: ${pessoa.id} atualizado"
    }

}