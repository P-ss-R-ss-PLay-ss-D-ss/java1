/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {

    public static Connection c;
    public static String url = "jdbc:mysql://localhost:3306/qlsv?characterEncoding=latin1&useConfigs=maxPerformance&useUnicode=true&characterEncoding=UTF-8";
    public static String username = "root";
    public static String password = "";
    // kết nối database
    public static Connection GetConnection() throws SQLException {
        if (c==null) {
            c = DriverManager.getConnection(url, username, password);   
            
        }
        return c;
    }
    
    public static int setData(String sql) throws SQLException{
        return GetConnection().createStatement().executeUpdate(sql);
    }
    public static ResultSet getData(String sql) throws SQLException{
        return GetConnection().createStatement().executeQuery(sql);
    }
}
