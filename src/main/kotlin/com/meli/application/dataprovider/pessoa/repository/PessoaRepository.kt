package com.meli.application.dataprovider.pessoa.repository

import io.micronaut.data.annotation.Repository
import com.meli.application.dataprovider.pessoa.repository.entity.Pessoa as PessoaForm
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PessoaRepository: JpaRepository<PessoaForm, Long>