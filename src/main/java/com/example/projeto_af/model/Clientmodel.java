package com.example.projeto_af.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Clientmodel {
    private int codigo;
    private String nome;
    private String endereco;
    private String cpf;

    @JsonIgnore
    private ArrayList<Reservamodel> reservas = new ArrayList<Reservamodel>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Reservamodel> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reservamodel> reservas) {
        this.reservas = reservas;
    }

    public boolean addReserva(Reservamodel reserva) {
        return reservas.add(reserva);
    }


    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", cpf=" + cpf + ", endereco=" + endereco + ", nome=" + nome + "]";
    }

}

