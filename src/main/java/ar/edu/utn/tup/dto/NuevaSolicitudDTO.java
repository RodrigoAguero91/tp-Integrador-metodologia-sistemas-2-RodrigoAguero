package ar.edu.utn.tup.dto;

import ar.edu.utn.tup.model.Estudiante;
import ar.edu.utn.tup.model.Prioridad;

public class NuevaSolicitudDTO {
    private final String tipo;
    private final Prioridad prioridad;
    private final Estudiante estudiante;
    private final String detalle;

    public NuevaSolicitudDTO(String tipo, Prioridad prioridad, Estudiante estudiante, String detalle) {
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estudiante = estudiante;
        this.detalle = detalle;
    }

    public String getTipo() { return tipo; }
    public Prioridad getPrioridad() { return prioridad; }
    public Estudiante getEstudiante() { return estudiante; }
    public String getDetalle() { return detalle; }
}