package edu.eci.arep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arep.domain.Consulta;

@Repository
public interface AdministracionRepository extends JpaRepository<Consulta, Long>{
    boolean existsById(String consultaId);
    Consulta findById(String consultaId);
}