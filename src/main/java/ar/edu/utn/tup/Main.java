package ar.edu.utn.tup;

import ar.edu.utn.tup.service.GestorAcademico;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        // 1. Registrar solicitudes
        gestor.registrarSolicitud("Certificado", "Alta", "L123", "Juan Perez", "juan@mail.com", "Necesito certificado analítico.");
        gestor.registrarSolicitud("Pase", "Media", "L124", "Maria Gomez", "maria@mail.com", "Pase de facultad.");

        // 2. Cambiar estado
        gestor.cambiarEstadoSolicitud(1, "En Proceso");

        // 3. Asignar responsable
        gestor.asignarResponsableA_Solicitud(1, "R01", "Carlos Admin", "Alumnos");

        // 4. Listar reporte
        gestor.generarReporteYFiltrar("En Proceso");
    }
}