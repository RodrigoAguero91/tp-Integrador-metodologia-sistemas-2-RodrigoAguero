package ar.edu.utn.tup.model;

public class Solicitud {
    private int id;
    private String tipo;
    private Prioridad prioridad;
    private EstadoSolicitud estado;
    private Estudiante estudiante;
    private Responsable responsable;
    private String detalle;

    public Solicitud(int id, String tipo, Prioridad prioridad, Estudiante estudiante, String detalle) {
        this.id = id;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = EstadoSolicitud.PENDIENTE;
        this.estudiante = estudiante;
        this.detalle = detalle;
        this.responsable = null;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public Prioridad getPrioridad() { return prioridad; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
    public Estudiante getEstudiante() { return estudiante; }
    public Responsable getResponsable() { return responsable; }
    public void setResponsable(Responsable responsable) { this.responsable = responsable; }
    public String getDetalle() { return detalle; }
}