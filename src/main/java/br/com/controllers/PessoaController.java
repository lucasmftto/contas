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

import br.com.entity.Pessoa;
import br.com.service.PessoaService;

/**
 * Classe controller, responsavel por disponibilizar o CRUD de pessoa
 * 
 * @author Lucas Favaretto
 * @version 1.00
 */

@RestController
@RequestMapping("/pessoas")
public class PessoaController implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@Autowired
	private PessoaService pessoaService;

	/**
	 * Método que adiciona uma Pessoa
	 * 
	 * @param entity
	 *            Pessoa (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("add")
	public ResponseEntity<Void> addPessoa(@RequestBody Pessoa pessoa, UriComponentsBuilder builder) {
		boolean flag = pessoaService.addPessoa(pessoa);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(pessoa.getId_pessoa()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que remove uma Pessoa pelo Id
	 * 
	 * @param entity
	 *            Pessoa (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable("id") Integer id) {
		pessoaService.deletePessoa(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Método que retorna todas as Pessoas
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("todasPessoas")
	public ResponseEntity<List<Pessoa>> getAllPessoa() {
		List<Pessoa> list = pessoaService.getTodasPessoas();
		return new ResponseEntity<List<Pessoa>>(list, HttpStatus.OK);
	}

	/**
	 * Método que atualiza uma Pessoa
	 * 
	 * @param entity
	 *            Pessoa (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PutMapping("atualiza")
	public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) {
		pessoaService.updatePessoa(pessoa);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	/**
	 * Método que lista uma Pessoa por Id
	 * 
	 * @param entity
	 *            Pessoa (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("listarId/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Integer id) {
		Pessoa pessoa = pessoaService.getPessoaId(id);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}

}
