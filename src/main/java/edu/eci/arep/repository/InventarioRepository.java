package edu.eci.arep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import edu.eci.arep.domain.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    boolean existsById(String inventarioId);
    Inventario findById(String inventarioId);
}
