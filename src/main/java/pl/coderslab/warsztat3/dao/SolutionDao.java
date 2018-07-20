package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class SolutionDao  {

    public static List<Solution> loadAll(int limit) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT s.id, updated, title, username  FROM exercise\n" +
                "JOIN solution s on exercise.id = s.excercise_id\n" +
                "JOIN users u on s.users_id = u.id\n" +
                "ORDER BY updated DESC\n" +
                "LIMIT " + limit + ";";
        PreparedStatement ps = c.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        List<Solution> result = new ArrayList<>();

        while (rs.next()){
            final int id = rs.getInt(1);
            final LocalDate updated = rs.getDate(2).toLocalDate();
            final String title = rs.getString(3);
            final String username = rs.getString(4);

            result.add(new Solution(id, updated, title, username));
        }

        rs.close();
        ps.close();

        return result;
    }

    public static String loadById(int id) throws SQLException {
        Connection c = DbUtil.getConn();
        final String SQL = "SELECT description FROM solution WHERE id=" + id + " ;";
        PreparedStatement ps = c.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        String result = "invalid result";

        while (rs.next()){
            result = rs.getString(1);
        }

        rs.close();
        ps.close();

        return result;
    }

}
