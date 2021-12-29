package com.meli.application.dataprovider.pessoa.repository.entity.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.meli.domain.pessoa.entity.Pessoa
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import jakarta.inject.Inject
import org.mapstruct.Mapper

@Mapper
abstract class PessoaMappers {

    @Inject
    private lateinit var objectMapper: ObjectMapper

    abstract fun toDomain(pessoaForm: PessoaForm): Pessoa

    abstract fun toApplication(pessoa: Pessoa): PessoaForm

}