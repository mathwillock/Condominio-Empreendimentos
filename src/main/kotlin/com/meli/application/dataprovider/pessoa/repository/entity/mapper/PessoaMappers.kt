package com.meli.application.dataprovider.pessoa.repository.entity.mapper

import com.meli.domain.pessoa.entity.Pessoa
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import org.mapstruct.Mapper

@Mapper
abstract class PessoaMappers {

    abstract fun toDomain(pessoaForm: PessoaForm): Pessoa

    abstract fun toApplication(pessoa: Pessoa): PessoaForm

}