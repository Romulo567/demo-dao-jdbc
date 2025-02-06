package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		System.out.println("=== teste: procurar vendedor ====");
		Vendedor vendedor = vendedorDao.Read(1);
		
		System.out.println(vendedor);

	}

}
