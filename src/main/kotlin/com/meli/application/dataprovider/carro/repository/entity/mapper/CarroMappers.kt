package com.meli.application.dataprovider.carro.repository.entity.mapper

import com.meli.domain.carro.entity.Carro
import com.meli.application.dataprovider.carro.repository.entity.Carro as CarroForm
import org.mapstruct.Mapper

@Mapper
abstract class CarroMappers {

    abstract fun toDomain(carroForm: CarroForm): Carro

    abstract fun toApplication(carro: Carro): CarroForm


}