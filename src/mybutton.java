
import java.util.ArrayList;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
class MyButton extends JButton {
    public final ArrayList<emploi> e;   ;
    public String nom;
    public int code_s,code_p;

    public MyButton(String t,ArrayList<emploi> e,int code_s,int code_p,String nom) {
    super(t);
    this.e= e;
    this.code_p=code_p;
    this.code_s=code_s;
    this.nom=nom;
    }
}