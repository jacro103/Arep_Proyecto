package edu.eci.arep.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arep.domain.Consulta;
import edu.eci.arep.domain.Inventario;
import edu.eci.arep.repository.InventarioRepository;

@Service
public class InventarioService implements Serializable{

    private final InventarioRepository inventarioRepository;
    @Autowired
    public InventarioService(InventarioRepository inventarioRepository){
        this.inventarioRepository=inventarioRepository;
    }
    public Inventario addInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }
    public Inventario getConsulta(String inventarioId){
        return inventarioRepository.findById(inventarioId);
    }
    public List<Inventario> getAllInventario(){
        return inventarioRepository.findAll();
    }
    public Inventario updateConsulta(Inventario inventario){
        if(inventarioRepository.existsById(inventario.getId())){
            return inventarioRepository.save(inventario);
        }
        return null;
    }
    public void deleteInventario(Long inventarioId){
        inventarioRepository.deleteById(inventarioId);
    }
}
