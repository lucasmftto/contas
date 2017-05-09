package br.com.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.entity.Movimentacao;
import br.com.service.MovimentacaoService;

/**
 * Classe controller, responsavel por disponibilizar os serviços rest da
 * movimentação
 * 
 * @author Lucas Favaretto
 * @version 1.00
 */

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@Autowired
	private MovimentacaoService movimentacaoService;

	/**
	 * Método que adiciona um aporte * @param entity Movimentacao (via Json)
	 * 
	 * @param entity
	 *            Movimentacao (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("aporte")
	public ResponseEntity<Void> addAporte(@RequestBody Movimentacao movimentacao, UriComponentsBuilder builder) {
		boolean flag = movimentacaoService.setAporte(movimentacao);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(movimentacao.getId_conta()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que realiza o estorno de um aporte * @param entity Movimentacao
	 * (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("estornoAporte")
	public ResponseEntity<Void> addEstornoAporte(@RequestBody Movimentacao movimentacao, UriComponentsBuilder builder) {
		boolean flag = movimentacaoService.setEstorno(movimentacao.getId_movimentacao());
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(movimentacao.getId_conta()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que realiza transferencias entre contas nao matriz * @param entity
	 * Movimentacao (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("transferencia")
	public ResponseEntity<Void> addTransferencia(@RequestBody Movimentacao movimentacao, UriComponentsBuilder builder) {
		boolean flag = movimentacaoService.setTransferencia(movimentacao);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(movimentacao.getId_conta()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que realiza estorno de tranferencia apartir do codigo da
	 * comimentacao * @param entity Movimentacao (via Json)
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@PostMapping("estornoTransferencia")
	public ResponseEntity<Void> addEstornoTransferencia(@RequestBody Movimentacao movimentacao,
			UriComponentsBuilder builder) {
		boolean flag = movimentacaoService.setEstornoTransferencia(movimentacao.getId_movimentacao());
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/add/{id}").buildAndExpand(movimentacao.getId_conta()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Método que realiza consulta de movimentacao apartir do Id da conta
	 * * @param Integar, codigo da conta
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("movimentacoesByConta/{id}")
	public ResponseEntity<List<Movimentacao>> getMovimentacoesByConta(@PathVariable("id") Integer idConta) {
		List<Movimentacao> list = movimentacaoService.getMovimentacoesByConta(idConta);
		return new ResponseEntity<List<Movimentacao>>(list, HttpStatus.OK);
	}

	/**
	 * Método que realiza consulta do saldo apatir do id da conta * @param
	 * Integar, codigo da conta
	 * 
	 * @return HttpStatus - Retorna o status da requisição
	 */
	@GetMapping("saldoByConta/{id}")
	public ResponseEntity<BigDecimal> getSaldoByConta(@PathVariable("id") Integer idConta) {
		BigDecimal saldo = movimentacaoService.getSaldoByConta(idConta);
		return new ResponseEntity<BigDecimal>(saldo, HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}

}
