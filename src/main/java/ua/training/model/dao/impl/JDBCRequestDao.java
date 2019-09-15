package ua.training.model.dao.impl;

import ua.training.model.dao.RequestDao;
import ua.training.model.entity.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRequestDao implements RequestDao {

    private String queryAdd = "INSERT INTO request ( request, status, price, creator) VALUES (?,?,?,?)";
    private String queryFindAll = "SELECT * FROM request";
    private String queryUpdateRequest = "UPDATE request SET status = ? WHERE id = ?";
    private String queryDeleteById = "DELETE FROM user  WHERE id = ?";

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
            ps.executeUpdate();
        }
//        catch (SQLException e) {
//            throw new RuntimeException("Invalid input");
//        }
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
    public void update(Request entity) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateRequest)) {
            ps.setString(1, entity.getStatus());
            ps.setLong(2, entity.getId());
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
                .build();
    }
}
