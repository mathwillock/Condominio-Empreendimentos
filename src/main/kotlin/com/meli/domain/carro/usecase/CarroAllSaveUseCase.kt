package com.meli.domain.carro.usecase

import com.meli.domain.carro.entity.Carro
import com.meli.domain.carro.gateway.CarroGateway
import jakarta.inject.Singleton

@Singleton
class CarroAllSaveUseCase(
    private val carroGateway: CarroGateway,
    private val carroAllGetPlaca: CarroAllGetPlaca
): CarroAllSave {
    override fun process(carro: Carro) = when(carroAllGetPlaca.process(carro.placa)) {
        null -> carroGateway.save(carro)
        else -> null
    }
}