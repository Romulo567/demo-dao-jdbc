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
		
		System.out.println("=== teste: procurar vendedor ====");
		Vendedor vendedor = vendedorDao.Read(1);
		System.out.println(vendedor);
		
		System.out.println("\n=== teste: procurar vendedor por departamento ====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.findByDepartment(departamento);
		for(Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== teste: procurar todos vendedores ====");
		list = vendedorDao.readAll();
		for(Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== teste: inserir ====");
		Vendedor novoVendedor = new Vendedor(1, "Paula", "paula@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.Creat(novoVendedor);
		System.out.println("Inserted! new id = " + novoVendedor.getId());
		
		System.out.println("\n=== teste: atualizar ====");
		vendedor = vendedorDao.Read(1);
		vendedor.setName("Vinicius");
		vendedor.setEmail("vinicius@gmial.com");
		vendedorDao.Update(vendedor);
		System.out.println("Update completed!");
		
		System.out.println("\n=== teste: deletar ====");
		System.out.print("digite o id para deletar: ");
		int id = sc.nextInt();
		vendedorDao.Delete(id);
		System.out.println("delete completed");
		
		sc.close();
	}

}
