package com.meli.application.dataprovider.carro

import com.meli.application.dataprovider.carro.repository.CarroRepository
import com.meli.application.dataprovider.carro.repository.entity.mapper.CarroMappers
import com.meli.domain.carro.entity.Carro
import com.meli.domain.carro.gateway.CarroGateway
import jakarta.inject.Singleton
import java.util.NoSuchElementException

@Singleton
class CarroGatewayImpl(
    private val carroRepository: CarroRepository,
    private val carroMappers: CarroMappers
): CarroGateway {
    override fun findById(idCarro: Long) = try {
        carroMappers.toDomain(
            carroRepository.findById(idCarro).get()
        )
    } catch (e: NoSuchElementException) {
        null
    }

    override fun save(carro: Carro) = carroRepository.save(
        carroMappers.toApplication(carro)
    )

    override fun findByPlaca(placa: String) = carroRepository
    .findByPlaca(placa)?.let {
        carroMappers.toDomain(it)
    }
}