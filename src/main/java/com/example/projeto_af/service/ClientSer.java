package com.example.projeto_af.service;


import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.Clientdto;
import com.example.projeto_af.model.Clientmodel;
import com.example.projeto_af.repository.Clientrepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientSer {

    @Autowired
    private Clientrepos repositorio;
    
    public Clientmodel fromDTO(Clientdto dto){
        
        Clientmodel cliente = new Clientmodel();
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

    public List<Clientmodel> getAllClientes(){
        return repositorio.getAllClientes();
    }
        
    public Clientmodel getClienteByCodigo(int codigo) {
        Optional<Clientmodel> op = repositorio.getClienteByCodigo(codigo);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado."));
    }
    
    public Clientmodel save(Clientmodel cliente){
        return repositorio.save(cliente);
    }
    
    public void removeByCodigo(int codigo){
        repositorio.remove(getClienteByCodigo(codigo));
    }
    
    public Clientmodel update(Clientmodel cliente){
        getClienteByCodigo(cliente.getCodigo());
        return repositorio.update(cliente);
    }
    
}

    

