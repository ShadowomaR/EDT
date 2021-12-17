
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import static javax.swing.text.StyleConstants.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
public class imprimer {
   
    private jour j=new jour();
    private heur h=new heur();
    private ArrayList<jour> jl=j.getjourlist("");
    private ArrayList<heur> hl=h.getheurlist("");
    private com.itextpdf.text.Font f1 = FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.BOLD,BaseColor.BLACK);
    private com.itextpdf.text.Font f2 = FontFactory.getFont(FontFactory.TIMES_BOLD,6,0,BaseColor.BLACK);
    private com.itextpdf.text.Font f3 = FontFactory.getFont(FontFactory.TIMES_BOLD,10,Font.BOLD,BaseColor.BLACK);
    private Chunk chunk;
    /*public static void main(String[] args) {
        imprimer im=new imprimer();
    }*/
    public imprimer(){
        try {
            Image logo = Image.getInstance("src/images/dep.png");
            logo.setAlignment(Image.MIDDLE);
            chunk = new Chunk(logo, 0, -45); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }          
    }
    public void afficher(){
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        String path=home.getAbsolutePath();
        path=path+"\\EDT.pdf";
        Document doc=new Document();
        try {
           PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            doc.addTitle("EDT");              
            doc.add(chunk);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            Paragraph p = new Paragraph("Faculté des Sciences – Tidjani Haddam \n Département d’informatique", FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.BOLD,BaseColor.BLACK));
            p.setAlignment(ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            //   table
            PdfPTable t=new PdfPTable(6);
            t.setWidthPercentage(100);
            int[] m={5,19,19,19,19,19};
            t.setWidths(m);
            //premiere line
            PdfPCell c=new PdfPCell(new Paragraph(" "));
            t.addCell(c);
            for(int i=0;i<jl.size();i++) {
                c=new PdfPCell(new Paragraph(jl.get(i).nom));
                c.setColspan(1);
                c.setRowspan(1);
                c.setHorizontalAlignment(ALIGN_CENTER);
                c.setVerticalAlignment(ALIGN_CENTER);
                t.addCell(c);
            }
            // les séances
            for(int i=0;i<hl.size();i++) {
                c=new PdfPCell(new Paragraph(hl.get(i).nom));
                c.setColspan(1);
                c.setRowspan(1);
                c.setHorizontalAlignment(ALIGN_CENTER);
                c.setVerticalAlignment(ALIGN_CENTER);
                c.setRotation(-90);
                t.addCell(c);
                for(int j=0;j<jl.size();j++) {
                    c=new PdfPCell(new Paragraph(" "));
                    c.setColspan(1);
                    c.setRowspan(1);
                    c.setHorizontalAlignment(ALIGN_CENTER);
                    c.setVerticalAlignment(ALIGN_CENTER);
                    t.addCell(c);
                }
            }
            doc.add(t);
            // liste des modules
            com.itextpdf.text.List l=new com.itextpdf.text.List();
            l.add(" ");
            doc.add(l);
            doc.close();
            Desktop desk = Desktop.getDesktop();
            desk.open(new File(path));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
    }

    public void afficher2(ArrayList<emploi> e,int code_p,int code_s,String nom) {
        enseign es=new enseign();
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        String path=home.getAbsolutePath();
        path=path+"\\EDT-"+nom+".pdf";
        String s;
        Document doc=new Document();
        try {
           PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            doc.addTitle("EDT "+nom);                            
            doc.add(chunk);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            Paragraph p = new Paragraph("Faculté des Sciences – Tidjani Haddam \n Département d’informatique", f1);
            p.setAlignment(ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            s=nom;
            if(code_s==0) s=s+" - Semestre 1 -";
            else s=s+" - Semestre 2 -";
            p=new Paragraph(s, f1);
            p.setAlignment(ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            //   table
            PdfPTable t=new PdfPTable(6);
            t.setWidthPercentage(100);
            int[] m={5,19,19,19,19,19};
            t.setWidths(m);
            //premiere line
            PdfPCell c=new PdfPCell(new Paragraph(" "));
            t.addCell(c);
            for(int i=0;i<hl.size();i++) {
                c=new PdfPCell(new Paragraph(hl.get(i).nom));
                c.setColspan(1);
                c.setRowspan(1);
                c.setHorizontalAlignment(ALIGN_CENTER);
                c.setVerticalAlignment(ALIGN_CENTER);
                t.addCell(c);
            }
            // les séances
            for(int i=0;i<jl.size();i++) {
                c=new PdfPCell(new Paragraph(jl.get(i).nom));
                c.setColspan(1);
                c.setRowspan(1);
                c.setHorizontalAlignment(ALIGN_CENTER);
                c.setVerticalAlignment(ALIGN_CENTER);
                c.setRotation(-90);
                t.addCell(c);
                for(int j=0;j<hl.size();j++) {
                    s="";
                    int k=0;
                    for(int n=0;n<e.size();n++){
                        if(e.get(n).j==jl.get(i).code && e.get(n).h==hl.get(j).code){
                            if(e.get(n).t==1) {
                                k=1;
                                s=s+e.get(n).lib+" "+e.get(n).nom_t;
                                if(e.get(n).salle!=0) s=s+e.get(n).nom_sl;
                                s=s+" "+es.getenseignant(e.get(n).m, e.get(n).t, e.get(n).grp);
                            }else{
                                s=s+"G:"+e.get(n).grp+" "+e.get(n).lib+" "+e.get(n).nom_t;
                                if(e.get(n).salle!=0) s=s+" "+e.get(n).nom_sl;
                                s=s+" "+es.getenseignant(e.get(n).m, e.get(n).t, e.get(n).grp);
                                s=s+"\n";
                            }
                        }
                    }
                    
                    c=new PdfPCell(new Paragraph(s, f2));
                    c.setColspan(1);
                    c.setRowspan(1);
                    if(k==1) c.setHorizontalAlignment(ALIGN_CENTER);
                    else c.setHorizontalAlignment(ALIGN_LEFT);
                    c.setVerticalAlignment(ALIGN_CENTER);
                    t.addCell(c);
                }
            }
            doc.add(t);
            doc.add(new Paragraph(" "));
            // responsable
            responsable rs=new responsable();
            s="Le président de l’équipe pédagogique est :"+rs.getresponsablelist(code_p, code_s).get(0).nom_e; 
            doc.add(new Paragraph(s,f3));
            doc.add(new Paragraph(" "));
            // liste des modules
            com.itextpdf.text.List l=new com.itextpdf.text.List();
            contien cn=new contien();
            ArrayList<contien> cl = cn.getmcontienlist(code_p, 0,code_s);
            for(int i=0;i<cl.size();i++){
                s=cl.get(i).lib+" : "+cl.get(i).nom+" "+cl.get(i).nom_t+" :";
                if(cl.get(i).cour!=0) s=s+" "+cl.get(i).cour+" cours";
                if(cl.get(i).td!=0) s=s+" "+cl.get(i).td+" TD";
                if(cl.get(i).tp!=0) s=s+" "+cl.get(i).tp+" TP";
                
                l.add(s);
            }            
            doc.add(l);
            doc.close();
            Desktop desk = Desktop.getDesktop();
            desk.open(new File(path));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
    }

    public void afficher1(session ss) {
        enseign es=new enseign();
        emploi em=new emploi();
        ArrayList<emploi> e=new ArrayList<>();
        
        promo pp=new promo();
        ArrayList<promo> pl=pp.getpromolist("");
        
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        String path=home.getAbsolutePath();
        path=path+"\\EDT-"+ss.desc+".pdf";
        String s;
        Document doc=new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            doc.addTitle("EDT "+ss.desc);
            
            for(promo pr :pl){
                e=em.getemploilist(pr.code, ss.code);
                System.out.println(e.size());
                doc.add(chunk);
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                Paragraph p = new Paragraph("Faculté des Sciences – Tidjani Haddam \n Département d’informatique", f1);
                p.setAlignment(ALIGN_CENTER);
                doc.add(p);
                doc.add(new Paragraph(" "));
                s=ss.desc;
                if(ss.sem==1) s=s+" - Semestre 1 -";
                else s=s+" - Semestre 2 -";
                p=new Paragraph(s, f1);
                p.setAlignment(ALIGN_CENTER);
                doc.add(p);
                doc.add(new Paragraph(" "));
                //   table
                PdfPTable t=new PdfPTable(6);
                t.setWidthPercentage(100);
                int[] m={5,19,19,19,19,19};
                t.setWidths(m);
                //premiere line
                PdfPCell c=new PdfPCell(new Paragraph(" "));
                t.addCell(c);
                for(int i=0;i<hl.size();i++) {
                    c=new PdfPCell(new Paragraph(hl.get(i).nom));
                    c.setColspan(1);
                    c.setRowspan(1);
                    c.setHorizontalAlignment(ALIGN_CENTER);
                    c.setVerticalAlignment(ALIGN_CENTER);
                    t.addCell(c);
                }
                // les séances
                for(int i=0;i<jl.size();i++) {
                    c=new PdfPCell(new Paragraph(jl.get(i).nom));
                    c.setColspan(1);
                    c.setRowspan(1);
                    c.setHorizontalAlignment(ALIGN_CENTER);
                    c.setVerticalAlignment(ALIGN_CENTER);
                    c.setRotation(-90);
                    t.addCell(c);
                    for(int j=0;j<hl.size();j++) {
                        s="";
                        int k=0;
                        for(int n=0;n<e.size();n++){
                            if(e.get(n).j==jl.get(i).code && e.get(n).h==hl.get(j).code){
                                if(e.get(n).t==1) {
                                    k=1;
                                    s=s+e.get(n).lib+" "+e.get(n).nom_t;
                                    if(e.get(n).salle!=0) s=s+e.get(n).nom_sl;
                                    s=s+" "+es.getenseignant(e.get(n).m, e.get(n).t, e.get(n).grp);
                                }else{
                                    s=s+"G:"+e.get(n).grp+" "+e.get(n).lib+" "+e.get(n).nom_t;
                                    if(e.get(n).salle!=0) s=s+" "+e.get(n).nom_sl;
                                    s=s+" "+es.getenseignant(e.get(n).m, e.get(n).t, e.get(n).grp);
                                    s=s+"\n";
                                }
                            }
                        }

                        c=new PdfPCell(new Paragraph(s, f2));
                        c.setColspan(1);
                        c.setRowspan(1);
                        if(k==1) c.setHorizontalAlignment(ALIGN_CENTER);
                        else c.setHorizontalAlignment(ALIGN_LEFT);
                        c.setVerticalAlignment(ALIGN_CENTER);
                        t.addCell(c);
                    }
                }
                doc.add(t);
                doc.add(new Paragraph(" "));
                // responsable
                responsable rs=new responsable();
                s="Le président de l’équipe pédagogique est :"+rs.getresponsablelist(pr.code, ss.sem).get(0).nom_e; 
                doc.add(new Paragraph(s,f3));
                doc.add(new Paragraph(" "));
                // liste des modules
                com.itextpdf.text.List l=new com.itextpdf.text.List();
                contien cn=new contien();
                ArrayList<contien> cl = cn.getmcontienlist(pr.code,0, ss.sem);
                for(int i=0;i<cl.size();i++){
                    s=cl.get(i).lib+" : "+cl.get(i).nom+" "+cl.get(i).nom_t+" :";
                    if(cl.get(i).cour!=0) s=s+" "+cl.get(i).cour+" cours";
                    if(cl.get(i).td!=0) s=s+" "+cl.get(i).td+" TD";
                    if(cl.get(i).tp!=0) s=s+" "+cl.get(i).tp+" TP";

                    l.add(s);
                }            
                doc.add(l);
                
                doc.newPage();
            }            
            
            doc.close();
            Desktop desk = Desktop.getDesktop();
            desk.open(new File(path));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        
    }

    
   
}
