package com.jobint.ingresoJobintApi.Dto;

import lombok.Data;

@Data
public class VuelosDto {
    private int id;
    private String fechaVuelo;
    private String aereopuertoOrigen;
    private String aereopuertoDestino;
    private String moneda;
    private String precio;
}
