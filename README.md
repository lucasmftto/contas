Alterar o usuario e senha do mySql no arquivo application.properties

# Criar o Schema "contas"no mySql executando o seguinte SQL

CREATE SCHEMA 'contas' ;

# Para iniciar a aplicação, deve executar a seguinte classe:

br.com.contas.Aplicacao

# Apos subir a aplicaçao para criar as tabelas, inserir os seguintes registros ou executar o teste addStatus na classe StatusServiceTest

INSERT INTO 'contas'.'status' ('cod_status', 'descricao') VALUES ('', 'Ativa');

INSERT INTO 'contas'.'status' ('descricao') VALUES ('Bloqueada');

INSERT INTO 'contas'.'status' ('descricao') VALUES ('Cancelada');


# Foi utilizado o app Postman para testar os serviços disponibilizados

https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

# Segue os principais Serviços diponiveis

Adiciona conta:

http://localhost:8080/contas/add

{
  "nome": "nova conta",
  "dataCriacao": "2017-05-05",
  "cod_matriz": 3,
  "pessoa": {
  		"id_pessoa": 1
  
  },
  "status": {
  		"cod_status": 3
  
  }
}


Deleta Conta:

http://localhost:8080/contas/delete/1

Lista todas as contas:

http://localhost:8080/contas/todasContas

Atualiza conta:

http://localhost:8080/contas/atualiza

{
  "id_conta": 2,
  "nome": "segunda conta lal",
  "dataCriacao": "2017-05-05",
  "cod_matriz": "",
  "pessoa": {
  		"id_pessoa": 1
  
  }
}


Lista conta por Id:

http://localhost:8080/contas/listarId/2

Listar Contas por Id da Matriz:

http://localhost:8080/contas/listarPorMatriz/2

Insere aporte na Matriz:

http://localhost:8080/movimentacao/aporte

{
  "valor": 12,
  "descricao": "quarto Aporte",
  
  "id_conta": {
  		"id_conta": 3
  
  }
}

Estorno Aporte:

http://localhost:8080/movimentacao/estornoAporte/

{
	"id_movimentacao": 1
 
}

Realiza Tranferencia:

http://localhost:8080/movimentacao/transferencia/

{
  "valor": 300,
  "descricao": "teste Transferencia matris",
  
  "id_conta": {
  		"id_conta": 12
  
  },
  "id_conta_depositante": {
  		"id_conta": 7
  }
}

Estorno de Transferencia:

http://localhost:8080/movimentacao/estornoTransferencia/

{
	"id_movimentacao": 5
 
}

Consultar movimentações por conta:

http://localhost:8080/movimentacao/movimentacoesByConta/2

Consultar saldo por Id da conta:

http://localhost:8080/movimentacao/saldoByConta/2


