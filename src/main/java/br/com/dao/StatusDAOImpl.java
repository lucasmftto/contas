package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.entity.Status;

@Transactional
@Repository
public class StatusDAOImpl implements StatusDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Status> getAllStatus() {
		String hql = "FROM Status as c ORDER BY c.cod_status";
		return (List<Status>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Status getStatusId(Integer statusId) {
		return entityManager.find(Status.class, statusId);
	}

	@Override
	public void addStatus(Status status) {
		entityManager.persist(status);
	}

	@Override
	public void updateStatus(Status status) {
		Status s= getStatusId(status.getCod_status());
		
		s.setCod_status(status.getCod_status());
		s.setDescricao(status.getDescricao());
		entityManager.flush();
	}

	@Override
	public void deleteStatus(Integer statusId) {
		entityManager.remove(getStatusId(statusId));

	}

}
