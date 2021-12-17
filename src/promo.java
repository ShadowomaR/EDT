
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
public class promo {
    public int code,nbr;
    public String nom;
   
    public promo(int code,String nom,int nbr){
        this.code=code;
        this.nom=nom;
        this.nbr=nbr;
    }
    public promo(){}
    public ArrayList<promo> getpromolist(String s){
        Connection con=ConBD.getConnection();
        ResultSet rs; 
        Statement st;
        ArrayList<promo> promoList  = new ArrayList<>(); 
        if ("".equals(s)) {
            s="SELECT * FROM `promo` order by nom asc";
        }else s="SELECT * FROM `promo` where nom='"+s+"'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(s);
            promo p;
            while(rs.next())
            {
                p = new promo(rs.getInt("code"),rs.getString("nom"),rs.getInt("nbr"));
                promoList.add(p);
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
        return promoList;
    }
    public String add(String s,int nbr){
        if ( verifier_nom(s)) {
            Connection con=ConBD.getConnection();
            String UpdateQuery = "INSERT INTO `promo`(`nom`,`nbr`) VALUES(?,?)";                
            PreparedStatement ps;
            try {                
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1,s);
                ps.setInt(2,nbr);
                ps.executeUpdate();
                return "Promo ajouter";
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
        ArrayList<promo> p =getpromolist(s);
        return p.isEmpty();
    }
    
    public ArrayList<emploi> element(ArrayList<emploi> e,int sem){
        contien c=new contien();
        ArrayList<contien> cl = c.getmcontienlist(code, 0,sem);
        ArrayList<emploi> e1=new ArrayList<>();
        for(int j=0;j<e.size();j++){
            for(int i=0;i<cl.size();i++){
                if(cl.get(i).code_m==e.get(j).m) {
                    e1.add(new emploi(e.get(j).m, e.get(j).j, e.get(j).h, e.get(j).t,e.get(j).grp,e.get(j).salle));
                    //System.out.println(e.get(j).m);
                }
            }
        }
        return e1;
    }
    public String delet(int code){
        Connection con=ConBD.getConnection();
        PreparedStatement ps;
        try {
            
            ps = con.prepareStatement("delete from `promo` where code="+code);
            ps.executeUpdate();
                return "promo suprimer";
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
