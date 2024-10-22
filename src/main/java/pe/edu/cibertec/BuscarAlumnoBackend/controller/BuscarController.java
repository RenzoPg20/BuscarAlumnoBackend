package pe.edu.cibertec.BuscarAlumnoBackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.BuscarAlumnoBackend.dto.BusquedaRequest;
import pe.edu.cibertec.BuscarAlumnoBackend.dto.BusquedaResponse;
import pe.edu.cibertec.BuscarAlumnoBackend.service.BusquedaService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/busqueda")
public class BuscarController {

    @Autowired
    BusquedaService busquedaService;

    @PostMapping("/buscar")
    public BusquedaResponse buscando(@RequestBody BusquedaRequest busquedaRequest){


        try {
            String[] datosAlumno=busquedaService.buscarAlumno(busquedaRequest);


            if(datosAlumno == null){
                return new BusquedaResponse("01","","","","");
            }

                return new BusquedaResponse(datosAlumno[0],datosAlumno[1],datosAlumno[2],datosAlumno[3],datosAlumno[4]);

        }catch (IOException e){

            return new BusquedaResponse("99","","","","");
        }

    }







    }




