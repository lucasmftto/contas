package br.com.service;

import br.com.entity.Status;

public interface StatusService {
	
	boolean addStatus(Status status);
	
	Status getStatusId(Integer statusId);

	void updateStatus(Status status);

	void deleteStatus(Integer statusId);

}
