/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:10:41
 */
package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.entity.Payment;
import com.example.Hotel.managment.system.service.PaymentService;
import com.example.Hotel.managment.system.service.dto.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public ResponseEntity<?> create(@RequestBody PaymentDto paymentDto) throws URISyntaxException {
        PaymentDto result = paymentService.create(paymentDto);
        return ResponseEntity.created(new URI("/api/payment/create" + result.getId())).body(result);
    }

    @PutMapping("/payment/update/{id}")
    public ResponseEntity<?> update(@RequestBody PaymentDto paymentDto, @PathVariable Long id) throws URISyntaxException {
        if (paymentDto.getId() != 0 && !paymentDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        PaymentDto result = paymentService.update(paymentDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/payment/all")
    public ResponseEntity<?> findAll() {
        List<PaymentDto> findAllPayments = paymentService.findAllPayments();
        return ResponseEntity.ok(findAllPayments);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Payment result = paymentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/payment/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }
}

