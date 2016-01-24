package jd2.baggins.dao;

import jd2.baggins.beans.Teammate;
import dbConnection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeammateDao implements Dao<Teammate> {


    @Override
    public boolean add(Teammate teammate) {
       return false;
    }

    @Override
    public List<Teammate> getAll() {
        List<Teammate> teammates = new ArrayList<>();
        Teammate tm;
        PreparedStatement selData;
        ResultSet rs;
        String selDataStr = "SELECT * FROM t_teammates;";
        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
            selData = conn.prepareStatement(selDataStr);
            rs = selData.executeQuery();
            while (rs.next()) {
                tm = new Teammate();
                tm.setNickName(rs.getString("c_nick_name"));
                teammates.add(tm);
            }
        } catch (SQLException e) {
            //    TODO: add own exceptions
            e.printStackTrace();
        }
        return teammates;
    }

    @Override
    public Teammate getById(int id) {
        return null;
    }

    @Override
    public boolean update(Teammate teammate) {
        return false;
    }

    @Override
    public boolean delete(Teammate teammate) {
        return false;
    }
}
