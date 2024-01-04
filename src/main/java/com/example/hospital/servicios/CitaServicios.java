package com.example.hospital.servicios;

import com.example.hospital.model.Cita;
import com.example.hospital.model.Consultorio;
import com.example.hospital.repository.CitaRepository;
import com.example.hospital.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServicios {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private ConsultorioRepository consultorioRepository;

    //Metodo para validar y guardar la cita
    public void validarYGuardarCita(Cita nuevaCita) throws Exception{
        validarReglasAltaCita(nuevaCita);

        // Verificar si el Consultorio ya existe en la base de datos
        Consultorio consultorio = consultarConsultorioDesdeLaBaseDeDatos(nuevaCita.getConsultorio());

        // Si no existe, guardarlo antes de guardar la Cita
        if (consultorio == null) {
            consultorio = consultorioRepository.save(nuevaCita.getConsultorio());
        }

        nuevaCita.setConsultorio(consultorio);
        citaRepository.save(nuevaCita);
    }

    //Metodo para validar las reglas del alta de cita.
    private void validarReglasAltaCita(Cita nuevaCita) throws Exception{


        if (citaRepository.existsByConsultorioAndHorarioConsulta(nuevaCita.getConsultorio(), nuevaCita.getHorarioConsulta())) {
            throw new Exception("Ya existe una cita en el mismo consultorio a la misma hora.");
        }

        long citasCount = citaRepository.countByDoctorAndHorarioConsultaBetween(nuevaCita.getDoctor(), nuevaCita.getHorarioConsulta().minusHours(2), nuevaCita.getHorarioConsulta().plusHours(2));
        if (citasCount >= 8) {
            throw new Exception("El doctor ya tiene 8 citas programadas para este día.");
        }

    }

    public List<Cita> getAllCitas(){
        return citaRepository.findAll();
    }

    private Consultorio consultarConsultorioDesdeLaBaseDeDatos(Consultorio consultorio) {
        // Verificar si el Consultorio ya existe en la base de datos por su ID
        Optional<Consultorio> consultorioExistente = consultorioRepository.findById(consultorio.getId());

        return consultorioExistente.orElse(null);
    }
}
