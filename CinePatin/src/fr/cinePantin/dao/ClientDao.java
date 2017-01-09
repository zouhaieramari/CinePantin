package fr.cinePantin.dao;

import java.util.List;

import fr.cinePatin.model.Client;

public interface ClientDao {
	
	void insert(Client c) throws Exception;
	void update(Client c) throws Exception;
	void delete(Client c) throws Exception;
	List<Client>select(String critere) throws Exception;
	

}
