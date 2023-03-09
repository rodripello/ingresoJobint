package com.jobint.ingresoJobintApi.Controller;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import com.jobint.ingresoJobintApi.Service.HotelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingresoJobint/hoteles")
public class HotelesController {

    @Autowired
    private HotelesService hotelesService;

    @GetMapping("/{destino}")
    public ResponseEntity<List<HotelesDto>> getAllHotelesDisponibles(@PathVariable("destino") String destino){
        return new ResponseEntity<>(hotelesService.getAllHotelesDisponibles(destino), HttpStatus.OK);
    }
}
