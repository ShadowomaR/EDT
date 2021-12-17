
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
public class heur {
    public int code;
    public String nom;
    public heur(int code,String nom){
        this.code=code;
        this.nom=nom;
    }
    public heur(){}
    public ArrayList<heur> getheurlist(String s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<heur> heurList  = new ArrayList<>(); 
        if ("".equals(s)) {
            s="SELECT * FROM `heur` order by code asc";
        }else s="SELECT * FROM `heur` where nom='"+s+"'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            heur p;
            while(rs.next())
            {
                p = new heur(rs.getInt("code"),rs.getString("nom"));
                heurList.add(p);
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
        return heurList;
    }
    public String add(String nom){
        if ( verifier_nom_h(nom)) {
            String UpdateQuery = "INSERT INTO `heur`(`nom`) VALUES(?)";
            Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try {                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,nom);
                ps.executeUpdate();
                return "Heur ajouter";
            } catch (SQLException e) {
                return e.getMessage();
            }  finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
            
        }else
           return "Ce Nom exist déja";
    }

    private boolean verifier_nom_h(String s) {
        ArrayList<heur> p =getheurlist(s);
        return p.size()==0;
    }
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `heur` where code="+code);
            ps.executeUpdate();
                return "Heur suprimer";
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
