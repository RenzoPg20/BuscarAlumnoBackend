package pe.edu.cibertec.BuscarAlumnoBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.BuscarAlumnoBackend.dto.BusquedaRequest;
import pe.edu.cibertec.BuscarAlumnoBackend.service.BusquedaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BusquedaServiceImpl implements BusquedaService {


    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarAlumno(BusquedaRequest busquedaRequest) throws IOException {
        String[] datosAlumno = null;
        Resource resource = resourceLoader.getResource("classpath:alumnos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (busquedaRequest.codigo().equals(datos[0])) {
                    datosAlumno = datos; // Recuperar todos los datos del alumno
                    break; // Salir del bucle una vez que el alumno ha sido encontrado
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo", e);
        }

        // Simular tiempo de respuesta de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return datosAlumno;
    }

}
