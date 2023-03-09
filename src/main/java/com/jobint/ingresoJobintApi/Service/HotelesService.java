package com.jobint.ingresoJobintApi.Service;

import java.util.List;
import com.jobint.ingresoJobintApi.Dto.HotelesDto;

public interface HotelesService {

    public List<HotelesDto> getAllHotelesDisponibles(String destino);
}
