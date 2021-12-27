package com.meli.domain.pessoa.entity

data class Pessoa(
    val id: Long,
    val nome: String,
    val sobrenome: String,
    val carro: String?,
    val cpf: Int
)