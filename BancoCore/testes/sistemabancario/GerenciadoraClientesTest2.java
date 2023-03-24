package sistemabancario;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para testar operacoes de GerenciadoraClientes{@link GerenciadoraClientes}
 * 
 * @author Gabriel Custodio dos Santos
 * @date 10/03/2023
 */

public class GerenciadoraClientesTest2 {
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	private int idContaCorrente01 = 1;
	private int idContaCorrente02 = 2;
	
	//Montagem do cenario global para esta classe: estrutura de setup
	
	@Before
	public void setUp() {
		Cliente cliente1 = new Cliente(idCliente01, "João da Silva", 46, "joaodasilva@gmail.com", idContaCorrente01, true);
		Cliente cliente2 = new Cliente(idCliente02, "Maria da Silva", 11, "mariadasilva@gmail.com",idContaCorrente02, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientes);
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	/**
	 * Teste unitario basico de pesquisa cliente a partir do seu ID
	 * 
	 * @author Gabriel Custodio dos Santos
	 * @date 10/03/2023
	 */
	@Test
	public void testPesquisaCliente() {
		
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		assertThat(cliente.getId(), is(idCliente01));
	}
	
	/**
	 * Teste unitario da remoção de um cliente a partir do seu ID
	 * 
	 * @author Gabriel Custodio dos Santos
	 * @date 17/03/2023
	 */
	
	@Test
	public void testRemoveCliente() {
	
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
	
		assertTrue(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
}
