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
public class DatabaseConnect {
    private static String driver = "jdbc:datadirect:openedge://";
//    private static String host = "130.100.10.73:30107"; //teste
    private static String host = "130.100.10.69:30007"; //produção
    private static String databasename = "ems2admi";
    private static String user = "sysprogress";
    private static String password = "sysprogress";
    
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
