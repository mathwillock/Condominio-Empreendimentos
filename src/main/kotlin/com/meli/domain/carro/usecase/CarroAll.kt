package com.meli.domain.carro.usecase

import com.meli.domain.entity.GetAllCarro as Carro

interface CarroAll{
    fun process(idCarro: Long): Carro?
}
