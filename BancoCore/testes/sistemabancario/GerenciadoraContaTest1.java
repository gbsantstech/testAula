package sistemabancario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class GerenciadoraContaTest1 {
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		//montar cenário
		ContaCorrente conta01 = new ContaCorrente(1,200,true);
		ContaCorrente conta02 = new ContaCorrente(2,0,true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//execução do teste
		boolean sucesso = gerContas.transfereValor(1, 50, 2);
		
		//verificação e análise
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(),is(150.0));
		assertThat(conta02.getSaldo(), is(50.0));
	}

}
