
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
public class module {
    public int code,code_t;
    public String nom,lib,nom_t;
    public module(int code,String nom,String lib){
        this.code=code;
        this.nom=nom;
        this.lib=lib;
    }
    public module(int code,String nom,String lib,String nom_t,int code_t){
        this.code=code;
        this.nom=nom;
        this.lib=lib;
        this.code_t=code_t;
        this.nom_t=nom_t;
    }
    public module(){}
    public ArrayList<module> getmodulelist(int prof){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<module> moduleList  = new ArrayList<>(); 
        try {            
            st = con.createStatement();
            rs = st.executeQuery("select code,lib,nom from module,enseign where id_prof="+prof);
            while(rs.next())
            {
                moduleList.add(new module(rs.getInt("code"),rs.getString("nom"),rs.getString("lib")));
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur :"+ex);
        }
        finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
        return moduleList;
    }
    public String add(String lib,String nom,int c){
        if ( verifier_nom(lib)) {
            Connection con=ConBD.getConnection();
                PreparedStatement ps;
            try {
                
                ps = con.prepareStatement("INSERT INTO `module`(`nom`,`lib`,code_t) VALUES(?,?,?)");
                ps.setString(1,nom);
                ps.setString(2,lib);
                ps.setInt(3, c);
                ps.executeUpdate();
                return "module ajouter";
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
        ArrayList<module> p =getmodulelist(s,0);
        return p.size()==0;
    }   
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
                
                ps = con.prepareStatement("DELETE FROM `module` WHERE `code`="+code);
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
    public ArrayList<module> getmodulelist(String s,int r){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<module> moduleList  = new ArrayList<>(); 
        switch(r){
            case 0:if ("".equals(s)) {
                        s="SELECT module.`code`, module.`nom`, `lib`, `code_t`,type_module.nom as nom_t FROM `module`,type_module where type_module.code=code_t order by module.nom asc  ";
                    }else s="SELECT module.`code`, module.`nom`, `lib`, `code_t`,type_module.nom as nom_t FROM `module`,type_module where lib='"+s+"' and type_module.code=code_t order by module.nom asc ";
            break;
            case -1:s="SELECT module.`code`, module.`nom`, `lib`, `code_t`,type_module.nom as nom_t FROM `module`,type_module where (`module`.nom like '%"+s+"%' or lib like '%"+s+"%') and type_module.code=code_t order by module.nom asc ";
            break;
            case -2:s="SELECT module.`code`, module.`nom`, `lib`, `code_t`,type_module.nom as nom_t FROM `module`,type_module where `module`.code in (SELECT DISTINCT(code_mod) FROM contien) type_module.code=code_t order by module.nom asc ";
            break;
        }    
        //System.out.println(s);
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            module p;
            while(rs.next())
            {
                moduleList.add(new module(rs.getInt("code"),rs.getString("nom"),rs.getString("lib"),rs.getString("nom_t"),rs.getInt("code_t")));
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur :"+ex);
        }
        finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            } 
        return moduleList;
    }
    }

