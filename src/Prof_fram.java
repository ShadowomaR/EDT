
import java.awt.Frame;
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
public class Prof_fram extends javax.swing.JFrame {

    private prof pr=new prof();
    private enseign e=new enseign();
    private module md=new module();
    private responsable r=new responsable();
    private ArrayList<module> m ;
    private ArrayList<prof> prl;
    private ArrayList<enseign> el;
    private ArrayList<promo> pl;
    private ArrayList<responsable> rl;
    private int id;
    /**
     * Creates new form main
     */
    public Prof_fram() {
        initComponents();
        
        jMenuBar1.add(Box.createGlue());
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu8);
        jMenuBar1.add(jMenu2);
        jMenu3.setSelected(true);
        if(ConBD.u.type==2){
            jMenu9.setVisible(false);
            jMenu1.setVisible(false);
        }
        //jMenuBar1.remove(3);
        load_prof("");
        load_module("",0);
        
        promo p=new promo();
        pl=p.getpromolist("");
        load_promos();
        load_resp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        bg = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        pan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        p_r = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pan1 = new javax.swing.JPanel();
        td = new javax.swing.JRadioButton();
        tp = new javax.swing.JRadioButton();
        cour = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Recherch = new javax.swing.JTextField();
        cmb = new javax.swing.JComboBox<>();
        grp = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cms = new javax.swing.JComboBox<>();
        cmp = new javax.swing.JComboBox<>();
        cme = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("Affecter");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem4.setText("Supprimer");
        jMenuItem4.setToolTipText("");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("Afficher EDT");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem5MousePressed(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem2.setText("Suprimer");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem3.setText("Suprimer");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jPopupMenu3.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane3.setBackground(new java.awt.Color(0, 102, 102));

        pan.setBackground(new java.awt.Color(0, 102, 102));
        pan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajouter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Email :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 50, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nom :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Prenom :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 60, 30));

        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setComponentPopupMenu(new pup());
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 200, 30));

        nom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nom.setComponentPopupMenu(new pup());
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 180, 30));

        prenom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prenom.setComponentPopupMenu(new pup());
        jPanel1.add(prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 190, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 80, 30));

        pan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 950, 80));

        table1.setAutoCreateRowSorter(true);
        table1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setComponentPopupMenu(jPopupMenu1);
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMaxWidth(300);
            table1.getColumnModel().getColumn(1).setMaxWidth(300);
            table1.getColumnModel().getColumn(2).setMaxWidth(400);
        }

        pan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 720, 410));

        p_r.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_r.setComponentPopupMenu(new pup());
        p_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_rKeyReleased(evt);
            }
        });
        pan.add(p_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 350, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recherch :");
        pan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 90, 30));

        pan1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pan1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.add(td);
        td.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        td.setText("TD");
        pan1.add(td, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, 30));

        bg.add(tp);
        tp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tp.setText("TP");
        pan1.add(tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, 30));

        bg.add(cour);
        cour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cour.setText("Cours");
        pan1.add(cour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pan1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 80, 30));

        table2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lib", "Nom", "Type", "Groupe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setComponentPopupMenu(jPopupMenu2);
        table2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setMaxWidth(150);
            table2.getColumnModel().getColumn(1).setMaxWidth(400);
            table2.getColumnModel().getColumn(2).setMaxWidth(100);
            table2.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        pan1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 150, 500, 240));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Groupe :");
        pan1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 60, 30));

        Recherch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Recherch.setComponentPopupMenu(new pup());
        Recherch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RecherchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RecherchKeyTyped(evt);
            }
        });
        pan1.add(Recherch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 340, 30));

        cmb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", " " }));
        pan1.add(cmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 500, 30));

        grp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grp.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        pan1.add(grp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 50, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Recherch :");
        pan1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 80, 30));

        pan.add(pan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 540, 410));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gérer les enseignants");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 350, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajouter responsable", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Promos :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 70, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Semestre  :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Enseignant :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 30));

        cms.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre 1", "Semestre 2" }));
        jPanel2.add(cms, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 120, 30));

        cmp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 150, 30));

        cme.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cme, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 30, 300, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Ajoutrer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, 30));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enseigant", "Promo", "Semastre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.setComponentPopupMenu(jPopupMenu3);
        table3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(table3);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 80, 940, 290));

        pan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, 1040, 390));
        pan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 1140, 50, 30));

        jScrollPane3.setViewportView(pan);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 1350, 690);

        jMenu3.setText("Enseignant");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("module");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu5MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setText("seance");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu6MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Promos");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu7MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu9.setText("EDT");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu9MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        jMenu1.setText("Utilisateur");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Déconncter");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu8.setText("_");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu8MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Error-icon.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1350, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        System.exit(0);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
        module_fram mf=new module_fram();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MousePressed
        promo_fram pf=new promo_fram();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu7MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(!nom.getText().equals("") && !prenom.getText().equals("") && !email.getText().equals("")){
            prof f=new prof();
            JOptionPane.showMessageDialog(rootPane,f.add(nom.getText(),prenom.getText(),email.getText()));
            prl  =pr.getproflist("", "",0);
            load_prof("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MousePressed
        seance sf=new seance();
        sf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu6MousePressed

    private void p_rKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_rKeyReleased
        load_prof(p_r.getText());
    }//GEN-LAST:event_p_rKeyReleased

    private void jMenu8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jMenu8MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        try{
            id=prl.get(table1.getSelectedRow()).id;
            pan1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Affectation a "+table1.getValueAt(table1.getSelectedRow(), 0)+" "+table1.getValueAt(table1.getSelectedRow(), 1), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));
        }catch(Exception e) {
            System.err.print(e);
        }
        load_prf_module();
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void RecherchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RecherchKeyReleased
        load_module(Recherch.getText(), -1);
    }//GEN-LAST:event_RecherchKeyReleased

    private void RecherchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RecherchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_RecherchKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s="";
        int mr= m.get(cmb.getSelectedIndex()).code;
        if (cour.isSelected()) s=e.add(id, mr,1,1);
        if (td.isSelected()) s=e.add(id, mr,3,(int) grp.getValue());
        if (tp.isSelected()) s=e.add(id, mr,2,(int) grp.getValue());
        if(s!=""){
            JOptionPane.showMessageDialog(null,s);
            load_prf_module();
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        int code_m=0,i=0;
        try {
            i=table2.getSelectedRow();
            code_m=el.get(i).code_m;
            int f=JOptionPane.showConfirmDialog(null,"Vouler vous suprimer ce module","Suprimer", JOptionPane.YES_NO_OPTION);
            if (f==0) {
                JOptionPane.showMessageDialog(null,e.suprimer(id, el.get(i).code_m,el.get(i).type,el.get(i).grp));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Selectioner un module");
        }
        load_prf_module();
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenu9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MousePressed
        Edt_fram em=new Edt_fram();
        em.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu9MousePressed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        ConBD.u=null;
        login l=new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MousePressed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        users_fram uf=new users_fram();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null,r.add(prl.get(cme.getSelectedIndex()).id,pl.get(cmp.getSelectedIndex()).code,cms.getSelectedIndex()+1));
        load_resp();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        try {
            int f=JOptionPane.showConfirmDialog(null,"Vouler vous suprimer ce responsable","Suprimer Responsable", JOptionPane.YES_NO_OPTION);
            if (f==0) {
                JOptionPane.showMessageDialog(null,r.suprimer(rl.get(table3.getSelectedRow()).code_e,rl.get(table3.getSelectedRow()).code_p,rl.get(table3.getSelectedRow()).code_s));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Selectioner un responsable");
        }
        load_resp();
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MousePressed
        id=prl.get(table1.getSelectedRow()).id;
        cahrg cg=new cahrg(id,prl.get(table1.getSelectedRow()).nom+" "+prl.get(table1.getSelectedRow()).prenom);
        cg.setVisible(true);
    }//GEN-LAST:event_jMenuItem5MousePressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        
        id=prl.get(table1.getSelectedRow()).id;        
        try {
            int f=JOptionPane.showConfirmDialog(null,"Vouler vous suprimer cette enseignant","Suprimer Enseignant", JOptionPane.YES_NO_OPTION);
            if (f==0) {
                JOptionPane.showMessageDialog(null,pr.supprimer(id));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Selectioner un enseignant");
        }
        load_prof("");
    }//GEN-LAST:event_jMenuItem4MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prof_fram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prof_fram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prof_fram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prof_fram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prof_fram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Recherch;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JComboBox<String> cmb;
    private javax.swing.JComboBox<String> cme;
    private javax.swing.JComboBox<String> cmp;
    private javax.swing.JComboBox<String> cms;
    private javax.swing.JRadioButton cour;
    private javax.swing.JTextField email;
    private javax.swing.JSpinner grp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField p_r;
    private javax.swing.JPanel pan;
    private javax.swing.JPanel pan1;
    private javax.swing.JTextField prenom;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JRadioButton td;
    private javax.swing.JRadioButton tp;
    // End of variables declaration//GEN-END:variables

    private void load_prof(String nom) {
        if (nom.equals("")) prl=pr.getproflist("", "",0);
        else prl  =pr.getproflist(nom, "",1);
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        cme.removeAllItems();
        for(int i = 0; i < prl.size(); i++)
        {
            row[0] = prl.get(i).nom;
            row[1] = prl.get(i).prenom;
            row[2] = prl.get(i).email;
            model.addRow(row);
            cme.addItem(prl.get(i).nom+" "+prl.get(i).prenom);
        }
    }

    private void load_prf_module() {
        el=e.getenseignlist(id, 0);
        DefaultTableModel model = (DefaultTableModel)table2.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i = 0; i < el.size(); i++)
        {
            row[0] = el.get(i).lib;
            row[1] = el.get(i).nom_m;
            row[2] = el.get(i).nom_t;
            row[3] = el.get(i).grp;
            model.addRow(row);
        }
    }
    private void load_module(String s,int r) {
        m = md.getmodulelist(s,r); 
        cmb.removeAllItems();
        for(int i = 0; i < m.size(); i++)
        {
            cmb.addItem(m.get(i).lib+" "+m.get(i).nom);
        }
    }

    private void load_promos() {
        cmp.removeAllItems();
        for(int i = 0; i < pl.size(); i++)
        {
            cmp.addItem(pl.get(i).nom);
        }
    }

    private void load_resp() {
        rl=r.getresponsablelist(0,0);
        DefaultTableModel model = (DefaultTableModel)table3.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for(int i = 0; i < rl.size(); i++)
        {
            row[0] = rl.get(i).nom_e;
            row[1] = rl.get(i).nom_p;
            row[2] = rl.get(i).nom_s;
            model.addRow(row);
        }
    }
}