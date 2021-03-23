package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Seller obj);
	Seller findById(Integer id); // Consultar id, se n tiver retorna null
	
	List<Seller> findAll();
	
}
