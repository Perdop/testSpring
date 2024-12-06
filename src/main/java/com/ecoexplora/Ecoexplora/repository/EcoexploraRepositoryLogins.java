package com.ecoexplora.Ecoexplora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoexplora.Ecoexplora.model.Logins;

public interface EcoexploraRepositoryLogins extends JpaRepository<Logins,Integer> {
    Optional<Logins> findByUser(String user);
    
}
