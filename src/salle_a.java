
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
public class salle_a extends javax.swing.JFrame {
    private int code_s,code_p,index=0,sem;
    private emploi em=new emploi();
    private ArrayList<emploi> e;
    private ArrayList<salle> sl ;
    private prof p=new prof();
    private ArrayList<prof> pl ;
    private enseign es=new enseign();
    private String nom;
    /**
     * Creates new form salle_a
     */
    public salle_a(ArrayList<emploi> e,int code_s,int code_p,String nom,int sem) {
        initComponents();
        jMenuBar1.add(Box.createGlue());
        jMenuBar1.add(jMenu3);
        jMenu1.setText(nom);
        this.e=e;
        this.code_s=code_s;
        this.code_p=code_p;
        this.nom=nom;
        this.sem=sem;
        load_salle();
        load_emmloi(e);
        load_prof();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        gh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cm = new javax.swing.JComboBox<>();
        cme = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        text = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lib", "nom", "Séance ", "type", "groupe", "salle", "Enseignant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMaxWidth(100);
            table1.getColumnModel().getColumn(1).setMaxWidth(400);
            table1.getColumnModel().getColumn(2).setMaxWidth(200);
            table1.getColumnModel().getColumn(3).setMaxWidth(100);
            table1.getColumnModel().getColumn(4).setMaxWidth(50);
            table1.getColumnModel().getColumn(5).setMaxWidth(200);
            table1.getColumnModel().getColumn(6).setMaxWidth(400);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, 1050, 260));

        gh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(gh, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 80, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Modiffier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 100, 30));

        cm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        cme.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cme, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 350, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Enseignant :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Salle :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 100, 30));

        text.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 640, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 640, 170));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(415, 26));

        jMenu1.setText("jMenu1");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Imprimer");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1107, 536));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        this.dispose();
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void table1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MousePressed
        index=table1.getSelectedRow();
        text.setText(e.get(index).lib+" "+e.get(index).nom_m+" "+e.get(index).nom_jour+" "+e.get(index).nom_heur+" "+e.get(index).nom_t+" Groupe:"+e.get(index).grp);
    }//GEN-LAST:event_table1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!"".equals(text.getText())){
            String s=em.modiffier(code_s, e.get(index).m, e.get(index).j, e.get(index).h, e.get(index).t, e.get(index).grp, sl.get(cm.getSelectedIndex()).code);
            JOptionPane.showMessageDialog(null,s);
            e=em.getemploilist(code_p,code_s);
            load_emmloi(e);
            text.setText("");
            index=0;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!"".equals(text.getText())){
            
            JOptionPane.showMessageDialog(null,es.add(pl.get(cme.getSelectedIndex()).id,e.get(index).m, e.get(index).t, e.get(index).grp));
            load_emmloi(e);
            text.setText("");
            index=0;
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        imprimer im=new imprimer();
        im.afficher2(e, code_p, sem, nom);
    }//GEN-LAST:event_jMenu2MousePressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cm;
    private javax.swing.JComboBox<String> cme;
    private javax.swing.JLabel gh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables

    private void load_emmloi(ArrayList<emploi> e1) {
        
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        gh.setText(e.size()+" ");
        for(int i = 0; i < e.size(); i++)
        {
            row[0] = e.get(i).lib;
            row[1] = e.get(i).nom_m;
            row[2] = e.get(i).nom_jour+" "+e.get(i).nom_heur;;
            row[3] = e.get(i).nom_t;
            row[4] = e.get(i).grp;
            if (e.get(i).nom_sl==null) {
                row[5] ="";
            }else row[5] = e.get(i).nom_sl;
            row[6] = es.getenseignant(e.get(i).m, e.get(i).t, e.get(i).grp);
            model.addRow(row);
        }
    }

    private void load_salle() {
        salle s=new salle();
        sl = s.getsallelist("");
        cm.removeAllItems();
        for(int i = 0; i < sl.size(); i++)
        {
            cm.addItem(sl.get(i).nom);
        }
    }
    private void load_prof() {
        pl=p.getproflist("", "",0);
        cme.removeAllItems();
        for(int i = 0; i < pl.size(); i++)
        {
            cme.addItem(pl.get(i).nom+" "+pl.get(i).prenom);
        }
    }
}
