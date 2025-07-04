package com.back.hostely.repository;

import com.back.hostely.model.TPV;
import com.back.hostely.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TPVRepository extends JpaRepository<TPV, Long> {
    Optional<TPV> findByIdAndActivaTrue(Long id);
    Optional<TPV> findByClaveAcceso(String claveAcceso);
    Optional<TPV> findBySede(Sede sede);
}