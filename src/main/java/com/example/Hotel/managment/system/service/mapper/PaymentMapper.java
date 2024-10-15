/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:24
 */
package com.example.Hotel.managment.system.service.mapper;

import com.example.Hotel.managment.system.entity.Payment;
import com.example.Hotel.managment.system.service.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentDto, Payment> {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "booking.id", target = "bookingId")
    PaymentDto toDto(Payment payment);

    @Mapping(source = "bookingId", target = "booking.id")
    Payment toEntity(PaymentDto paymentDto);
}
