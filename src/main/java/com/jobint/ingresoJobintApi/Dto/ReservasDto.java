package com.jobint.ingresoJobintApi.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReservasDto {

    private int id;
    @JsonProperty("vuelo")
    private VuelosDto vuelo;
    private String estadoReserva;
    private String fechaReserva;
    private String fechaVencimiento;
}
