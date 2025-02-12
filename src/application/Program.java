package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
        int opcao;
        
        do {
        	System.out.println();
            System.out.println("=== MENU ===");
            System.out.println("1. Procurar vendedor por ID");
            System.out.println("2. Procurar vendedor por departamento");
            System.out.println("3. Listar todos os vendedores");
            System.out.println("4. Inserir novo vendedor");
            System.out.println("5. Atualizar vendedor");
            System.out.println("6. Deletar vendedor");
            System.out.println("0. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            
            System.out.println();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do vendedor: ");
                    int idProcurar = sc.nextInt();
                    Vendedor vendedor = vendedorDao.Read(idProcurar);
                    if (vendedor != null) {
                        System.out.println("Vendedor encontrado: " + vendedor);
                    } else {
                        System.out.println("Vendedor não encontrado.");
                    }
                    break;
                
                case 2:
                    System.out.print("Digite o ID do departamento: ");
                    int idDepartamento = sc.nextInt();
                    Departamento departamento = new Departamento(idDepartamento, null);
                    List<Vendedor> vendedoresPorDepartamento = vendedorDao.findByDepartment(departamento);
                    if (!vendedoresPorDepartamento.isEmpty()) {
                        System.out.println("Vendedores no departamento: ");
                        for (Vendedor v : vendedoresPorDepartamento) {
                            System.out.println(v);
                        }
                    } else {
                        System.out.println("Nenhum vendedor encontrado neste departamento.");
                    }
                    break;
                
                case 3:
                    List<Vendedor> todosVendedores = vendedorDao.readAll();
                    System.out.println("Lista de todos os vendedores:");
                    for (Vendedor v : todosVendedores) {
                        System.out.println(v);
                    }
                    break;
                
                case 4:
                    System.out.print("Digite o nome do novo vendedor: ");
                    sc.nextLine(); 
                    String nome = sc.nextLine();
                    System.out.print("Digite o email do novo vendedor: ");
                    String email = sc.nextLine();
                    System.out.print("Digite o salário do novo vendedor: ");
                    double salario = sc.nextDouble();
                    System.out.print("Digite o ID do departamento do vendedor: ");
                    int idDep = sc.nextInt();
                    
                    Departamento novoDepartamento = new Departamento(idDep, null);
                    Vendedor novoVendedor = new Vendedor(null, nome, email, new Date(), salario, novoDepartamento);
                    vendedorDao.Creat(novoVendedor);
                    System.out.println("Vendedor inserido com sucesso! Novo ID: " + novoVendedor.getId());
                    break;
                
                case 5:
                    System.out.print("Digite o ID do vendedor a ser atualizado: ");
                    int idAtualizar = sc.nextInt();
                    Vendedor vendedorAtualizar = vendedorDao.Read(idAtualizar);
                    if (vendedorAtualizar != null) {
                        System.out.print("Digite o novo nome: ");
                        sc.nextLine(); 
                        String novoNome = sc.nextLine();
                        System.out.print("Digite o novo email: ");
                        String novoEmail = sc.nextLine();
                        vendedorAtualizar.setName(novoNome);
                        vendedorAtualizar.setEmail(novoEmail);
                        vendedorDao.Update(vendedorAtualizar);
                        System.out.println("Vendedor atualizado com sucesso!");
                    } else {
                        System.out.println("Vendedor não encontrado.");
                    }
                    break;
                
                case 6:
                    System.out.print("Digite o ID do vendedor a ser deletado: ");
                    int idDeletar = sc.nextInt();
                    vendedorDao.Delete(idDeletar);
                    System.out.println("Vendedor deletado com sucesso.");
                    break;
                
                case 0:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
		
		sc.close();
	}

}
