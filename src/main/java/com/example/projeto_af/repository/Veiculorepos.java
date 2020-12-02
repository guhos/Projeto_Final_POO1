package com.example.projeto_af.repository;

import java.util.List;
import java.util.Optional;

import com.example.projeto_af.model.Veiculomodel;

import org.springframework.stereotype.Component;

@Component
public class Veiculorepos {
    
    private List <Veiculomodel> veiculos;
    private int nextCode;

    public List<Veiculomodel> getAllVeiculos(){
        return veiculos;
    }

    public Optional<Veiculomodel> getVeiculoByCodigo(int codigo){
        for(Veiculomodel aux: veiculos){
            if(aux.getCodigo() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Veiculomodel save(Veiculomodel veiculo){

        veiculo.setCodigo(nextCode++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public void remove(Veiculomodel veiculo){
        veiculos.remove(veiculo);
    }

    public Veiculomodel update(Veiculomodel veiculo){

        Veiculomodel aux = getVeiculoByCodigo(veiculo.getCodigo()).get();

        if(aux != null){
            aux.setModelo(veiculo.getModelo());
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }
}

