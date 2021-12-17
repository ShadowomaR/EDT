
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
public class jour {
    public int code, grp;
    public String nom;
    public jour(int code,String nom){
        this.code=code;
        this.nom=nom;
    }
    public jour(){}
    public ArrayList<jour> getjourlist(String s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<jour> jourList  = new ArrayList<>(); 
        if ("".equals(s)) {
            s="SELECT * FROM `jour` order by code asc";
        }else s="SELECT * FROM `jour` where nom='"+s+"'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            jour p;
            while(rs.next())
            {
                p = new jour(rs.getInt("code"),rs.getString("nom"));
                jourList.add(p);
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
        return jourList;
    }
    public String add(String nom){
        if ( verifier_nom(nom)) {
            String UpdateQuery = "INSERT INTO `jour`(`nom`) VALUES(?)";
                Connection con=ConBD.getConnection();
                PreparedStatement ps;
            try {                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,nom);
                ps.executeUpdate();
                return "Jour ajouter";
            } catch (SQLException e) {
                return e.getMessage();
            }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }   
        }else
           return "Ce Nom exist déja";
    }

    private boolean verifier_nom(String s) {
        ArrayList<jour> p =getjourlist(s);
        return p.size()==0;
    }
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `jour` where code="+code);
            ps.executeUpdate();
                return "Salle suprimer";
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
