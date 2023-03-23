package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

@Repository
public interface TelefonoDao extends JpaRepository <Telefono, Integer> {
//@Query(value = "delete from telefonos where estudiante id= :idestudiante",nativeQuery = true)
//long deleteByIdEstudiante(@Param("idEstudiante")Integer idEstudiante);

long deleteByEstudiante(Estudiante estudiante);

//List<Telefono>findByEstudiante(Estudiante estudiante);
}
