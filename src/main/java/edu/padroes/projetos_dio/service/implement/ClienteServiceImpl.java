package edu.padroes.projetos_dio.service.implement;

import edu.padroes.projetos_dio.model.Cliente;
import edu.padroes.projetos_dio.model.ClienteRepository;
import edu.padroes.projetos_dio.model.Endereco;
import edu.padroes.projetos_dio.model.EnderecoRepository;
import edu.padroes.projetos_dio.service.ClienteService;
import edu.padroes.projetos_dio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * @author SandroAmânciodeSá
 * */
@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injetar os camponentes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface
    // Facade: Abstrair integrações com subsitemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        //Verifica se o endereço já existe
        salvarClienteComCep(cliente);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar cliente por ID, caso exista
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            // Verifica se o endereço do cliente já existe(pelo CEP)
            // Caso não exista integra com o ViaCep e persiste o retorno
            // Altera o Cliente, vinculando o Endereço (novo ou existente)
            salvarClienteComCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
            //Caso não exista, integra com o ViaCep e persiste o retorno;
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inseri Cliente, vinculando o Endereço (Novo ou existente)
        clienteRepository.save(cliente);
    }
}
