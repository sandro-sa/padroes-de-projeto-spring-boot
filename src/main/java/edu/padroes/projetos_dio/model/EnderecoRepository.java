package edu.padroes.projetos_dio.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SandroAmânciodeSá
 * */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
