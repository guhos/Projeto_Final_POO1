package com.example.projeto_af.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projeto_af.model.Reservamodel;

import org.springframework.stereotype.Component;

@Component
public class Reservarepos {
    private ArrayList<Reservamodel> reservas = new ArrayList<Reservamodel>();
    private static int nextNumero=1;

    public List<Reservamodel> getAllReservas(){
        return reservas;
    }

    public Optional<Reservamodel> getReservaByNumero(int numero){
        for (Reservamodel aux : reservas){
            if(aux.getNumero() == numero){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Reservamodel save(Reservamodel reserva){
        reserva.setNumero(nextNumero++);
        reservas.add(reserva);
        return reserva;
    }
}
