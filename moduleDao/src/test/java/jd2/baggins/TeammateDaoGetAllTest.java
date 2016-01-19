package jd2.baggins;


import beans.Teammate;
import dbConnection.ConnectionPool;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.*;

public class TeammateDaoGetAllTest extends Assert {

    private int countRows() {
        int result = -1;
        Connection conn = ConnectionPool.getInstance().getConnection();
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
        Connection conn = ConnectionPool.getInstance().getConnection();


    }

}
