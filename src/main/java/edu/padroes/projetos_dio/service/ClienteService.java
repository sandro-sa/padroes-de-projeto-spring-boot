package edu.padroes.projetos_dio.service;

import edu.padroes.projetos_dio.model.Cliente;

/**
 * Interface que define o padrão <b>strategy</b> no domínio de cliente.
 * Com isso, se necessário, podemos ter multiplas implementações dessa mems interface
 *
 * @author SandroAmânciodeSá
 * */
public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar (Long id);

}
