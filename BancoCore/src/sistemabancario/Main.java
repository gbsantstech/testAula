package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		inicializaSistemaBancario();
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while(continua) {
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);
				
				if(cliente != null) {
					System.out.println(cliente.toString());
				}else {
					System.out.println("Cliente não encontrado!");
				}
				break;
			
			case 2:
				System.out.println("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null) {
					System.out.println(conta.toString());
				}else {
					System.out.println("Conta não encontrada!");
				}
				break;
				
			case 3:
				System.out.println("Digite o ID do cliente a ser ativado: ");
				int idClient = sc.nextInt();
				Cliente cliente2 = gerClientes.pesquisaCliente(idClient);
				
				if(cliente2 != null) {
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				}else {
					System.out.println("Cliente não encontrado");
				}
				break;
				
			case 4:
				System.out.println("Digite o ID do cliente a ser desativado: ");
				int idClient2 = sc.nextInt();
				Cliente cliente3 = gerClientes.pesquisaCliente(idClient2);
				
				if(cliente3 != null) {
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				}else {
					System.out.println("Cliente não encontrado");
				}
				break;
				
			case 5:
				continua = false;
				System.out.println("Volte sempre!");
				break;
			}
		}
	}
	private static void printMenu() {
		System.out.println("Escolha uma opção");
		System.out.println("1- Consulte o ID do cliente");
		System.out.println("2- Consulte o ID da conta");
		System.out.println("3- Ativar um cliente");
		System.out.println("4- Desativar um cliente");
		System.out.println("5- Sair do sistema");
		
	}
	private static void inicializaSistemaBancario() {
		List<ContaCorrente> contas = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		ContaCorrente cc1 = new ContaCorrente(1, 0, true);
		ContaCorrente cc2 = new ContaCorrente(2, 0, true);
		contas.add(cc1);
		contas.add(cc2);
		
		Cliente c1 = new Cliente(1, "João da Silva", 30, "joaodasilva@gmail.com", cc1.getId(), true);
		Cliente c2 = new Cliente(2, "Maria da Silva", 28, "mariadasilva@gmail.com", cc1.getId(), false);
		clientes.add(c1);
		clientes.add(c2);
		
		gerClientes = new GerenciadoraClientes(clientes);
		gerContas = new GerenciadoraContas(contas);
	}
}
