package ar.edu.utn.tup.service;

import ar.edu.utn.tup.dto.NuevaSolicitudDTO;
import ar.edu.utn.tup.exception.SolicitudException;
import ar.edu.utn.tup.model.EstadoSolicitud;
import ar.edu.utn.tup.model.Responsable;
import ar.edu.utn.tup.model.Solicitud;
import ar.edu.utn.tup.repository.SolicitudRepository;

public class SolicitudService {
    private final SolicitudRepository repository;

    // Inyección de dependencias por constructor (DIP)
    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public Solicitud registrarSolicitud(NuevaSolicitudDTO dto) {
        validarDatosEstudiante(dto);
        Solicitud nueva = new Solicitud(0, dto.getTipo(), dto.getPrioridad(), dto.getEstudiante(), dto.getDetalle());
        return repository.guardar(nueva);
    }

    public void cambiarEstado(int idSolicitud, EstadoSolicitud nuevoEstado) {
        if (nuevoEstado == null) {
            throw new SolicitudException("El estado no puede ser nulo.");
        }
        Solicitud solicitud = obtenerSolicitudExistente(idSolicitud);
        solicitud.setEstado(nuevoEstado);
    }

    public void asignarResponsable(int idSolicitud, Responsable responsable) {
        if (responsable == null) {
            throw new SolicitudException("El responsable no puede ser nulo.");
        }
        Solicitud solicitud = obtenerSolicitudExistente(idSolicitud);
        solicitud.setResponsable(responsable);
    }

    // Extract Method: elimina la duplicación de búsqueda y validación de existencia
    private Solicitud obtenerSolicitudExistente(int idSolicitud) {
        return repository.buscarPorId(idSolicitud)
                .orElseThrow(() -> new SolicitudException("No se encontró la solicitud con ID: " + idSolicitud));
    }

    // Extract Method: separa la validación del flujo de creación
    private void validarDatosEstudiante(NuevaSolicitudDTO dto) {
        if (dto == null || dto.getEstudiante() == null ||
                dto.getEstudiante().getLegajo() == null || dto.getEstudiante().getLegajo().isBlank()) {
            throw new SolicitudException("Los datos del estudiante y su legajo son obligatorios.");
        }
    }
}