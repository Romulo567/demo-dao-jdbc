package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void Creat(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor Read(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Nome as DepNome "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.DepartamentoId = departamento.Id "
					+ "WHERE vendedor.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartamentoId"));
				dep.setName(rs.getString("DepNome"));
				Vendedor obj = new Vendedor();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Nome"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("SalarioBase"));
				obj.setBirthDate(rs.getDate("DataDeNascimento"));
				obj.setDepartment(dep);
				return obj;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void Update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendedor> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
