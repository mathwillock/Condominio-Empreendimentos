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
    private val pessoaAllGetCpf: PessoaAllGetCpf
) {
    @Get("{idPessoa}")
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
    fun deletePessoa(@QueryValue idPessoa: Long): String {

        HttpResponse.ok(
            pessoaAllDelete.process(idPessoa)
        )
        return "O Id: $idPessoa, está excluído do relatório!"
    }

    @Put("/atualizar")
    fun updatePessoa(@Body pessoa: Pessoa): String {

        val getPessoa = pessoaAll.process(pessoa.id)

        if(getPessoa == null ) {
            return "Check a o id!"
        } else {
            HttpResponse.ok(
                pessoaAllUpdate.process(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
            )

        }

        return "Id: ${pessoa.id} atualizado"
    }






}