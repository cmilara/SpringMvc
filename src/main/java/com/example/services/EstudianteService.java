package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;


public interface EstudianteService {
public List <Estudiante> findAll();
public Estudiante findById (int idEstudiante);
public void save (Estudiante estudiante);
public void deleteById (int idestudiante);


    
}
