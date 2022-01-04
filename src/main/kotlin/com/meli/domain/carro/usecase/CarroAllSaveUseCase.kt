package com.meli.domain.carro.usecase

import com.meli.domain.carro.entity.Carro
import com.meli.domain.carro.gateway.CarroGateway
import jakarta.inject.Singleton

@Singleton
class CarroAllSaveUseCase(
    private val carroGateway: CarroGateway
): CarroAllSave {
    override fun process(carro: Carro): Any {
        return carroGateway.save(carro)
    }
}