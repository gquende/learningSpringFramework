package com.vipas.dash.repository;


import com.vipas.dash.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
Evento findByCodigo(long codigo);

}
