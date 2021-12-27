package com.meli.application.entrypoint

import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import com.meli.domain.pessoa.usecase.PessoaAll
import com.meli.domain.pessoa.usecase.PessoaAllSave
import com.meli.domain.pessoa.usecase.PesssoaAllDelete
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/pessoa")
class PessoaEntryPoint(
    private val pessoaAll: PessoaAll,
    private val pessoaAllSave: PessoaAllSave,
    private val pessoaAllDelete: PesssoaAllDelete
) {
    @Get("{idPessoa}")
    fun getCarro(@QueryValue idPessoa: Long) = HttpResponse.ok(
        pessoaAll.process(idPessoa)
    )

    @Post("/salvar")
    fun savePessoa(@Body pessoa: PessoaForm):String {
        HttpResponse.created(
            pessoaAllSave.process(pessoa.id, pessoa.nome, pessoa.sobrenome, pessoa.carro, pessoa.cpf)
        )
        return "Nome:${pessoa.nome} | CPF:${pessoa.cpf}, está salvo no relatório!"
    }

    @Delete("/deletar/{idPessoa}")
    fun deletePessoa(@QueryValue idPessoa: Long): String {

        HttpResponse.ok(
            pessoaAllDelete.process(idPessoa)
        )
        return "O Id: $idPessoa, está excluído do relatório!"
    }



}