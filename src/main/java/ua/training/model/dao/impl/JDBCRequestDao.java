package ua.training.model.dao.impl;

import ua.training.model.dao.RequestDao;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRequestDao implements RequestDao {

    private String queryAdd = "INSERT INTO request ( request, status, price, creator, request_number) VALUES (?,?,?,?,?)";
    private String queryFindAll = "SELECT * FROM request";
    private String queryFindByCreatorAndStatus = "SELECT * FROM request WHERE creator=? and status=?";
    private String queryFindByCreatorAndNotStatus = "SELECT * FROM request WHERE creator=? and status !=?";
    private String queryUpdateRequest = "UPDATE request SET status = ? WHERE request_number = ?";
    private String queryDeleteById = "DELETE FROM request  WHERE id = ?";
    private String queryFindByMasterAndStatus = "SELECT request.* FROM request  inner join user  on request.user_id=user.id where user.email=? and request.status=?";

    private String queryFindByStatus="SELECT request.* FROM request  where  request.status=?";

    private String queryUpdateStatusAndPriceandMaster="UPDATE request SET status = ?, price=?, user_id=? WHERE request_number = ?";
    private String queryUpdateStatusAndReason="UPDATE request SET status = ?, reason=? WHERE request_number = ?";

    private Connection connection;

    public JDBCRequestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Request entity) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(queryAdd)) {
            ps.setString(1, entity.getRequest());
            ps.setString(2, entity.getStatus());
            ps.setInt(3, 0);
            ps.setString(4, entity.getCreator());
            ps.setLong(5, (long)Math.random()*100/(long)(1+Math.random()*15));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Invalid input");
        }
    }

    @Override
    public Request findByEmail(String email) {
        return null;
    }

    @Override
    public List<Request> findAll() {
        List<Request> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery(queryFindAll);

            while (rs.next()) {
                Request result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public List<Request> findByCreatorAndStatus(String creator, String status) {
        List<Request> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByCreatorAndStatus)) {
            ps.setString(1, creator);
            ps.setString(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public List<Request> findByCreatorAndNotStatus(String creator, String status) {
        List<Request> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByCreatorAndNotStatus)) {
            ps.setString(1, creator);
            ps.setString(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
    @Override
    public List<Request> findByMasterAndStatus(String master, String status) {
        List<Request> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByMasterAndStatus)) {
            ps.setString(1, master);
            ps.setString(2, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                resultList.add(extractFromResultSet(rs));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public List<Request> findByStatus(String status) {
        List<Request> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByStatus)) {
            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void updateStatusAndPriceAndUser(Long id, String status, Long price, User user) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateStatusAndPriceandMaster)) {
            ps.setString(1, status);
            ps.setLong(2,price);
            ps.setLong(3,user.getId());
            ps.setLong(4,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStatusAndReason(Long id, String status, String reason) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateStatusAndReason)) {
            ps.setString(1, status);
            ps.setString(2,reason);
            ps.setLong(3,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Request entity) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateRequest)) {
            ps.setString(1, entity.getStatus());
            ps.setLong(2, entity.getRequestNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryDeleteById)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Request extractFromResultSet(ResultSet rs)
            throws SQLException {
        return Request.builder()
                .id(rs.getLong("id"))
                .request(rs.getString("request"))
                .status(rs.getString("status"))
                .price(rs.getLong("price"))
                .reason(rs.getString("reason"))
                .creator(rs.getString("creator"))
                .requestNumber(rs.getLong("request_number"))
                .build();
    }
}
