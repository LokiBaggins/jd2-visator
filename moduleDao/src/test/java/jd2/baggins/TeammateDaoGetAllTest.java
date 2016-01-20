package jd2.baggins;


import beans.Teammate;
import dbConnection.ConnectionPool;
import jd2.baggins.TeammateDao;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeammateDaoGetAllTest extends Assert {
        Connection conn = ConnectionPool.getInstance().getConnection();

    private int getRowsCounter() {
        int result = -1;
        PreparedStatement selData = null;
        ResultSet rs = null;
        String selDataStr = "SELECT count(*) as counter FROM teammates;";

        try {
            rs = selData.executeQuery();
            result = rs.getInt("counter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void testGetAll() {
        List<Teammate> tmList = new TeammateDao().getAll();
        assertEquals(tmList.size(), getRowsCounter());
    }

}
