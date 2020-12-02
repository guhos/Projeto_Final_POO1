package com.example.projeto_af.repository;

import java.util.List;
import java.util.Optional;

import com.example.projeto_af.model.Clientmodel;

import org.springframework.stereotype.Component;

@Component
public class Clientrepos {

    private List <Clientmodel> clientes;
    private int nextCode;

    public List<Clientmodel> getAllClientes(){
        return clientes;
    }

    public Optional<Clientmodel> getClienteByCodigo(int codigo){
        for(Clientmodel aux: clientes){
            if(aux.getCodigo() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Clientmodel save(Clientmodel cliente){

        cliente.setCodigo(nextCode++);
        clientes.add(cliente);
        return cliente;

    }

    public void remove(Clientmodel cliente) {
        clientes.remove(cliente);
    }
    
    public Clientmodel update(Clientmodel cliente) {

        Clientmodel aux = getClienteByCodigo(cliente.getCodigo()).get();

        if(aux != null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
            aux.setCpf(cliente.getCpf());
        }
		return aux;
	}
}

