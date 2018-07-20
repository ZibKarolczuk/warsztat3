package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.UserGroup;
import pl.coderslab.warsztat3.model.Users;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {

    public static List<UserGroup> loadAll() throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT id, name FROM user_group;";

        List<UserGroup> result = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                final int id = rs.getInt(1);
                final String name = rs.getString(2);

                result.add(new UserGroup(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void createGroup(String name) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "INSERT INTO user_group (name) VALUES (?);";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editGroup(String groupId, String editedName) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "UPDATE user_group SET name=? WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, editedName);
            ps.setString(2, groupId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteGroup(String groupId) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "DELETE FROM user_group WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, groupId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
