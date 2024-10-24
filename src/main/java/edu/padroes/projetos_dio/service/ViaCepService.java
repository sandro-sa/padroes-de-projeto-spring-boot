package edu.padroes.projetos_dio.service;

import edu.padroes.projetos_dio.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para consumo de API do <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projetos/spring-cloud-openfeign"> Spring Cloud OpenFeign</a>
 * @see <a href="https://viaccep.com.br">ViaCEP</a>
 *
 * @author SandroAmânciodeSá
 * */
@FeignClient(name="viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    //@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    @GetMapping( value = "/{cep}/json/")
    Endereco consultarCep( @PathVariable("cep") String cep);
}
