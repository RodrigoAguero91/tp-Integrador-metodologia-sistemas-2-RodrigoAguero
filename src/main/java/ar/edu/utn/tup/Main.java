package ar.edu.utn.tup;

import ar.edu.utn.tup.dto.NuevaSolicitudDTO;
import ar.edu.utn.tup.model.*;
import ar.edu.utn.tup.repository.SolicitudRepository;
import ar.edu.utn.tup.repository.SolicitudRepositoryMemoria;
import ar.edu.utn.tup.service.ReporteService;
import ar.edu.utn.tup.service.SolicitudService;

public class Main {
    public static void main(String[] args) {
        SolicitudRepository repository = new SolicitudRepositoryMemoria();
        SolicitudService solicitudService = new SolicitudService(repository);
        ReporteService reporteService = new ReporteService(repository);

        // 1. Registrar solicitudes
        Solicitud s1 = solicitudService.registrarSolicitud(new NuevaSolicitudDTO(
                "Certificado", Prioridad.ALTA,
                new Estudiante("L123", "Juan Perez", "juan@mail.com"),
                "Necesito certificado analítico."
        ));
        System.out.println("Solicitud registrada con éxito con ID: " + s1.getId());

        Solicitud s2 = solicitudService.registrarSolicitud(new NuevaSolicitudDTO(
                "Pase", Prioridad.MEDIA,
                new Estudiante("L124", "Maria Gomez", "maria@mail.com"),
                "Pase de facultad."
        ));
        System.out.println("Solicitud registrada con éxito con ID: " + s2.getId());

        // 2. Cambiar estado
        solicitudService.cambiarEstado(1, EstadoSolicitud.EN_PROCESO);
        System.out.println("Estado actualizado correctamente para la solicitud 1");

        // 3. Asignar responsable
        solicitudService.asignarResponsable(1, new Responsable("R01", "Carlos Admin", "Alumnos"));
        System.out.println("Responsable asignado a la solicitud 1");

        // 4. Listar reporte
        System.out.println(reporteService.generarReporteTexto(EstadoSolicitud.EN_PROCESO));
    }
}