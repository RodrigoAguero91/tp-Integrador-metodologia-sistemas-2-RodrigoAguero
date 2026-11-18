package ar.edu.utn.tup.model;

public class Solicitud {
    private int id;
    private String tipo; // Ej: "Certificado", "Pase", "Equivalencia"
    private String prioridad; // "Alta", "Media", "Baja"
    private String estado; // "Pendiente", "En Proceso", "Resuelta"
    private Estudiante estudiante;
    private Responsable responsable;
    private String detalle;

    public Solicitud(int id, String tipo, String prioridad, Estudiante estudiante, String detalle) {
        this.id = id;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
        this.estudiante = estudiante;
        this.detalle = detalle;
        this.responsable = null;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getPrioridad() { return prioridad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Estudiante getEstudiante() { return estudiante; }
    public Responsable getResponsable() { return responsable; }
    public void setResponsable(Responsable responsable) { this.responsable = responsable; }
    public String getDetalle() { return detalle; }
}