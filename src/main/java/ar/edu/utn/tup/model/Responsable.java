package ar.edu.utn.tup.model;

public class Responsable {
    private String idResponsable;
    private String nombre;
    private String area;

    public Responsable(String idResponsable, String nombre, String area) {
        this.idResponsable = idResponsable;
        this.nombre = nombre;
        this.area = area;
    }

    public String getIdResponsable() { return idResponsable; }
    public String getNombre() { return nombre; }
    public String getArea() { return area; }
}