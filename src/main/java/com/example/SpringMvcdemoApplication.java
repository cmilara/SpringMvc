package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcdemoApplication implements CommandLineRunner {

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;


	public static void main(String[] args) {
		SpringApplication.run(SpringMvcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Agregar registros de muestra para Facultad, Estudiante y Teléfono
		 */


		 facultadService.save(
			Facultad.builder()
			.nombre("Informática")
			.build()
		 );

		facultadService.save(
			Facultad.builder()
			.nombre("Biologia")
			.build()
			);


		estudianteService.save(
			Estudiante.builder()
			.id(1)
			.nombre("Elisabeth")
			.primerApellido("Agulló")
			.segundoApellido("Garcia")
			.fechaAlta(LocalDate.of(2018, Month.JANUARY,1))
			.fechaNacimiento(LocalDate.of(1995,Month.JANUARY,1))
			.genero(Genero.MUJER)
			.beca(6500.00)
			.facultad(facultadService.findById(1))
			.build()
			);
		telefonoService.save(
			Telefono.builder()
			.id(1)
			.numero("611221122")
			.estudiante(estudianteService.findById(1))
			.build()
		);	
		telefonoService.save(
			Telefono.builder()
			.id(2)
			.numero("968832542")
			.estudiante(estudianteService.findById(1))
			.build()
		);	
		

	}

}
