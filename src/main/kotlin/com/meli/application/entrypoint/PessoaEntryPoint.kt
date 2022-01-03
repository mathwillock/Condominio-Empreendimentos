package com.meli.application.entrypoint

import com.meli.application.dataprovider.pessoa.repository.entity.mapper.PessoaMappers
import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.usecase.*
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus.*
import io.micronaut.http.annotation.*

@Controller("/pessoas")
class PessoaEntryPoint(
    private val pessoaAll: PessoaAll,
    private val pessoaAllSave: PessoaAllSave,
    private val pessoaAllDelete: PesssoaAllDelete,
    private val pessoaAllUpdate: PessoaAllUpdate,
    private val pessoaAllGet: PessoaAllGet,
    private val pessoaMappers: PessoaMappers
) {
    @Get("/")
    fun get() = HttpResponse.ok(pessoaAllGet.process())

    @Get("/{idPessoa}")
    fun getPessoaId(@QueryValue idPessoa: Long) = when(pessoaAll.process(idPessoa)) {
        null -> HttpResponse.status(NOT_FOUND)
        else -> HttpResponse.ok(pessoaAll.process(idPessoa))
    }

    @Post("/")
    fun save(@Body pessoa: PessoaForm) = when(pessoaAllSave.process(pessoaMappers.toDomain(pessoa))) {
        null -> HttpResponse.status(CONFLICT)
        else -> HttpResponse.created(
            "Nome:${pessoa.nome} CPF:${pessoa.cpf}, está salvo no relatório!"
        )
    }

    @Delete("/{idPessoa}")
    fun delete(@QueryValue idPessoa: Long) = try {
        pessoaAllDelete.process(idPessoa)
         HttpResponse.status(NO_CONTENT)
    } catch (e: NoSuchElementException) {
        HttpResponse.notFound("")
    }

    @Put("/")
    fun put(@Body pessoa: Pessoa) = when (pessoaAll.process(pessoa.id)) {
        null -> HttpResponse.notFound("")
        else -> {
            HttpResponse.ok(
                pessoaAllUpdate.process(pessoa)
            )
        }
    }




}