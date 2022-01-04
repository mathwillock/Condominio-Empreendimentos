package com.meli.domain.carro.usecase

import com.meli.domain.carro.entity.Carro

interface CarroAllSave {
    fun process(carro: Carro): Any
}