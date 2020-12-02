package com.example.projeto_af.service;


import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.Veiculodto;
import com.example.projeto_af.model.Veiculomodel;
import com.example.projeto_af.repository.Veiculorepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoSer {

    @Autowired
    private Veiculorepos repositorio;

    public Veiculomodel fromDTO(Veiculodto dto){
        
        Veiculomodel veiculo = new Veiculomodel();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValorDiaria(dto.getValorDiaria());
        return veiculo;
    }

    public List<Veiculomodel> getAllVeiculos(){
        return repositorio.getAllVeiculos();
    }

    public Veiculomodel getVeiculoByCodigo(int codigo){
        Optional<Veiculomodel> op = repositorio.getVeiculoByCodigo(codigo);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Veiculo nao cadastrado"));
    }

    public Veiculomodel save(Veiculomodel veiculo){
        return repositorio.save(veiculo);
    }

    public void removeByCodigo(int codigo){
        repositorio.remove(getVeiculoByCodigo(codigo));
    }

    public Veiculomodel update(Veiculomodel veiculo){
        getVeiculoByCodigo(veiculo.getCodigo());
        return repositorio.update(veiculo);
    }
    
}
