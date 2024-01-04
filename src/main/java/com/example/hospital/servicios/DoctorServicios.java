package com.example.hospital.servicios;

import com.example.hospital.repository.DoctorRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServicios {

    @Autowired
    private DoctorRepositoy doctorRepositoy;


}
