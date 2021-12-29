package com.meli.domain.entity

data class GetAllPessoa(
    val id: Long,
    val nome: String,
    val sobrenome: String,
    val carro: String?,
    val cpf: Long
)