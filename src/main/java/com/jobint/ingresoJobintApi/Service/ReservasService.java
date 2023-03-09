package com.jobint.ingresoJobintApi.Service;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import com.jobint.ingresoJobintApi.Dto.ReservasDto;
import com.jobint.ingresoJobintApi.Dto.ResponseReservasDto;

import java.util.List;

public interface ReservasService {
    public List<ResponseReservasDto> getallReservas();
    public ReservasDto getReserva(int id);

}
