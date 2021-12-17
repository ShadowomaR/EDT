
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
public class users {
    public int id,type;
    public String username,pwd;
    public users(int id,String username,String pwd,int type){
        this.id=id;
        this.username=username;
        this.pwd=pwd;
        this.type=type;
    }
    public users(){}
    public ArrayList<users> getuserslist(String nom,String pwd){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s;
        if ("".equals(nom)) {
            s="SELECT * FROM `users` WHERE `id`!="+ConBD.u.id;
        }else{
            if("".equals(pwd)) s="SELECT * FROM `users` WHERE `usernam`='"+nom+"' ";
            else s="SELECT * FROM `users` WHERE `usernam`='"+nom+"' and `pwd`='"+pwd+"'";
        }
        
        ArrayList<users> usersList  = new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                usersList.add(new users(rs.getInt("id"),rs.getString("usernam"),rs.getString("pwd"),rs.getInt("type")));
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
        return usersList;
    }
    public String add(String eml,String pwd,int t){
        if ( verifier(eml,"")){
            Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try {
                String UpdateQuery = "INSERT INTO `users`(`usernam`,`pwd`,`type`) VALUES(?,?,?)";                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,eml);
                ps.setString(2,pwd);
                ps.setInt(3,t);
                ps.executeUpdate();
                return "Utilisateur ajouter";
            } catch (SQLException e) {
                return e.getMessage();
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }   
        }else return "Cette E-mail exist déja";
        
    }

    private boolean verifier(String eml, String pwd) {
        ArrayList<users> p =getuserslist(eml,pwd);
        return p.size()==0;
    }
    public String suprimer(int id){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {            
            String UpdateQuery = "DELETE FROM `users` WHERE `id`="+id;
            ps = con.prepareStatement(UpdateQuery);
            ps.executeUpdate();
            return "Utilisateur suprimer";
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
}
