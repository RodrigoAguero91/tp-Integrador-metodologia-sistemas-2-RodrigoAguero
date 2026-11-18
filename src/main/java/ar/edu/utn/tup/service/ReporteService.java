package ar.edu.utn.tup.service;

import ar.edu.utn.tup.model.EstadoSolicitud;
import ar.edu.utn.tup.model.Solicitud;
import ar.edu.utn.tup.repository.SolicitudRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ReporteService {
    private final SolicitudRepository repository;

    public ReporteService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<Solicitud> filtrarPorEstado(EstadoSolicitud estado) {
        return repository.obtenerTodas().stream()
                .filter(s -> estado == null || s.getEstado() == estado)
                .collect(Collectors.toList());
    }

    public String generarReporteTexto(EstadoSolicitud filtroEstado) {
        List<Solicitud> filtradas = filtrarPorEstado(filtroEstado);
        StringBuilder sb = new StringBuilder("===== REPORTE DE SOLICITUDES =====\n");
        for (Solicitud s : filtradas) {
            sb.append(formatearLineaSolicitud(s)).append("\n");
        }
        sb.append("Total de solicitudes procesadas en el reporte: ").append(filtradas.size());
        return sb.toString();
    }

    // Extract Method: separa el formato de presentación del recorrido
    private String formatearLineaSolicitud(Solicitud s) {
        return String.format("ID: %d | Tipo: %s | Estado: %s | Estudiante: %s",
                s.getId(), s.getTipo(), s.getEstado(), s.getEstudiante().getNombreCompleto());
    }
}