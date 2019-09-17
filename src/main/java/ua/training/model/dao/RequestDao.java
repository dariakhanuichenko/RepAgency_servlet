package ua.training.model.dao;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface RequestDao extends GenericDao<Request>{

    List<Request> findByCreator(String creator);

    List<Request> findByMasterAndStatus(String master, String status);

    List<Request> findByStatus( String status);

    void updateStatusAndPriceAndUser(Long id, String status, Long price, User user);
}
