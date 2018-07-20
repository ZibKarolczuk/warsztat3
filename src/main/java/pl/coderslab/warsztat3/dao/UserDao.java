package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.User;
import pl.coderslab.warsztat3.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<User> loadById(int idUser) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT s.id, updated, title FROM exercise\n" +
                "JOIN solution s on exercise.id = s.excercise_id\n" +
                "JOIN users u on s.users_id = u.id\n" +
                "WHERE users_id=" + idUser + " ORDER BY updated DESC ;";
        PreparedStatement ps = c.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        List<User> result = new ArrayList<>();

        while (rs.next()){
            final int id = rs.getInt(1);
            final LocalDate updated = rs.getDate(2).toLocalDate();
            final String title = rs.getString(3);

            result.add(new User(id, updated, title));
        }

        rs.close();
        ps.close();

        return result;
    }

    public static List<User> loadAll() throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT users.id, username, email, name, user_group_id " +
                "FROM users JOIN user_group ug on users.user_group_id = ug.id ORDER BY users.id ASC ;";

        List<User> result = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                final int id = rs.getInt(1);
                final String username = rs.getString(2);
                final String email = rs.getString(3);
                final String name = rs.getString(4);
                final int user_group_id = rs.getInt(5);

                result.add(new User(id, username, email, name, user_group_id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
