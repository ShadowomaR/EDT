
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
public class Genere_EDT {
        private ArrayList<Integer[]> tplist=new ArrayList<>();
        private ArrayList<Integer> dat_e=new ArrayList<>();
        public Genere_EDT() {}
        
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

        public ArrayList<ArrayList<emploi>> getsolution2(int sem) {
           
            ArrayList<Newtype2> modulelist=new ArrayList<>();
            //definir le model
            Model model = new Model("EDT");
            //charger les modules
            promo pr=new promo();
            ArrayList<promo> pl = pr.getpromolist("");
            contien cn=new contien();
            for(int i=0;i<pl.size();i++){
                modulelist=load_module(modulelist,cn.getmcontienlist(pl.get(i).code, 0,sem),pl.get(i).nbr);     
            }
            //charger le creneau
            ArrayList<Integer[]> date=new ArrayList<>();            
            date=load_heur();
            //charger les variables
            IntVar[] m =new IntVar[modulelist.size()];
            for(int i=0;i<modulelist.size();i++){
                m[i]= model.intVar("date:"+i, 0,date.size()-1); 
            }
            //contraint seance unique
            for(int i=0;i<pl.size();i++){
                ArrayList<contien> cl = cn.getmcontienlist(pl.get(i).code, 0,sem);
                ArrayList<Integer> cour=load_indexe(cl,modulelist,1,0);
                ArrayList<Integer> td=load_indexe(cl,modulelist,3,0);
                ArrayList<Integer> tp=load_indexe(cl,modulelist,2,0);
                //cours different des autre cours et tp et td
                for(int j=0;j<cour.size();j++){                    
                    for(int k=0;k<cour.size();k++){
                        if(k!=j) model.arithm(m[cour.get(j)], "!=", m[cour.get(k)]).post();
                    }
                    for(int k=0;k<td.size();k++){
                        model.arithm(m[cour.get(j)], "!=", m[td.get(k)]).post();
                    }
                    for(int k=0;k<tp.size();k++){
                        model.arithm(m[cour.get(j)], "!=", m[tp.get(k)]).post();
                    }
                }
                //tp et td de chaque grp son different
                
                for(int j=1;j<=pl.get(i).nbr;j++){
                    td.clear();
                    td=load_indexe(cl,modulelist,1,j);
                    for(int k=0;k<td.size();k++){
                        for(int l=0;l<td.size();l++){
                            if(k!=l) {
                                model.arithm(m[td.get(k)], "!=", m[td.get(l)]).post();
                                //System.out.println(m[td.get(l)]+"!="+m[td.get(k)]);
                            }
                        }
                    }
                }
                          
            }
            //Contrainte tp
            
            for(int i=0;i<tplist.size();i++){
                model.arithm(m[tplist.get(i)[1]], "=",m[tplist.get(i)[0]],"+",1).post();                    
                    model.arithm(m[tplist.get(i)[0]],"!=", 4).post();
                    model.arithm(m[tplist.get(i)[0]],"!=", 9).post();
                    model.arithm(m[tplist.get(i)[0]],"!=", 14).post();
                    model.arithm(m[tplist.get(i)[0]],"!=", 19).post();
                    model.arithm(m[tplist.get(i)[0]],"!=", 24).post();
            }
            
            //Contrainte enseignant
            enseign es=new enseign();
            ArrayList<Integer> prf=es.list(sem);
            ArrayList<enseign> el2=new ArrayList<>();
            for(int i=0;i<prf.size();i++){
                el2=es.getenseignlist(prf.get(i), 0);
                ArrayList<Integer> ind=new ArrayList<>();
                for(int j=0;j<el2.size();j++){
                    for(int k=0;k<modulelist.size();k++){
                        if(modulelist.get(k).m==el2.get(j).code_m &&  modulelist.get(k).type ==el2.get(j).type && modulelist.get(k).grp==el2.get(j).grp) ind.add(modulelist.get(k).index);
                    }
                }  
                for(int j=0;j<ind.size();j++){
                    for(int k=0;k<ind.size();k++){
                        if(j!=k) model.arithm(m[ind.get(j)],"!=", m[ind.get(k)]).post();
                    }
                }                
            }
            

            
            ArrayList<ArrayList<emploi>> e1 =new ArrayList<>();
            ArrayList<emploi> e =new ArrayList<>();
            Solver solver = model.getSolver();
            
            /*
            Solution s=solver.findSolution();
            //System.out.println(s.toString());
           
            System.out.println(solver.getSolutionCount());
            for(int i=0;i<modulelist.size();i++){
                e.add(new emploi(modulelist.get(i).m,date.get(s.getIntVal(m[i]))[0] ,date.get(s.getIntVal(m[i]))[1],modulelist.get(i).type,modulelist.get(i).grp));
            } 
            e1.add(e);
            */
            
            //solution list
            ArrayList<Solution> sols =new ArrayList<>();
            int nbrr=0;
            while (solver.solve() && nbrr<5) {
                sols.add(new Solution(model).record());
                nbrr++;
            }
            for(Solution ss : sols){
                ArrayList<emploi> e2 =new ArrayList<>();
                for(int i=0;i<modulelist.size();i++){
                    e2.add(new emploi(modulelist.get(i).m,date.get(ss.getIntVal(m[i]))[0] ,date.get(ss.getIntVal(m[i]))[1],modulelist.get(i).type,modulelist.get(i).grp));
                }
                e1.add(e2);
            }
            return e1;
            
        }
        private ArrayList<Newtype2> load_module(ArrayList<Newtype2> list,ArrayList<contien> cl, int nbr) {
            
            ArrayList<Integer> index_c=new ArrayList<>();
            for(int j=0;j<cl.size();j++){
                int i;
                for(i=0;i<cl.get(j).cour;i++){
                    list.add(new Newtype2(cl.get(j).code_m,1,list.size(),1));
                }
                for(i=0;i<cl.get(j).tp;i++){
                    for(int k=1;k<=nbr;k++){
                        list.add(new Newtype2(cl.get(j).code_m,2,list.size(),k));
                        list.add(new Newtype2(cl.get(j).code_m,2,list.size(),k));
                        tplist.add(new Integer[] {list.size()-2,list.size()-1});
                        //System.out.println(tplist.get(tplist.size()-1)[0]+" "+tplist.get(tplist.size()-1)[1]);
                    }
                }
                for(i=0;i<cl.get(j).td;i++){
                    for(int k=1;k<=nbr;k++){
                        list.add(new Newtype2(cl.get(j).code_m,3,list.size(),k));
                    }
                }
            }
            return list;
        }

    private ArrayList<Integer> load_indexe(ArrayList<contien> cl, ArrayList<Newtype2> modulelist, int idex,int grp) {
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int j=0;j<cl.size();j++){
            for(int k=0;k<modulelist.size();k++){
                if(grp==0){
                    if (cl.get(j).code_m==modulelist.get(k).m && modulelist.get(k).type==idex) {
                        al.add(modulelist.get(k).index);
                    }
                }else{
                    if (cl.get(j).code_m==modulelist.get(k).m && modulelist.get(k).type!=idex && modulelist.get(k).grp==grp) {
                        al.add(modulelist.get(k).index);
                    }
                }
                
            }
        }
        return al;
    }
}

    
