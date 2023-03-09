package com.jobint.ingresoJobintApi.Controller;

import com.jobint.ingresoJobintApi.Dto.ReservasDto;
import com.jobint.ingresoJobintApi.Dto.ResponseReservasDto;
import com.jobint.ingresoJobintApi.Service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingresoJobint/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping
    public ResponseEntity<List<ResponseReservasDto>> getAllReservas(){
        return new ResponseEntity<>(reservasService.getallReservas(), HttpStatus.OK);
    }
    

}
