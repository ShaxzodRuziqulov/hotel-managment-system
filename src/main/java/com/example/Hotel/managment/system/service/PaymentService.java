/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:21:33
 */
package com.example.Hotel.managment.system.service;

import com.example.Hotel.managment.system.entity.Payment;
import com.example.Hotel.managment.system.repository.PaymentRepository;
import com.example.Hotel.managment.system.service.dto.PaymentDto;
import com.example.Hotel.managment.system.service.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public PaymentDto create(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        payment = paymentRepository.save(payment);
        return paymentMapper.toDto(payment);
    }

    public PaymentDto update(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        payment = paymentRepository.save(payment);
        return paymentMapper.toDto(payment);
    }

    public List<PaymentDto> findAllPayments() {
        return paymentRepository
                .findAll()
                .stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    public Payment findById(Long id) {
        return paymentRepository
                .findById(id)
                .orElseGet(Payment::new);
    }

}

