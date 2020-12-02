package com.example.projeto_af.controller;

import java.util.List;

import com.example.projeto_af.model.Reservamodel;
import com.example.projeto_af.service.Reservaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private Reservaser service;

    @GetMapping()
    public List<Reservamodel> getReservas(){
        return service.getAllReservas();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Reservamodel> getReservaByNumero(@PathVariable int numero){
        Reservamodel reserva = service.getReservaByNumero(numero);
        return ResponseEntity.ok(reserva);
    }

}