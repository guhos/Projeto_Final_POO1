package com.example.projeto_af.dto;

import javax.validation.constraints.NotBlank;

public class Veiculodto {
    
    @NotBlank(message = "Modelo é obrigatório!")
    private String modelo;

    @NotBlank(message = "Valor da Diaria é obrigatório")
    private double valorDiaria;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    

}

