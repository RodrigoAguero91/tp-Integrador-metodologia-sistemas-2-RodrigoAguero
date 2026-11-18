package ar.edu.utn.tup.repository;

import ar.edu.utn.tup.model.Solicitud;
import java.util.List;
import java.util.Optional;

public interface SolicitudRepository {
    Solicitud guardar(Solicitud solicitud);
    Optional<Solicitud> buscarPorId(int id);
    List<Solicitud> obtenerTodas();
}
