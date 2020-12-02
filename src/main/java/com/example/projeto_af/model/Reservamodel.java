package com.example.projeto_af.model;

import java.time.LocalDateTime;


public class Reservamodel {
    private int numero;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Clientmodel cliente;
    private double preco;
    private Veiculomodel veiculo;

    public Reservamodel(){
        
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Clientmodel getCliente() {
        return cliente;
    }

    public void setCliente(Clientmodel cliente) {
        this.cliente = cliente;
    }

    public Veiculomodel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculomodel veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", fim=" + fim + ", inicio=" + inicio + ", numero=" + numero + ", preco="
                + preco + ", veiculo=" + veiculo + "]";
    }

    

    

}
