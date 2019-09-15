package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RequestDao;
import ua.training.model.entity.Request;

import java.sql.SQLException;
import java.util.List;

public class RequestService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private RequestDao requestDao = daoFactory.createRequestDao();


    public List<Request> findAllUsers(){
        return requestDao.findAll();
    }

    public void addRequest(String request, String userName) throws SQLException {
        Request newRequest = Request.builder()
                .request(request)
                .status("new")
                .price(0L)
                .creator(userName)
                .build();
        requestDao.add(newRequest);
    }

    public List<Request>findByCreator(String creator){
        return requestDao.findByCreator(creator);
    }

    public void updateRequest(String status, Long id){
        Request newRequest=Request.builder()
                .status(status)
                .id(id)
                .build();
        requestDao.update(newRequest);
    }

    public  List<Request> findByMasterAndStatus(String master, String status){
        return requestDao.findByMasterAndStatus(master, status);
    }

}
