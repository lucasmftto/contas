package br.com.serviceTeste;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.contas.Aplicacao;
import br.com.entity.Status;
import br.com.service.StatusService;

@SpringBootTest(classes = Aplicacao.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class StatusServiceTest {
	
	@Autowired
	StatusService statusService;
	
	@Test
	public void addStatus(){
		
		Status s1 = new Status();
		Status s2 = new Status();
		Status s3 = new Status();
		
		s1.setDescricao("Ativalala");
		s2.setDescricao("Bloqueada");
		s3.setDescricao("Cancelada");
		
		statusService.addStatus(s1);
		statusService.addStatus(s2);
		statusService.addStatus(s3);
		
	}
	

	@Test
	public void deleteStatus(){
		statusService.deleteStatus(6);
	}
		

}
