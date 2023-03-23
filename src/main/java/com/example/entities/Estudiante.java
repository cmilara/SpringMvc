/*
 * Comentario en formato Javadoc
 */
package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private Genero genero;
    private double beca;
 


    // Relacionar unos estudiantes a una facultad
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    //asi creo la relacion externa
    @JoinColumn (name = "idFacultad")

    private Facultad facultad;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "estudiante")
    private List <Telefono> telefonos;

;
   
    public enum Genero{
        HOMBRE, MUJER, OTRO
    }



}
