package com.meli.domain.carro.usecase

import com.meli.domain.carro.entity.Carro

interface CarroAllGetPlaca {
    fun process(placa: String): Carro?
}