
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
class session {
    public int code,sem;
    public String desc;
    public session(int code,String desc,int sem){
        this.code=code;
        this.desc=desc;
        this.sem=sem;
    }
    public session(){}
    public ArrayList<session> getsessionlist(String nom){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        if("".equals(nom)) nom="SELECT * FROM `session` order  by description";
        else nom="SELECT * FROM `session` WHERE description='"+nom+"' order by description";
        ArrayList<session>  sl= new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery(nom);
            while(rs.next())
            {
                sl.add(new session(rs.getInt("code"),rs.getString("description"),rs.getInt("code_s")));
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur :"+ex);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return sl;
    }
    public int add(String n,int sem){
        if ( verifier(n)) {
            String UpdateQuery = "INSERT INTO `session` (`description`,`code_s`) VALUES(?,?)";
            Connection con=ConBD.getConnection();
            try {                
                PreparedStatement ps;
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,n);
                ps.setInt(2,sem);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
            ArrayList<session> sl = getsessionlist(n);
            return sl.get(0).code;
        }else
           return 0;
    }
    
    public String suprimer(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {            
            ps = con.prepareStatement("DELETE FROM `session` WHERE `code`="+code);
            ps.executeUpdate();
            return "Session suprimer";
        } catch (SQLException e) {
            return e.getMessage();
        }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
    }

    private boolean verifier(String n) {
        ArrayList<session> sl =getsessionlist(n);
        return sl.size()==0;
    }

}
