
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OMAR
 */
public class ConBD {
    public static users u;
    public ConBD(){}
    public static final Connection getConnection(){
        Connection con = null;        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edt?autoReconnect=true&useSSL=false","root","");
            
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(null,"Errur de connextion avec la base de donnee");
        }
        return con;
    }
}
