package com.meli.application.dataprovider.carro.repository.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Carro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCarro: Long,
    val nome: String,
    val placa: String
)