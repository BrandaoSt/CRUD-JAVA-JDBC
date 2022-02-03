import java.util.Scanner;

import br.com.recode.model.Cliente;
import br.com.recode.services.ClienteServices;

public class Application {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Boolean sair = true;
		
		do {
			System.out.println("------------------------------------");
			System.out.println("DIGITE UMA DAS OPÇÕES ABAIXO");
			System.out.println("0 - SAIR");
			System.out.println("1 - CADASTRAR CLIENTE");
			System.out.println("2 - ATUALIZAR CLIENTE");
			System.out.println("3 - LISTAR CLIENTES");
			System.out.println("4 - DELETAR CLIENTE");
			System.out.println("");
			
			int opcao = input.nextInt();
			
			ClienteServices clienteServices = new ClienteServices();
			
			switch(opcao) {
				case 0:
					sair = false;
					break;
				case 1:
					clienteServices.save();
					break;
				case 2:
					clienteServices.update();
					break;
				case 3:
					System.out.println("-------- LISTA DE CLIENTES ----------");
					for(Cliente c : ClienteServices.getClientes()) {
						System.out.println("-------------------------------------");
						System.out.println("Id: "+ c.getId());
						System.out.println("Cliente: "+ c.getNome());
						System.out.println("Email: "+ c.getEmail());
						System.out.println("Cpf: "+ c.getCpf());
						System.out.println("Endereço: "+ c.getEndereco());
						System.out.println("Cidade: "+ c.getCidade());
						System.out.println("Estado: "+ c.getEstado());
						System.out.println("-------------------------------------");
					}
					break;
				case 4:
					clienteServices.deleteById();
					break;	
				default:
					System.out.println("Opção inválida");
					break;
			}
		} while (sair);
		
		System.out.println("Até breve!");
	}
	
}
