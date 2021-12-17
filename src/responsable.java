
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
public class responsable {
    public int code_p,code_e,code_s;
    public String nom_e,nom_p,nom_s;
    
    public responsable(int code_e,String nom_e,int code_p,String nom_p,int code_s,String nom_s){
        this.code_e=code_e;
        this.nom_e=nom_e;
        this.code_p=code_p;
        this.nom_p=nom_p;
        this.code_s=code_s;
        this.nom_s=nom_s;
    }
    public responsable(){
        
    }
    public ArrayList<responsable> getresponsablelist(int code_p,int code_s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<responsable> rl  = new ArrayList<>(); 
        try {     
            String s;
            if(code_p==0) s="SELECT code_prof as code_e,CONCAT(prof.nom,CONCAT(' ',prof.prenom)) as nom_e,responsable.code_p,promo.nom as nom_p,code_s,semaistre.nom as nom_s FROM prof,promo,responsable,semaistre WHERE prof.id=code_prof and semaistre.code=code_s and promo.code=responsable.code_p";
            else s="SELECT code_prof as code_e,CONCAT(prof.nom,CONCAT(' ',prof.prenom)) as nom_e,responsable.code_p,promo.nom as nom_p,code_s,semaistre.nom as nom_s FROM prof,promo,responsable,semaistre WHERE code_prof=prof.id and code_s=semaistre.code and responsable.code_p=promo.code and code_s="+code_s+" and responsable.code_p="+code_p;
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                rl.add(new responsable(rs.getInt("code_e"),rs.getString("nom_e"),rs.getInt("code_p"),rs.getString("nom_p"),rs.getInt("code_s"),rs.getString("nom_s")));
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
        return rl;
    }
    public String add(int code_e,int code_p,int code_s){
        Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try {
                String UpdateQuery = "INSERT INTO `responsable` (`code_p`, `code_prof`, `code_s`) VALUES(?,?,?)";                
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,code_p);
                ps.setInt(2,code_e);
                ps.setInt(3,code_s);
                ps.executeUpdate();
                return "responsable ajouter";
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
    public String suprimer(int code_e,int code_p,int code_s){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            String UpdateQuery = "DELETE FROM `responsable` WHERE `code_p`="+code_p+" and `code_prof`="+code_e+" and `code_s`="+code_s;
            ps = con.prepareStatement(UpdateQuery);
            ps.executeUpdate();
            return "Responsable suprimer";
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
