package br.com.controllerTeste;

import java.math.BigDecimal;

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

@SpringBootTest(classes = Aplicacao.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MovimentacaoControllerTest {
	
	@Test
	public void getSaldo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/movimentacao/saldoByConta/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<BigDecimal> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, BigDecimal.class, 2);
        BigDecimal saldo = responseEntity.getBody();
        
        Assert.assertNotNull(saldo);
        System.out.println("Saldo: " + saldo.toString());      
    }

}
