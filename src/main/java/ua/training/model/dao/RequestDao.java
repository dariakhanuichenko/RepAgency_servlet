package ua.training.model.dao;

import ua.training.model.entity.Request;

import java.util.List;

public interface RequestDao extends GenericDao<Request>{

    List<Request> findByCreator(String creator);

    List<Request> findByMasterAndStatus(String master, String status);
}
