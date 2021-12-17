
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
public class type_module {
    public int code;
    public String nom;
    public type_module (int code,String nom){
        this.code=code;
        this.nom=nom;
    }
    public type_module (){}
    public ArrayList<type_module> gettypelist(String s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<type_module> type_moduleList  = new ArrayList<>(); 
        if ("".equals(s)) {
            s="SELECT * FROM `type_module` order by code asc";
        }else s="SELECT * FROM `type_module` where nom='"+s+"'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            type_module p;
            while(rs.next())
            {
                p= new type_module(rs.getInt("code"),rs.getString("nom"));
                type_moduleList.add(p);
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
        return type_moduleList;
    }
    public String add(String nom){
        if ( verifier_nom(nom)) {
            String UpdateQuery = "INSERT INTO `type_module`(`nom`) VALUES(?)";
                Connection con=ConBD.getConnection();
                PreparedStatement ps;
            try {                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,nom);
                ps.executeUpdate();
                return "Type ajouter";
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
        ArrayList<type_module> p =gettypelist(s);
        return p.size()==0;
    }
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `type_module` where code="+code);
            ps.executeUpdate();
                return "Type suprimer";
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
