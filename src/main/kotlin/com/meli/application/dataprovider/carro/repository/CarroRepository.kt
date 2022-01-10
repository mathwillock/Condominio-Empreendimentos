package com.meli.application.dataprovider.carro.repository

import io.micronaut.data.annotation.Repository
import com.meli.application.dataprovider.carro.repository.entity.Carro
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarroRepository: JpaRepository<Carro, Long> {
    fun findByPlaca(placa: String): Carro?

}