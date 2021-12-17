
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
class emploi {
public int m,j,t,h,grp,salle,prof;
    public String nom_m,nom_t,nom_ens,lib,nom_sl,nom_jour,nom_heur;
    public emploi(int module,int jour,int heur,int t,int grp){
        m=module;
        j=jour;
        h=heur;
        this.grp=grp;
        this.t=t;
        detail();
    }
    public emploi(int module,int jour,int heur,int t,int grp,int salle){
        m=module;
        j=jour;
        h=heur;
        this.grp=grp;
        this.t=t;
        this.salle=salle;
        detail();
    }

    emploi() {}
    private void detail(){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        try {            
            st = con.createStatement();
            rs = st.executeQuery("SELECT lib,module.nom as nom_m,type.nom as nom_t FROM module,type WHERE module.code="+m+" and type.code="+t);
            while(rs.next())
            {
                nom_m=rs.getString("nom_m");
                lib=rs.getString("lib");
                nom_t=rs.getString("nom_t");
                
            }
            st = con.createStatement();
            rs = st.executeQuery("SELECT nom FROM jour WHERE code="+j);
            while(rs.next())
            {
                nom_jour=rs.getString("nom");
                
            } 
            st = con.createStatement();
            rs = st.executeQuery("SELECT nom FROM heur WHERE code="+h);
            while(rs.next())
            {
                nom_heur=rs.getString("nom");
                
            } 
            if(salle!=0){
                rs = st.executeQuery("SELECT * FROM salle WHERE code="+salle);
                while(rs.next())
                {
                    nom_sl=rs.getString("nom");
                } 
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
    }
    public String add(int n, ArrayList<emploi> ne) {
        for(int i=0;i<ne.size();i++){
            insert(n,ne.get(i).m,ne.get(i).j,ne.get(i).h,ne.get(i).t,ne.get(i).grp);
        }
        return "Emploi Enregistrer";
    }
    private void insert(int n,int m,int j ,int h,int t,int grp){
        String UpdateQuery = "INSERT INTO `emploi`(`code_s`, `code_m`, `code_t`, `code_j`, `code_h`,`grp` ) VALUES(?,?,?,?,?,?)";
            Connection con=ConBD.getConnection();
            try {                
                PreparedStatement ps;
                ps = con.prepareStatement(UpdateQuery);
                ps.setInt(1,n);
                ps.setInt(2,m);
                ps.setInt(3,t);
                ps.setInt(4,j);
                ps.setInt(5,h);
                ps.setInt(6,grp);
                ps.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erreur :"+e);
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
    }
    public ArrayList<emploi> getemploilist(int n,int x){
        ArrayList<emploi> e=new ArrayList<>();
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s;
        if(x==0) s="SELECT * FROM `emploi` WHERE code_s="+n+" order by code_j asc,code_h asc, grp asc";
        else s="SELECT * FROM `emploi` WHERE `code_m`in(SELECT code_mod FROM contien where code_prom="+n+") and code_s="+x+" order by code_j asc,code_h asc, grp asc";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                e.add(new emploi(rs.getInt("code_m"),rs.getInt("code_j"),rs.getInt("code_h"),rs.getInt("code_t"),rs.getInt("grp"),rs.getInt("code_sl")));
                
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
        return e;
    }
    public String modiffier(int code_s,int m,int j ,int h,int t,int grp,int sl){
            Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try { 
                String s="UPDATE `emploi` SET `code_sl`="+sl+" WHERE `code_s`="+code_s+" and `code_m`="+m+" and `code_t`="+t+" and `code_j`="+j+" and `code_h`="+h+" and `grp`="+grp;
                ps = con.prepareStatement(s);
                ps.executeUpdate();
                return "séance modiffer";
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
    public ArrayList<emploi> getemploilist2(int id,int code_s){
        ArrayList<emploi> e=new ArrayList<>();
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        String s="SELECT * FROM `emploi` WHERE `code_m`in(SELECT code_mod FROM enseign where id_prof="+id+") and code_s="+code_s+" order by code_j asc,code_h asc, grp asc";
        System.out.println(s);
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            while(rs.next())
            {
                e.add(new emploi(rs.getInt("code_m"),rs.getInt("code_j"),rs.getInt("code_h"),rs.getInt("code_t"),rs.getInt("grp"),rs.getInt("code_sl")));
                
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
        return e;
    }
}
