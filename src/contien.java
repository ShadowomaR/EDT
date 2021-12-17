
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
public class contien {
    public int code_m,cour,td,tp,code_p,index,code_s;
    public String nom,lib,nom_t,nom_s;
    public ArrayList<contien> contienList  = new ArrayList<>();
    public contien(String lib,String nom,int code_m,int code_p,String nom_t,int code_s,String nom_s){
        this.code_m=code_m;        
        this.nom=nom;
        this.lib=lib;
        this.code_p=code_p;
        this.nom_t=nom_t;
        this.code_s=code_s;
        this.nom_s=nom_s;
        load_type();
    }
    public contien(){}
    public ArrayList<contien> getmcontienlist(int code_p,int code_m,int sem){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s;
        if(sem==0){
            if(code_m==0) s="SELECT lib,`module`.nom ,`code_mod`,type_module.nom as nom_t,semaistre.nom as nom_s,code_s FROM `contien`,`module`,type_module,semaistre WHERE code_prom="+code_p+" and module.code=code_mod  and contien.code_t=2 and semaistre.code=code_s and module.code_t=type_module.code GROUP by module.code";
            else s="SELECT lib,`module`.nom ,`code_mod`,type_module.nom as nom_t,semaistre.nom as nom_s,code_s FROM `contien`,`module`,type_module,semaistre WHERE code_prom="+code_p+" and module.code="+code_m+" and contien.code_t=2 and semaistre.code=code_s and  module.code_t=type_module.code GROUP by module.code";
        }else{
            if(code_m==0) s="SELECT lib,`module`.nom ,`code_mod`,type_module.nom as nom_t,semaistre.nom as nom_s,code_s FROM `contien`,`module`,type_module,semaistre WHERE code_prom="+code_p+" and module.code=code_mod  and contien.code_t=2 and semaistre.code=code_s and code_s="+sem+" and module.code_t=type_module.code GROUP by module.code";
            else s="SELECT lib,`module`.nom ,`code_mod`,type_module.nom as nom_t,semaistre.nom as nom_s,code_s FROM `contien`,`module`,type_module,semaistre WHERE code_prom="+code_p+" and module.code="+code_m+" and contien.code_t=2 and semaistre.code=code_s and code_s="+sem+" and module.code_t=type_module.code GROUP by module.code";
        
        }
        contienList  = new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                contienList.add(new contien(rs.getString("lib"),rs.getString("nom"),rs.getInt("code_mod"),code_p,rs.getString("nom_t"),rs.getInt("code_s"),rs.getString("nom_s")));
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
        return contienList;
    }
    public String add(int code_m,int code_p,int cour,int td,int tp,int sm){
        if ( verifier(code_m,code_p,sm)) {
            String UpdateQuery = "INSERT INTO `contien`(`code_mod`,`code_prom`,`code_t`,`nbr`,`code_s`) VALUES(?,?,?,?,?)";
            Connection con=ConBD.getConnection();
            try {                
                PreparedStatement ps;
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,code_m);
                ps.setInt(2,code_p);
                ps.setInt(3,1);
                ps.setInt(4,cour);
                ps.setInt(5,sm);
                ps.executeUpdate();
                
                UpdateQuery = "INSERT INTO `contien`(`code_mod`,`code_prom`,`code_t`,`nbr`,`code_s`) VALUES(?,?,?,?,?)";                
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,code_m);
                ps.setInt(2,code_p);
                ps.setInt(3,3);
                ps.setInt(4,td);
                ps.setInt(5,sm);
                ps.executeUpdate();
                
                UpdateQuery = "INSERT INTO `contien`(`code_mod`,`code_prom`,`code_t`,`nbr`,`code_s`) VALUES(?,?,?,?,?)";
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,code_m);
                ps.setInt(2,code_p);
                ps.setInt(3,2);
                ps.setInt(4,tp);
                ps.setInt(5,sm);
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
        }else
           return "Ce Nom exist déja";
    }
    
    public String suprimer(int code_p,int code_m){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {            
            
            String UpdateQuery = "DELETE FROM `contien` WHERE `code_prom`="+code_p+" and `code_mod`="+code_m;
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

    private boolean verifier(int code_m,int code_p,int code_s) {
        ArrayList<contien> p =getmcontienlist(code_p,code_m,code_s);
        return p.size()<3;
    }

    private void load_type() {
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<Integer> tl=new ArrayList<>();
        String s="SELECT nbr FROM `contien` WHERE code_prom="+code_p+" and code_mod="+code_m+" order by code_t";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                tl.add(rs.getInt("nbr"));
            }    
            cour=tl.get(0);
            td=tl.get(2);
            tp=tl.get(1);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur :"+ex);
        }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
    }
        
}
