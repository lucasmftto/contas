package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.StatusDAO;
import br.com.entity.Status;

@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusDAO statusDAO;

	@Override
	public boolean addStatus(Status status) {
		try {
			statusDAO.addStatus(status);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Status getStatusId(Integer statusId) {
		return statusDAO.getStatusId(statusId);
	}

	@Override
	public void updateStatus(Status status) {
		statusDAO.updateStatus(status);
	}

	@Override
	public void deleteStatus(Integer statusId) {
		statusDAO.deleteStatus(statusId);
	}

}
