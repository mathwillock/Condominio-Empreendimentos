package com.meli.application.entrypoint

import com.meli.domain.pessoa.entity.Pessoa
import com.meli.domain.pessoa.usecase.*
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
) {
    @Get("/")
    fun get() = HttpResponse.ok(pessoaAllGet.process())

    @Get("/{idPessoa}")
    fun getPessoaId(@QueryValue idPessoa: Long) = when(pessoaAll.process(idPessoa)) {
        null -> HttpResponse.status(NOT_FOUND)
        else -> HttpResponse.ok(pessoaAll.process(idPessoa))
    }

    @Post("/")
    fun save(@Body pessoa: Pessoa) = when(
        val pessoaSaved = pessoaAllSave.process(pessoa)
    ) { null -> HttpResponse.status(CONFLICT)
        else -> HttpResponse.created(pessoaSaved)
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