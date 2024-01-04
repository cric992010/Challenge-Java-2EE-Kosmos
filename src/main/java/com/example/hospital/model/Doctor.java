package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;


}
