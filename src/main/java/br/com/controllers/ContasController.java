package br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entity.Conta;
import br.com.service.ContaService;

/**
 * Classe controller, responsavel por disponibilizar o CRUD da Conta
 * 
 * @author Lucas Favaretto
 * @version 1.00
 */

@RestController
@RequestMapping("/contas")
public class ContasController implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@Autowired
	private ContaService contaService;

	/**
	 * Método que adiciona uma conta
	 * 
	 * @param entity
	 *            Conta (via Json) 
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("add")
	public ResponseEntity<Void> addConta(@RequestBody Conta conta, UriComponentsBuilder builder) {
		boolean flag = contaService.addConta(conta);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(conta.getId_conta()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que remove uma conta
	 * 
	 * @param entity
	 *            Conta (via Json)
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteConta(@PathVariable("id") Integer id) {
		contaService.deleteConta(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Método que Consulta todas as contas
	 * 
	 * @return HttpStatus - Retorna o status da requisição e um <List<Conta>>(
	 */
	@GetMapping("todasContas")
	public ResponseEntity<List<Conta>> getAllContas() {
		List<Conta> list = contaService.getTodasContas();
		return new ResponseEntity<List<Conta>>(list, HttpStatus.OK);
	}

	/**
	 * Método que atualiza a conta
	 * 
	 * @param entity
	 *            Conta (via Json)
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PutMapping("atualiza")
	public ResponseEntity<Conta> updateConta(@RequestBody Conta conta) {
		contaService.updateConta(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	/**
	 * Método que lista conta por Id
	 * 
	 * @param Integer
	 *            Id da conta
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("listarId/{id}")
	public ResponseEntity<Conta> getContaById(@PathVariable("id") Integer id) {
		Conta conta = contaService.getContaId(id);
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}
	
	/**
	 * Método que que lista contas por id da conta matriz
	 * 
	 * @param Integer
	 *            Id da conta
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("listarPorMatriz/{id}")
	public ResponseEntity<List<Conta>> getContasByMatriz(@PathVariable("id") Integer id_matriz) {
		List<Conta> list = contaService.getContasByMatriz(id_matriz);
		return new ResponseEntity<List<Conta>>(list, HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}

}