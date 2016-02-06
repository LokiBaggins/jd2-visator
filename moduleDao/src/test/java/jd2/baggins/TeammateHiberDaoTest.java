package jd2.baggins;

import jd2.baggins.beans.Teammate;
import jd2.baggins.dao.TeammateHiberDao;
import jd2.baggins.utils.HibernateUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class TeammateHiberDaoTest extends Assert {
    private Teammate tm = new Teammate();
    private String tNickName = "test_nickName";
    private String tNickName_up = "test_nickNameUpdated";

//    @BeforeClass
//    public static void resetTestDB() {
//        Connection mConnection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            mConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/festival_team_db", "root", "123456");
//            ScriptRunner runner = new ScriptRunner(mConnection, false, false);
//            String file = "db_scripts/festival_team_db.sql";
//            runner.runScript(new BufferedReader(new FileReader(file)));
//        } catch (ClassNotFoundException e) {
//            System.err.println("Unable to get mysql driver: " + e);
//        } catch (SQLException e) {
//            System.err.println("Unable to connect to server: " + e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testGetAll() {
        int rowsCount = -1;
        PreparedStatement selData = null;
        ResultSet rs = null;
        String selDataStr = "SELECT count(*) as 'counter' FROM t_teammates;";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/festival_team_db", "root", "123456");
            selData = conn.prepareStatement(selDataStr);
            rs = selData.executeQuery();
            if (rs.next()) {
                rowsCount = rs.getInt("counter");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Teammate> tmList = new TeammateHiberDao().getAll();
        assertEquals(rowsCount, tmList.size());
    }

    @Test
    public void testGetById() {
        int id = 1;
        Teammate tm = new TeammateHiberDao().getById(id);
        assertEquals(tm.getId(), id);
    }

    @Test
    public void testAdd() {
        tm.setNickName(tNickName);
        new TeammateHiberDao().add(tm);

        boolean contains = false;
        List<Teammate> tmList = new TeammateHiberDao().getAll();
        for (Teammate t : tmList) {
            if (t.getNickName().equals(tNickName)) { contains = true; }
        }
        assertTrue("Table contains added teammmate", contains);
    }
}
