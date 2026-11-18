package ar.utn.tup.service;

import ar.edu.utn.tup.dto.NuevaSolicitudDTO;
import ar.edu.utn.tup.model.*;
import ar.edu.utn.tup.repository.SolicitudRepository;
import ar.edu.utn.tup.repository.SolicitudRepositoryMemoria;
import ar.edu.utn.tup.service.SolicitudService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolicitudServiceTest {

    @Test
    public void testRegistrarYCambiarEstadoExitoso() {
        SolicitudRepository repo = new SolicitudRepositoryMemoria();
        SolicitudService service = new SolicitudService(repo);

        NuevaSolicitudDTO dto = new NuevaSolicitudDTO(
                "Certificado", Prioridad.ALTA,
                new Estudiante("L999", "Test User", "test@mail.com"),
                "Prueba unitaria"
        );

        Solicitud creada = service.registrarSolicitud(dto);
        assertNotNull(creada);
        assertEquals(EstadoSolicitud.PENDIENTE, creada.getEstado());

        service.cambiarEstado(creada.getId(), EstadoSolicitud.EN_PROCESO);
        assertEquals(EstadoSolicitud.EN_PROCESO, creada.getEstado());
    }
}