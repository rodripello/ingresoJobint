package com.jobint.ingresoJobintApi.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseReservasDto {

    @JsonProperty("results")
    private List<ReservasDto> response;

}
