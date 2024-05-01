package edu.eci.arep.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arep.domain.Consulta;
import edu.eci.arep.repository.AdministracionRepository;

@Service
public class AdministracionService implements Serializable{
    private final AdministracionRepository administracionRepository;
    @Autowired
    public AdministracionService(AdministracionRepository administracionRepository){
        this.administracionRepository=administracionRepository;
    }
    public Consulta addConsulta(Consulta consulta){
        return administracionRepository.save(consulta);
    }
    public Consulta getConsulta(String consultaId){
        return administracionRepository.findById(consultaId);
    }
    public List<Consulta> getAllConsulta(){
        return administracionRepository.findAll();
    }
    public Consulta updateConsulta(Consulta consulta){
        if(administracionRepository.existsById(consulta.getId())){
            return administracionRepository.save(consulta);
        }
        return null;
    }
    public void deleteConsulta(Long consultaId){
        administracionRepository.deleteById(consultaId);
    }
}
