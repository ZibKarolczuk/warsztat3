package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.Exercise;
import pl.coderslab.warsztat3.model.UserGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

    public static List<Exercise> loadAll() throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT id, title, description FROM exercise;";

        List<Exercise> result = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                final int id = rs.getInt(1);
                final String title = rs.getString(2);
                final String description = rs.getString(3);

                result.add(new Exercise(id, title, description));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Exercise loadToEdit(String exerciseId) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT id, title, description FROM exercise WHERE id=" + exerciseId + ";";

        int id = 0;
        String title = "";
        String description = "";

        try (PreparedStatement ps = c.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                id = rs.getInt(1);
                title = rs.getString(2);
                description = rs.getString(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Exercise(id, title, description);
    }

    public static void createExercise(String title, String description) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "INSERT INTO exercise (title, description) VALUES (?, ?);";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, title);
            ps.setString(2, description);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editExercise(int exerciseId, String editedTitle, String editedDescription) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "UPDATE exercise SET title=?, description=? WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, editedTitle);
            ps.setString(2, editedDescription);
            ps.setInt(3, exerciseId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteExercise(String exerciseId) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "DELETE FROM exercise WHERE id=?;";
        try (PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, exerciseId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
