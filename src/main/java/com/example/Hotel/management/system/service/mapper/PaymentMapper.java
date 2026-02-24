/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:24
 */
package com.example.Hotel.management.system.service.mapper;


import com.example.Hotel.management.system.entity.Payment;
import com.example.Hotel.management.system.service.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BookingMapper.class)
public interface PaymentMapper extends EntityMapper<PaymentDto, Payment> {

    @Mapping(source = "booking.id", target = "bookingId")
    PaymentDto toDto(Payment payment);

    @Mapping(source = "bookingId", target = "booking.id")
    Payment toEntity(PaymentDto paymentDto);

    default Payment fromId(Long id) {
        if (id == null || id == 0L) {
            return null;
        }
        Payment payment = new Payment();
        payment.setId(id);
        return payment;
    }
}
