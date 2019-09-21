package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RequestDao;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RequestService {

    private DaoFactory daoFactory;
    private RequestDao requestDao;

    public RequestService(){
        this.daoFactory = DaoFactory.getInstance();
        this.requestDao = daoFactory.createRequestDao();
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

    public Optional<List<Request>>findByCreator(String creator){
        return Optional.ofNullable(requestDao.findByCreator(creator));
    }
//TODO: номер заказа не id
    public void updateRequest(String status, Long id){
        Request newRequest=Request.builder()
                .status(status)
                .id(id)
                .build();
        requestDao.update(newRequest);
    }

    public  Optional<List<Request>> findByMasterAndStatus(String master, String status){
        return Optional.ofNullable(requestDao.findByMasterAndStatus(master, status));
    }

    public Optional<List<Request>> findByStatus(String status){
        return Optional.ofNullable(requestDao.findByStatus(status));
    }

    public void updateStatusAndPriceAndUser(Long id,String status,Long price, User user){
         requestDao.updateStatusAndPriceAndUser(id, status,price,user);
    }

    public void updateStatusAndReason(Long id,String status,String reason){
        requestDao.updateStatusAndReason(id, status,reason);
    }
}
