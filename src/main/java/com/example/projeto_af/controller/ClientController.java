package com.example.projeto_af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.projeto_af.dto.Clientdto;
import com.example.projeto_af.dto.Reservadto;
import com.example.projeto_af.model.Clientmodel;
import com.example.projeto_af.model.Reservamodel;
import com.example.projeto_af.service.ClientSer;
import com.example.projeto_af.service.Reservaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientSer clientSer;

    @Autowired
    private Reservaser reservaser;

    @GetMapping()
    public List<Clientmodel> getClients() {
        return clientSer.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Clientmodel> getClients(@PathVariable int codigo) {
        Clientmodel Client = clientSer.getClienteByCodigo(codigo);
        return ResponseEntity.ok(Client);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@Valid @RequestBody Clientdto clientdto, HttpServletRequest request, UriComponentsBuilder builder){
        Clientmodel Client = clientSer.fromDTO(clientdto);

        Client = clientSer.save(Client);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + Client.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build(); 
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        clientSer.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Clientmodel> atualizar(@PathVariable int codigo, @RequestBody Clientdto clientedto){
        
        Clientmodel client = clientSer.fromDTO(clientedto);
        client.setCodigo(codigo);
        client = clientSer.update(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("{id}/veiculos/{codigo}")
    public ResponseEntity<Void> salvar(@PathVariable int id, @RequestBody Reservamodel reserva, HttpServletRequest request, UriComponentsBuilder builder){
        reserva = reservaser.salvar(reserva, id);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + reserva.getNumero()).build();
        return ResponseEntity.created(uriComponents.toUri()).build(); 
    }

    @GetMapping("{id}/reservas")
    public List<Reservadto> getReservasCliente(@PathVariable int id){

        Clientmodel client = clientSer.getClienteByCodigo(id);
        return reservaser.toListDTO(client.getReservas());
    }
}

