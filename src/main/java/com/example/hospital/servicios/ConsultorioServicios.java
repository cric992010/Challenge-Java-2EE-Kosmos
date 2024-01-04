package com.example.hospital.servicios;

import com.example.hospital.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioServicios {
    @Autowired
    private ConsultorioRepository consultorioRepository;

}
