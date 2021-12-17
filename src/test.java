
import java.util.ArrayList;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHADOW
 */
public class test {
    public static void main(String[] args) {
        new test2();
    }
    private static class test2 {
        ArrayList<ArrayList> e  =new ArrayList<>();
        public test2() {
            sol5();
        }
        
        public void afficher(ArrayList<emploi> e){
            promo p=new promo();
            ArrayList<promo> pl = p.getpromolist("");
            for(promo pr :pl){
                pr.element(e,0);
            }
        }
        private ArrayList<Integer[]> load_heur() {
            ArrayList<Integer[]> date = new ArrayList<>();
            // Heurs
            heur h=new heur();
            ArrayList<heur> heurList  =h.getheurlist("");
            jour jr=new jour();
            ArrayList<jour> jourList  =jr.getjourlist("");
            
            for(int i=0;i<jourList.size();i++){
                for(int j=0;j<heurList.size();j++){
                    date.add(new Integer[] {jourList.get(i).code,heurList.get(j).code});
                }
            } 
            return date;
        }        

        private ArrayList<Integer> getindexs(ArrayList<Integer> codemodule, ArrayList<Newtype2> modulelist) {
            ArrayList<Integer> indexs = new ArrayList<>();
            for(int i=0;i<modulelist.size();i++){
                for(int j=0;j<codemodule.size();j++){
                    if(modulelist.get(i).m==codemodule.get(j)) indexs.add(i);
                }
            }
            return indexs;
        }
        
        private void sol5() {
                        
            Model model = new Model("EDT");
            
            ArrayList<Newtype2> modulelist=new ArrayList<>();
            promo pr=new promo();
            contien cn=new contien();
            ArrayList<contien> cl=new ArrayList<>();
            ArrayList<promo> promolist = pr.getpromolist("");
            
            //charger les variables
            for(promo p:pr.getpromolist("")){
                cl = cn.getmcontienlist(p.code, 0,0);
                for(int i=0;i<cl.size();i++){
                    modulelist=module_type(modulelist,cl.get(i));
                }
            }
            //charger les domaine
            ArrayList<Integer[]> date=new ArrayList<>();            
            date=load_heur();
            IntVar[] m =new IntVar[modulelist.size()];
            for(int i=0;i<modulelist.size();i++){
                m[i]= model.intVar("date:"+i, 1,date.size()); 
            }
            
            Solver solver = model.getSolver();
            ArrayList<emploi> e =new ArrayList<>(); 
            
            //contraint module
            int i,j;  
            for(promo p: promolist){ 
                cl = cn.getmcontienlist(p.code, 0,0);
                ArrayList<Integer> codemodule=new ArrayList<>(),index=new ArrayList<>();
                for(i=0;i<cl.size();i++){
                    codemodule.add(cl.get(i).code_m);
                }
                index=getindexs(codemodule,modulelist);
                for(i=0;i<index.size();i++){
                    for(j=0;j<index.size();j++){
                        if(i!=j) {
                            model.arithm(m[index.get(i)], "!=", m[index.get(j)]).post();
                            //System.out.print("code:"+cl.get(i).code_m+" index:"+getindex(cl.get(i).code_m,a)+" code:"+cl.get(i).code_m+" index:"+getindex(cl.get(j).code_m,a)+"\n");
                        }
                    }
                }                
            }            
            
            Solution s=solver.findSolution();
            
            for(i=0;i<modulelist.size();i++){
                e.add(new emploi(modulelist.get(i).m,date.get(s.getIntVal(m[i]))[0] ,date.get(s.getIntVal(m[i]))[1],modulelist.get(i).type,modulelist.get(i).grp));
            }                   
               
            afficher(e);
        }

        private ArrayList<Newtype2> module_type(ArrayList<Newtype2> modulelist, contien c) {
            int i;
            for(i=0;i<c.cour;i++){
                modulelist.add(new Newtype2(c.code_m,1,modulelist.size()));
            }
            for(i=0;i<c.tp;i++){
                modulelist.add(new Newtype2(c.code_m,2,modulelist.size()));
            }
            for(i=0;i<c.td;i++){
                modulelist.add(new Newtype2(c.code_m,3,modulelist.size()));
            }
            
            return modulelist;
        }
        
        }
    
}
