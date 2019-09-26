package ua.training.model.dao.impl;

import ua.training.model.dao.CommentDao;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.Comment;
import ua.training.model.entity.Request;

import java.sql.*;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class JDBCCommentDao implements CommentDao {
    private String queryAdd = "INSERT INTO comment ( comment, user_id, date) VALUES (?,?,?)";
    private String queryFindAll = "select * from comment ";

    private Connection connection;
    private UserDao userDao;

    public JDBCCommentDao(){}

    JDBCCommentDao(Connection connection, UserDao userDao) {
        this.connection = connection;
        this.userDao = userDao;
    }


    @Override
    public void add(Comment entity)  {
        try (PreparedStatement ps = connection.prepareStatement(queryAdd)) {
            ps.setString(1, entity.getComment());
            ps.setLong(2,entity.getUser().getId() );
            ps.setDate(3, Date.valueOf(LocalDate.now(Clock.system(ZoneId.of("Europe/Kiev")))));

            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException("Invalid input");
        }
    }

    @Override
    public Comment findByEmail(String email) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery(queryFindAll);

            while (rs.next()) {
                Comment result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    private Comment extractFromResultSet(ResultSet rs)
            throws SQLException {
        return Comment.builder()
                .id(rs.getLong("id"))
                .comment(rs.getString("comment"))
                .date(rs.getDate("date").toLocalDate())
                .user(userDao.findById(rs.getLong("user_id")))
                .build();
    }
}
