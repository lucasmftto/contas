package br.com.serviceTeste;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.contas.Aplicacao;
import br.com.service.MovimentacaoService;

@SpringBootTest(classes = Aplicacao.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MovimentacaoServiceTest {
	
	@Autowired
	MovimentacaoService movimentacaoService;
}
