package sistemabancario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraContaTest2 {
	private GerenciadoraContas gerContas;
	private int idConta01 = 1;
	private int idConta02 = 2;
	

	
	@Before
	public void setUp() {
		ContaCorrente conta01 = new ContaCorrente(idConta01,200,true);
		ContaCorrente conta02 = new ContaCorrente(idConta02,0,true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
	}
	
	@After
	public void tearDown() {
		gerContas.limpa();
	}
	
	@Test
	public void testTransfereValor() {
		
		double saldoc1 = gerContas.pesquisaConta(idConta01).getSaldo();
		double saldoc2 = gerContas.pesquisaConta(idConta02).getSaldo();
		boolean sucesso = gerContas.transfereValor(idConta01, 50, idConta02);
	
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta01).getSaldo(),is(saldoc1-50.0));
		assertThat(gerContas.pesquisaConta(idConta02).getSaldo(),is(saldoc2+50.0));
	}

}
