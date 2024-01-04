package com.example.hospital.controller;

import com.example.hospital.model.Cita;
import com.example.hospital.servicios.CitaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaServicios citaServicios;


    @PostMapping("/alta")
    public ResponseEntity<String> altaCita(@RequestBody Cita nuevaCita){
        try{
            citaServicios.validarYGuardarCita(nuevaCita);
            return ResponseEntity.ok("cita agendada exitosamente.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Cita> listarTodo(){
        return citaServicios.getAllCitas();
    }


}
