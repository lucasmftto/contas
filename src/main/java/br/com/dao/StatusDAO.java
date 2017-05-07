package br.com.dao;

import java.util.List;

import br.com.entity.Status;

public interface StatusDAO {
	
	List<Status> getAllStatus();

	Status getStatusId(Integer statusId);

	void addStatus(Status status);

	void updateStatus(Status status);

	void deleteStatus(Integer statusId);

}
