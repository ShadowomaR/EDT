
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
public class enseign {
    public int id,code_m,type,grp;
    public String nom_m,nom_t,lib;
    public enseign(){
        
    }
    public enseign(int id, int code_m, int type, String lib, String nom_m, String nom_t,int grp) {
        this.code_m=code_m;
        this.id=id;
        this.type=type;
        this.lib=lib;
        this.nom_m=nom_m;
        this.nom_t=nom_t;
        this.grp=grp;
    }
    public ArrayList<enseign> getenseignlist(int id,int code_m){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s;
        if(code_m==0) s="SELECT `id_prof`, `code_mod`, `type`,module.nom,module.lib,type.nom as 'nom_t',grp FROM `enseign`,`module`,`type` WHERE `id_prof`="+id+" and `code_mod`=module.code and type=type.code";
        else s="SELECT `id_prof`, `code_mod`, `type`,module.nom,module.lib,type.nom as 'nom_t',grp FROM `enseign`,`module`,`type` WHERE `id_prof`="+id+" and `code_mod`=module.code and type=type.code and code_mod="+code_m;
        
        ArrayList<enseign> enseignList  = new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                enseignList.add(new enseign(rs.getInt("id_prof"),rs.getInt("code_mod"),rs.getInt("type"),rs.getString("lib"),rs.getString("nom"),rs.getString("nom_t"),rs.getInt("grp")));
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
        return enseignList;
    }
    public String add(int id,int code_m,int n,int grp){
        Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try {
                String UpdateQuery = "INSERT INTO `enseign`(`id_prof`,`code_mod`,`type`,`grp`) VALUES(?,?,?,?)";                
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,id);
                ps.setInt(2,code_m);
                ps.setInt(3,n);
                ps.setInt(4,grp);
                ps.executeUpdate();
                return "Module ajouter";
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
    
    public String suprimer(int id,int code_m,int t,int grp){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            String UpdateQuery = "DELETE FROM `enseign` WHERE `id_prof`="+id+" and `code_mod`="+code_m+" and type="+t+" and grp="+grp;
            ps = con.prepareStatement(UpdateQuery);
            ps.executeUpdate();
            return "Module suprimer";
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
    public String getenseignant(int m,int t,int grp){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String n="",s="SELECT nom,prenom FROM `enseign`,prof WHERE prof.id=enseign.id_prof and code_mod="+m+" and type="+t+" and grp="+grp;
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                n=n=rs.getString("nom")+" "+rs.getString("prenom")+" /";
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
        return n;
    }
    public ArrayList<Integer> list(int sem){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s="select DISTINCT(id_prof) from enseign where code_mod in (select code_mod FROM contien where contien.code_s="+sem+")";
        
        ArrayList<Integer> pl  = new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                pl.add(rs.getInt("id_prof"));
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
        return pl;
    }
}
