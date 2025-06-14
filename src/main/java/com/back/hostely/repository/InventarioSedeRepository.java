package com.back.hostely.repository;

import com.back.hostely.model.InventarioSede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioSedeRepository extends JpaRepository<InventarioSede, Integer> {
    List<InventarioSede> findBySedeId(Integer sedeId);
    List<InventarioSede> findByInsumoId(Integer insumoId);
}