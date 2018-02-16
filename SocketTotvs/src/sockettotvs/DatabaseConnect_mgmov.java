/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettotvs;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fernando.reis
 */
public class DatabaseConnect_mgmov {
    private static String driver = "jdbc:datadirect:openedge://";
//    private static String host = "130.100.10.73:30112"; // base de teste
    private static String host = "130.100.10.69:30023"; // base de produção
    private static String databasename = "mov2mult";
    private static String user = "sistemaweb";
    private static String password = "sistemaweb";
    
    static Connection con = null;
    
    
    public static Connection getConnection()
    {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection(driver, host, databasename, user, password);
    }

    private static Connection getConnection(String driver,String host,String databasename, String user, String password)
    {
        try
        {            
            String url = driver + host + ";databaseName=" + databasename + ";user=" + user + ";password=" + password+";";
            con=DriverManager.getConnection(url);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }
}
