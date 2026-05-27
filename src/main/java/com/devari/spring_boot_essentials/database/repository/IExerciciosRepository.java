package com.devari.spring_boot_essentials.database.repository;

import com.devari.spring_boot_essentials.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    public List<ExerciciosEntity> findAllByGrupoMusucular(String grupoMuscular);

    @Query(value = """
    SELECT e\s
    FROM ExerciciosEntity e\s
    WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular");
   \s""")
    public List<ExerciciosEntity> findAllByGrupoMusucularjpql(@Param("geupoMuscular") String grupoMuscular);



}
