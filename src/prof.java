
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
public class prof {
    public int id;
    public String nom,prenom,email;
    public prof(int id,String nom,String prenom,String email){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
    }
    public prof(){}
    public ArrayList<prof> getproflist(String nom,String prenom,int n){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<prof> profList  = new ArrayList<>();
        switch(n){
            case -1:nom="select * from prof where id in (select distinct(id_prof) from enseign";
                break;
            case 0:if ("".equals(nom))  nom="SELECT * FROM `prof` order by nom asc";
                   else nom="SELECT * FROM `prof` where nom='"+nom+"' and prenom='"+prenom+"'";
                break;
            default:nom="SELECT * FROM `prof` where nom like '%"+nom+"%' or prenom like '%"+nom+"%'";
        }
        try {            
            st = con.createStatement();
            rs = st.executeQuery(nom);
            prof p;
            while(rs.next())
            {
                p = new prof(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"));
                profList.add(p);
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
        return profList;
    }
    public String add(String nom,String prenom,String email){
        if ( verifier_nom(nom,prenom)) {
            Connection con=ConBD.getConnection();
            PreparedStatement ps;
            try {
                String UpdateQuery = "INSERT INTO `prof`(`nom`,`prenom`,`email`) VALUES(?,?,?)";
                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,nom);
                ps.setString(2,prenom);
                ps.setString(3,email);
                ps.executeUpdate();
                return "Enseignant ajouter";
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

    private boolean verifier_nom(String nom,String prenom) {
        ArrayList<prof> p =getproflist(nom,prenom,0);
        return p.size()==0;
    }
    public String supprimer(int id){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `prof` where id="+id);
            ps.executeUpdate();
                return "Enseignant suprimer";
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
