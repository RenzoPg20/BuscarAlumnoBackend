package pe.edu.cibertec.BuscarAlumnoBackend.service;

import pe.edu.cibertec.BuscarAlumnoBackend.dto.BusquedaRequest;

import java.io.IOException;

public interface BusquedaService {


    String[] buscarAlumno(BusquedaRequest busquedaRequest)throws IOException;



}
