
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
public class cahrg extends javax.swing.JFrame {

    private final emploi em=new emploi();
    private final session ss=new session();
    private final jour j=new jour();
    private final heur h=new heur();    
    private final ArrayList<jour> jl=j.getjourlist("");
    private final ArrayList<heur> hl=h.getheurlist("");
    private final ArrayList<session> ssl=ss.getsessionlist("");
    private final ArrayList<emploi> e1=new ArrayList<>();
    private final int id;
    /**
     * Creates new form cahrg
     * @param id
     * @param nom
     */
    public cahrg(int id,String nom) {
        initComponents();
        this.id=id;
        jMenuBar1.add(Box.createGlue());
        jMenuBar1.add(jMenu3);
        jMenu1.setText(nom);
        aficher_emploi2(tpan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tpan = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 590));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(415, 26));

        jMenu1.setText("jMenu1");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Imprimer");
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Error-icon.png"))); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1091, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        this.dispose();
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane tpan;
    // End of variables declaration//GEN-END:variables

    private void aficher_emploi2(JTabbedPane t) {
        
        ArrayList<emploi> e1;        
        t.removeAll();
        int js=jl.size(),hs=hl.size();
        JPanel pan1,pan2,pan3 ;  
        JLabel lbl;
        String s;
        Color color = new Color(0, 0, 0);
        int ind=0;
        for(session pr :ssl){
            pan3=new JPanel(new GridLayout(1, 1, 5, 0));
            pan1=new JPanel(new GridLayout(hs+1, js+1, 2, 5));
            pan1.setBackground(Color.WHITE);
            e1=trier(em.getemploilist2(id, pr.code));
            //e1=em.getemploilist2(id, pr.code);
            pan1.add(new JLabel());
            for(int k=0;k<js;k++) {
                lbl=new JLabel(" "+jl.get(k).nom);
                lbl.setFont(new java.awt.Font("Tahoma", 1, 12));
                lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbl.setBorder(javax.swing.BorderFactory.createLineBorder(color));
                pan1.add(lbl);
            }
            for(int k=0;k<hs;k++){
                lbl=new JLabel(hl.get(k).nom);
                lbl.setFont(new java.awt.Font("Tahoma", 1, 12));
                lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbl.setBorder(javax.swing.BorderFactory.createLineBorder(color));
                pan1.add(lbl);                
                for(int l=0;l<js;l++){ 
                    s="<html>";
                    for(int n=0;n<e1.size();n++){
                        if(e1.get(n).j==jl.get(l).code && e1.get(n).h==hl.get(k).code) {
                            if(e1.get(n).t==1) {
                                    s=s+e1.get(n).lib+" "+e1.get(n).nom_t;
                                    if(e1.get(n).salle!=0) s=s+" "+e1.get(n).nom_sl;                                    
                                    s=s+"<br>";
                                }
                                else {
                                    s=s+"&nbsp;G"+e1.get(n).grp+" "+e1.get(n).lib+" "+e1.get(n).nom_t;
                                    if(e1.get(n).salle!=0) s=s+" "+e1.get(n).nom_sl;                                    
                                    s=s+"<br>";
                                }                           
                        }                    
                    }
                    s=s+"</html><div style='padding:1px;text-align:left'>";
                    lbl=new JLabel(s);
                    lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lbl.setBorder(javax.swing.BorderFactory.createLineBorder(color));
                    lbl.setFont(new java.awt.Font("Tahoma", 1, 12));
                    lbl.setSize(400, 300);
                    pan1.add(lbl);
                }
            }
            pan3.add(pan1);
            t.addTab(" "+pr.desc+" ", pan3);
        }
    }

    private ArrayList<emploi> trier(ArrayList<emploi> e1) {
        enseign es=new enseign();
        ArrayList<enseign> esl=es.getenseignlist(id, 0);
        ArrayList<emploi> e=new ArrayList<>();
        for(int i=0;i<esl.size();i++){
            for(int j=0;j<e1.size();j++){
                if(esl.get(i).code_m==e1.get(j).m && esl.get(i).grp==e1.get(j).grp && esl.get(i).type==e1.get(j).t){
                    e.add(e1.get(j));
                }
            }
        }
        return e;
    }
}