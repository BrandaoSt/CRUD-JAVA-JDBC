package br.com.recode.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.recode.factory.ConnectionFactory;
import br.com.recode.model.Cliente;

public class ClienteServices {

		public void save() {
			
			Scanner input = new Scanner(System.in);
			
			Cliente cliente = new Cliente();
			
			System.out.println("Digite o nome do cliente:");
			cliente.setNome(input.nextLine());
			System.out.println("Digite o Email:");
			cliente.setEmail(input.nextLine());
			System.out.println("Digite o CPF:");
			cliente.setCpf(input.nextLine());
			System.out.println("Digite o Endereço:");
			cliente.setEndereco(input.nextLine());
			System.out.println("Digite a cidade:");
			cliente.setCidade(input.nextLine());
			System.out.println("Digite o Estado:");
			cliente.setEstado(input.nextLine());
			
			String sql = "INSERT INTO cliente (nome, email, cpf, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?, ? )";
			
			Connection conn = null;	
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getEmail());
				pstm.setString(3, cliente.getCpf());
				pstm.setString(4, cliente.getEndereco());
				pstm.setString(5, cliente.getCidade());
				pstm.setString(6, cliente.getEstado());
				
				pstm.execute();
				
				conn.close();
				pstm.close();
				
				System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {			
				
		}	 
	}
		
		public void update() {
			
			Scanner input = new Scanner(System.in);
			
			Cliente cliente = new Cliente();
			
			System.out.println("Digite o identificador(ID) do cliente: ");
			cliente.setId(input.nextInt());
			input.hasNextLine();
			System.out.println("Digite o nome do cliente:");
			cliente.setNome(input.nextLine());
			input.hasNextLine();
			System.out.println("Digite o Email:");
			cliente.setEmail(input.nextLine());
			input.hasNextLine();
			System.out.println("Digite o CPF:");
			cliente.setCpf(input.nextLine());
			input.hasNextLine();
			System.out.println("Digite o Endereço:");
			cliente.setEndereco(input.nextLine());
			input.hasNextLine();
			System.out.println("Digite a cidade:");
			cliente.setCidade(input.nextLine());
			input.hasNextLine();
			System.out.println("Digite o Estado:");
			cliente.setEstado(input.nextLine());
			input.hasNextLine();
			
			String sql = "UPDATE cliente set nome = ?, email = ?, cpf = ?, endereco = ?, cidade = ?, estado = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectionFactory.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getEmail());
				pstm.setString(3, cliente.getCpf());
				pstm.setString(4, cliente.getEndereco());
				pstm.setString(5, cliente.getCidade());
				pstm.setString(6, cliente.getEstado());
				
				pstm.executeUpdate();
				
				conn.close();
				pstm.close();
				
				System.out.println("CLIENTE ATUALIZADO COM SUCESSO!");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		
		public static List<Cliente> getClientes (){
			
			String sql = "SELECT * FROM cliente";
			List<Cliente> clientes = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			ResultSet rset = null;
			
			try {
				conn = ConnectionFactory.createConnection();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Cliente	cliente = new Cliente();
					
					cliente.setId(rset.getInt("id"));
					cliente.setNome(rset.getString("nome"));
					cliente.setEmail(rset.getString("email"));
					cliente.setCpf(rset.getString("cpf"));
					cliente.setEndereco(rset.getString("endereco"));
					cliente.setCidade(rset.getString("cidade"));
					cliente.setEstado(rset.getString("estado"));
					
					clientes.add(cliente);
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {			
					if(rset!=null) {
						rset.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				

			}
			return clientes;
			
		}
		
		public void deleteById() {

			Scanner input = new Scanner(System.in);
			
			Cliente cliente = new Cliente();
			
			System.out.println("Digite o identificador(ID) do cliente: ");
			cliente.setId(input.nextInt());
			
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, cliente.getId());
				
				pstm.execute();
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null)
						conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("CLIENTE DELETADO COM SUCESSO!");
			}
		}
	}	



















