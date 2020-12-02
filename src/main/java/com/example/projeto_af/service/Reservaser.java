package com.example.projeto_af.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.Reservadto;
import com.example.projeto_af.model.Clientmodel;
import com.example.projeto_af.model.Reservamodel;
import com.example.projeto_af.repository.Reservarepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class Reservaser {

    @Autowired
    private Reservarepos repositorio;

    @Autowired
    private ClientSer clienteService;

   
    
    public Reservadto toDTO(Reservamodel reserva){
        Reservadto dto = new Reservadto();
        dto.setInicio(reserva.getInicio());
        dto.setFim(reserva.getFim());
        dto.setVeiculo(reserva.getVeiculo());
        dto.setNumero(reserva.getNumero());
        return dto;
    }

    public List<Reservadto> toListDTO(List<Reservamodel> reservas){
        ArrayList<Reservadto> dtoList = new ArrayList<Reservadto>();

        for(Reservamodel reserva : reservas){
            dtoList.add(toDTO(reserva));
        }
        return dtoList;
    }

    public List<Reservamodel> getAllReservas(){
        return repositorio.getAllReservas();
    }

    public Reservamodel getReservaByNumero(int numero){
        Optional <Reservamodel> op = repositorio.getReservaByNumero(numero);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não cadastrado"));
    }

    public Reservamodel salvar(Reservamodel reserva, int codigoClient){
        Clientmodel cliente = clienteService.getClienteByCodigo(codigoClient);
        reserva.setInicio(LocalDateTime.now());

        //Associar um pedido com cliente e o cliente com o pedido
        reserva.setCliente(cliente);
        cliente.addReserva(reserva);

        return repositorio.save(reserva);
    }
}
