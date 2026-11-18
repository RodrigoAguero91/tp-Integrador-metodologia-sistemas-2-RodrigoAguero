package ar.edu.utn.tup.repository;

import ar.edu.utn.tup.model.Solicitud;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SolicitudRepositoryMemoria implements SolicitudRepository {
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private int secuenciaId = 1;

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        Solicitud conId = new Solicitud(
                secuenciaId++,
                solicitud.getTipo(),
                solicitud.getPrioridad(),
                solicitud.getEstudiante(),
                solicitud.getDetalle()
        );
        solicitudes.add(conId);
        return conId;
    }

    @Override
    public Optional<Solicitud> buscarPorId(int id) {
        return solicitudes.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Solicitud> obtenerTodas() {
        return new ArrayList<>(solicitudes);
    }
}