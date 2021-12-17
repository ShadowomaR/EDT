
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
public class salle {
    public int code;
    public String nom;
    public salle(int code,String nom){
        this.code=code;
        this.nom=nom;
    }
    public salle(){}
    public ArrayList<salle> getsallelist(String s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<salle> salleList  = new ArrayList<>(); 
        if ("".equals(s)) {
            s="SELECT * FROM `salle` order by nom asc";
        }else s="SELECT * FROM `salle` where nom='"+s+"'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            salle p;
            while(rs.next())
            {
                p = new salle(rs.getInt("code"),rs.getString("nom"));
                salleList.add(p);
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
        return salleList;
    }
    public String add(String nom){
        if ( verifier_nom(nom)) {
            Connection con=ConBD.getConnection();
                PreparedStatement ps;
            try {
                String UpdateQuery = "INSERT INTO `salle`(`nom`) VALUES(?)";
                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,nom);
                ps.executeUpdate();
                return "Salle ajouter";
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
        ArrayList<salle> p =getsallelist(s);
        return p.size()==0;
    }
    
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `salle` where code="+code);
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
    public ArrayList<salle> getsalle(String n){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<salle> salleList  = new ArrayList<>(); 
        if ("n".equals(n)) {
            n="SELECT * FROM `salle` WHERE `nom` like 'n%' order by nom asc";
        }else n="SELECT * FROM `salle` WHERE `nom` like 'l%' order by nom asc";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(n);
            salle p;
            while(rs.next())
            {
                p = new salle(rs.getInt("code"),rs.getString("nom"));
                salleList.add(p);
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
        return salleList;
    }
}
