package com.meli.domain.carro.gateway

import com.meli.domain.carro.entity.Carro

interface CarroGateway {
    fun findById(idCarro: Long): Carro?

    fun save(carro: Carro): Any

}