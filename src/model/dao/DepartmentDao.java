package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao { // interface, e quem implementar vai ser obrigado a implementar tudo

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Department obj);
	Department findById(Integer id); // Consultar id, se n tiver retorna null
	
	List<Department> findAll();
	
}
