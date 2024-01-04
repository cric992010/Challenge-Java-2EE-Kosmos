package com.example.hospital.repository;

import com.example.hospital.model.Cita;
import com.example.hospital.model.Consultorio;
import com.example.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository <Cita, Long> {
    List<Cita> findByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);

    List<Cita> findByConsultorioAndHorarioConsultaBetween(Consultorio consultorio, LocalDateTime start, LocalDateTime end);

    boolean existsByConsultorioAndHorarioConsulta(Consultorio consultorio, LocalDateTime horarioConsulta);

    long countByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
}
