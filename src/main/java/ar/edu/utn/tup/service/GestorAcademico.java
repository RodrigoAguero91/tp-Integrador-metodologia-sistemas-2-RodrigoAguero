package ar.edu.utn.tup.service;

import ar.edu.utn.tup.model.Estudiante;
import ar.edu.utn.tup.model.Responsable;
import ar.edu.utn.tup.model.Solicitud;

import java.util.ArrayList;
import java.util.List;

public class GestorAcademico {
    private List<Solicitud> listaSolicitudes = new ArrayList<>();
    private int contadorId = 1;

    // Operación 1: Registrar solicitud con lógica acoplada y validaciones directas
    public void registrarSolicitud(String tipo, String prioridad, String legajoEstu, String nombreEstu, String emailEstu, String detalle) {
        if (legajoEstu == null || legajoEstu.isEmpty()) {
            System.out.println("Error: El legajo no puede estar vacío.");
            return;
        }
        Estudiante est = new Estudiante(legajoEstu, nombreEstu, emailEstu);
        Solicitud nueva = new Solicitud(contadorId++, tipo, prioridad, est, detalle);
        listaSolicitudes.add(nueva);
        System.out.println("Solicitud registrada con éxito con ID: " + nueva.getId());
    }

    // Operación 2: Cambiar estado con múltiples if-else anidados (Code Smell)
    public void cambiarEstadoSolicitud(int idSol, String nuevoEstado) {
        for (int i = 0; i < listaSolicitudes.size(); i++) {
            Solicitud s = listaSolicitudes.get(i);
            if (s.getId() == idSol) {
                if (nuevoEstado.equals("Pendiente") || nuevoEstado.equals("En Proceso") || nuevoEstado.equals("Resuelta")) {
                    s.setEstado(nuevoEstado);
                    System.out.println("Estado actualizado correctamente para la solicitud " + idSol);
                } else {
                    System.out.println("Estado inválido.");
                }
                return;
            }
        }
        System.out.println("No se encontró la solicitud.");
    }

    // Operación 3: Asignar responsable
    public void asignarResponsableA_Solicitud(int idSol, String idResp, String nombreResp, String areaResp) {
        Solicitud encontrada = null;
        for (Solicitud s : listaSolicitudes) {
            if (s.getId() == idSol) {
                encontrada = s;
                break;
            }
        }
        if (encontrada != null) {
            Responsable r = new Responsable(idResp, nombreResp, areaResp);
            encontrada.setResponsable(r);
            System.out.println("Responsable asignado a la solicitud " + idSol);
        } else {
            System.out.println("Solicitud no encontrada.");
        }
    }

    // Operación 4: Buscar, filtrar y generar reporte mezclado en un método gigante
    public void generarReporteYFiltrar(String filtroEstado) {
        System.out.println("===== REPORTE DE SOLICITUDES =====");
        int total = 0;
        for (Solicitud s : listaSolicitudes) {
            if (filtroEstado == null || s.getEstado().equalsIgnoreCase(filtroEstado)) {
                System.out.println("ID: " + s.getId() + " | Tipo: " + s.getTipo() + " | Estado: " + s.getEstado() + " | Estudiante: " + s.getEstudiante().getNombreCompleto());
                total++;
            }
        }
        System.out.println("Total de solicitudes procesadas en el reporte: " + total);
    }
}