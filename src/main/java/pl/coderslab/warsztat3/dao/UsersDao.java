package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.User;
import pl.coderslab.warsztat3.model.UserGroup;
import pl.coderslab.warsztat3.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    public static List<Users> loadAllByGrupId(int idGroup) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT user_group_id, username, email FROM user_group RIGHT JOIN users u on user_group.id = u.user_group_id " +
                "WHERE u.user_group_id=" + idGroup + ";";
        PreparedStatement ps = c.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        List<Users> result = new ArrayList<>();

        while (rs.next()){
            final int id = rs.getInt(1);
            final String username = rs.getString(2);
            final String email = rs.getString(3);

            result.add(new Users(id, username, email));
        }

        rs.close();
        ps.close();

        return result;
    }



    public static void createUser(String username, String email, String password, int user_group_id) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "INSERT INTO users (username, email, password, user_group_id) VALUES (?, ?, ?, ?);";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, user_group_id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editUser(int userId, String editedName, String editedEmail, String editedGroup) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "UPDATE users SET username=?, email=?, user_group_id=? WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, editedName);
            ps.setString(2, editedEmail);
            ps.setString(3, editedGroup);
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String userId) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "DELETE FROM users WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
