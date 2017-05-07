package br.com.serviceTeste;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.contas.Aplicacao;
import br.com.entity.Conta;
import br.com.service.ContaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Aplicacao.class })
public class ContaServiceTest {

	@Autowired
	@Qualifier("contaService")
	ContaService contaService;
	
	
	public void addConta(){
		
		Conta conta = new Conta();
		
		
		Assert.assertTrue(contaService.addConta(conta));
	}
}
