package br.com.controllerTeste;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.contas.Aplicacao;
import br.com.entity.Pessoa;

@SpringBootTest(classes = Aplicacao.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PessoaControllerTest {
	
	@Test
	public void listarPessoaId() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/pessoas/listarId/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Pessoa> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Pessoa.class, 1);
        Pessoa pessoa = responseEntity.getBody();
        
        Assert.assertNotNull(pessoa);
        System.out.println("Id:"+pessoa.getId_pessoa()+", Nome:"+pessoa.getNome());      
    }
	
	

}
