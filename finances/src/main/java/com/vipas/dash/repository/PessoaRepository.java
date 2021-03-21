package com.vipas.dash.repository;

import com.vipas.dash.models.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, String> {
}
