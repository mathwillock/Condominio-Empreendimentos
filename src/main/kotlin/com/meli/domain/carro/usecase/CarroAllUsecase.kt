package com.meli.domain.carro.usecase

import com.meli.domain.carro.gateway.CarroGateway
import com.meli.domain.entity.GetAllCarro
import jakarta.inject.Singleton

@Singleton
class CarroAllUsecase(
    private val carroGateway: CarroGateway
): CarroAll {
    override fun process(idCarro: Long): GetAllCarro? {
         val carro = carroGateway.findById(idCarro)

        return if (carro != null) GetAllCarro(carro) else return null


    }
}