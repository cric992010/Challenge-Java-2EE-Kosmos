package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn (name = "doctor_id")
    private Doctor doctor;

    private LocalDateTime horarioConsulta;
    private String nombrePaciente;



    // Getters y Setters
    public Consultorio getConsultorio() {
        return consultorio;
    }

    public LocalDateTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public Doctor getDoctor() {
        return doctor;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cita cita = (Cita) obj;
        return Objects.equals(consultorio, cita.consultorio) &&
                Objects.equals(doctor, cita.doctor) &&
                Objects.equals(horarioConsulta, cita.horarioConsulta);

    }

    @Override
    public int hashCode() {
        return Objects.hash(consultorio, doctor, horarioConsulta);
    }

}
