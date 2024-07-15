package finances;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Crud {
	private static Scanner scanner = new Scanner(System.in);
	
    public static void showMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nEscolha uma opção para as entradas:");
            System.out.println("1 - Inserir uma entrada");
            System.out.println("2 - Listar entradas");
            System.out.println("3 - Atualizar entrada");
            System.out.println("4 - Deletar entrada");
            System.out.println("\nEscolha uma opção para as saidas:");
            System.out.println("5 - Inserir saida");
            System.out.println("6 - Listar saida");
            System.out.println("7 - Atualizar saida");
            System.out.println("8 - Deletar saida"); 
            System.out.println("\n");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    insertEntrie();
                    break;
                case 2:
                    listEntries(); 
                    break;
                case 3:
                    updateEntrie(); 
                    break;
                case 4:
                    deleteEntrie(); 
                    break;
                case 5:
                    insertExit(); 
                    break;
                case 6:
                    listExit(); 
                    break;
                case 7:
                	updateExit(); 
                    break;
                case 8:
                	deleteExit(); 
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }
        
        System.out.println("\nEncerrando programa...");
    }
	
	public static void insertEntrie() {
		System.out.println("Qual o nome da entrada?");
		String name = scanner.nextLine();
		
		System.out.println("Qual a descrição da entrada?");
		String description = scanner.nextLine();
		
		System.out.println("Qual o valor da entrada?");
		double amount = Double.parseDouble(scanner.nextLine());
		
        Connection connection = Factory.getConnection(); 
        try {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            InsertEntries.insertIntoEntries(connection, name, description, 
            		now, amount);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir entrada: " + e.getMessage());
        } finally {
            try {
               connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }		
	}
	
	public static void listEntries() {
		Connection connection = Factory.getConnection();
		
		try {
			RetrieveEntries.retrieveAllEntries(connection);
		} catch (SQLException e) {
			System.out.println("Erro ao listar entradas: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateEntrie() {
		listEntries();
		
		Connection connection = Factory.getConnection();		
		try {			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			UpdateEntrie.updateEntrie(connection, now);
		} catch (SQLException e) {
			 System.err.println("Erro ao atualizar entrada: " + e.getMessage());
		}
	}
	
	public static void deleteEntrie() {
		listEntries();
		
		Connection connection = Factory.getConnection();		
		try {			
			DeleteEntrie.deleteEntrie(connection);
		} catch (SQLException e) {
			 System.err.println("Erro ao deletar entrada: " + e.getMessage());
		}
	}
	
	public static void insertExit() {
		System.out.println("Qual o nome da saída?");
		String name = scanner.nextLine();
		
		System.out.println("Qual a descrição da saída?");
		String description = scanner.nextLine();
		
		System.out.println("Qual o valor da saída?");
		double amount = Double.parseDouble(scanner.nextLine());
		
        Connection connection = Factory.getConnection(); 
        try {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            InsertExits.insertIntoExits(connection, name, description, 
            		now, amount);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir saída: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void listExit() {
		Connection connection = Factory.getConnection();
		
		try {
			RetrieveExits.retrieveAllExits(connection);
		} catch (SQLException e) {
			System.out.println("Erro ao listar saídas: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateExit() {
		listExit();
		
		Connection connection = Factory.getConnection(); 
		
		try {			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			UpdateExit.updateExit(connection, now);
		} catch (SQLException e) {
			 System.err.println("Erro ao atualizar saida: " + e.getMessage());
		}
	}
	
	public static void deleteExit() {
		listExit();
		
		Connection connection = Factory.getConnection(); 
		
		try {			
			DeleteExit.deleteExit(connection);
		} catch (SQLException e) {
			 System.err.println("Erro ao deletar saida: " + e.getMessage());
		}
	}
	
}
