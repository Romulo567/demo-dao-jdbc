package model.dao;

import java.util.List;

import model.entities.Vendedor;

public interface VendedorDao {

	void Creat(Vendedor obj);
	Vendedor Read(int id);
	void Update(Vendedor obj);
	void Delete(int id);
	List<Vendedor> readAll();
}
