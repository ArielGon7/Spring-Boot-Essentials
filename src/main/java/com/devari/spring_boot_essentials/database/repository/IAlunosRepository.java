package com.devari.spring_boot_essentials.database.repository;

import com.devari.spring_boot_essentials.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
}
