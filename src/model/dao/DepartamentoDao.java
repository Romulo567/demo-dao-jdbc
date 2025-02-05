package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {
	
	void Creat(Departamento obj);
	Departamento Read(int id);
	void Update(Departamento obj);
	void Delete(int id);
	List<Departamento> readAll();
}
