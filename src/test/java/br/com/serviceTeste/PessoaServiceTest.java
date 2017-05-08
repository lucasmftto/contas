package br.com.serviceTeste;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.contas.Aplicacao;
import br.com.entity.Pessoa;
import br.com.service.PessoaService;

//@SpringApplicationConfiguration(classes = Aplicacao.class)
@SpringBootTest(classes = Aplicacao.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PessoaServiceTest {
	
	@Autowired
	PessoaService pessoaService;
	
	@Test
	public void addPessoa() {

		Pessoa p = new Pessoa();
		
		p.setRoot_cnpj_cpf(400281468);
		p.setDigit_cnpj_cpf(83);
		p.setNome("Fulano 1234");
		p.setDataNascimento(new Date());
		

		Assert.assertTrue(pessoaService.addPessoa(p));
	}
	
	@Test
	public void deletepPessoa(){
		this.pessoaService.deletePessoa(6);
	}
	
	@Test
	public void updatepPessoa(){
		Pessoa pessoa = pessoaService.getPessoaId(6);
		
		pessoa.setNome(pessoa.getNome() + "Teste update");
		
		this.pessoaService.updatePessoa(pessoa);
	}
}
