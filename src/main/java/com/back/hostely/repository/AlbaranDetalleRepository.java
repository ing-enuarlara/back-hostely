package com.back.hostely.repository;

import com.back.hostely.model.AlbaranDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbaranDetalleRepository extends JpaRepository<AlbaranDetalle, Integer> {
    List<AlbaranDetalle> findByAlbaranId(Integer albaranId);
}