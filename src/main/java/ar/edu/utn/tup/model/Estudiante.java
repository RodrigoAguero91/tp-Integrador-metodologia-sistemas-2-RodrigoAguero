package ar.edu.utn.tup.model;

public class Estudiante {
    private String legajo;
    private String nombreCompleto;
    private String email;

    public Estudiante(String legajo, String nombreCompleto, String email) {
        this.legajo = legajo;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public String getLegajo() { return legajo; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getEmail() { return email; }
}