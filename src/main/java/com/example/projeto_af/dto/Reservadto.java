package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import com.example.projeto_af.model.Veiculomodel;

public class Reservadto {
    private long numero;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Veiculomodel veiculo;
    private double totalReserva;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Veiculomodel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculomodel veiculo) {
        this.veiculo = veiculo;
    }


    
}
