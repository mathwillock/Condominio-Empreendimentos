package com.meli.application.entrypoint

import com.meli.application.dataprovider.carro.repository.entity.mapper.CarroMappers
import com.meli.domain.carro.entity.Carro
import com.meli.application.dataprovider.carro.repository.entity.Carro as CarroForm
import com.meli.domain.carro.usecase.CarroAll
import com.meli.domain.carro.usecase.CarroAllSave
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus.*
import io.micronaut.http.annotation.*

@Controller("/carros")
class CarroEntryPoint(
    private val carroMappers: CarroMappers,
    private val carroAll: CarroAll,
    private val carroAllSave: CarroAllSave,
) {

    @Get("/{idCarro}")
    fun getCarroId(@QueryValue idCarro: Long) = when(carroAll.process(idCarro)){
        null -> HttpResponse.notFound()
        else -> HttpResponse.ok(carroAll.process(idCarro))
    }

    @Post("/")
    fun save(@Body carro: CarroForm) = when(carroAllSave.process(carroMappers.toDomain(carro))) {
        null -> HttpResponse.status<Status>(CONFLICT)
        else -> HttpResponse.ok(carroAllSave.process(carroMappers.toDomain(carro)))
    }


}