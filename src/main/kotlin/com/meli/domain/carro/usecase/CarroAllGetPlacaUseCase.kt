package com.meli.domain.carro.usecase

import com.meli.domain.carro.gateway.CarroGateway
import javax.inject.Singleton

@Singleton
class CarroAllGetPlacaUseCase(
    private val carroGateway: CarroGateway
): CarroAllGetPlaca {
    override fun process(placa: String) = carroGateway.findByPlaca(placa)
}