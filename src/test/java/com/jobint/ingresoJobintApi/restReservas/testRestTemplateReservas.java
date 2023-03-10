package com.jobint.ingresoJobintApi.restReservas;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import com.jobint.ingresoJobintApi.Dto.ResponseReservasDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testRestTemplateReservas {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    int randomServerPort;

    //Test donde me trae todos los hoteles disponibles ingresando como parametro el destino
    @Test
    public void testGetReservasVuelosSuccess() throws URISyntaxException
    {
        testRestTemplate.getRestTemplate().getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        //destinos Paris,Rome,
        String destino="Rome";
        ResponseEntity<ResponseReservasDto[]> respuesta = testRestTemplate.getForEntity("http://localhost:"+randomServerPort+"/api/ingresoJobint/reservas/"+destino,ResponseReservasDto[].class);
        List<ResponseReservasDto> reservasVuelos = Arrays.asList(respuesta.getBody());
        assertEquals(HttpStatus.OK,respuesta.getStatusCode());
    }
}
