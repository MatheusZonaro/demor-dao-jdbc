package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoImplJDBC implements SellerDao{

	private Connection conn = null; // Para fazer conexao com banco de dados.
	
	public SellerDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			 
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "where seller.id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) { // next() se n for null
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId")); // pegar a coluna int do banco
				dep.setName(rs.getString("DepName"));
				
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBasesalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); // só dep pq ja instaciei acima
				
				return obj; // que ja contem tudo acima
			}
			return null; // nao existe nada da consulta, se n der nulo retorna 
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
