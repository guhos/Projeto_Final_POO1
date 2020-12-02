package com.example.projeto_af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.projeto_af.dto.Veiculodto;
import com.example.projeto_af.model.Veiculomodel;
import com.example.projeto_af.service.VeiculoSer;

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
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoSer veiculoSer;

    @GetMapping()
    public List<Veiculomodel> getVeiculos(){
        return veiculoSer.getAllVeiculos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Veiculomodel> getVeiculos(@PathVariable int codigo){
        Veiculomodel veiculo = veiculoSer.getVeiculoByCodigo(codigo);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@Valid @RequestBody Veiculodto veiculodto, HttpServletRequest request, UriComponentsBuilder builder){
        Veiculomodel veiculo = veiculoSer.fromDTO(veiculodto);

        veiculo = veiculoSer.save(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + veiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo) {
        veiculoSer.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Veiculomodel> atualizar(@PathVariable int codigo, @RequestBody Veiculodto veiculodto){
        Veiculomodel veiculo = veiculoSer.fromDTO(veiculodto);
        veiculo.setCodigo(codigo);
        veiculo = veiculoSer.update(veiculo);
        return ResponseEntity.ok(veiculo);
    }

}    


