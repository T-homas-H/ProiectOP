import java.util.ArrayList;
import java.util.List;

public class Elev {
    private int id;
    private String nume;
    private int varsta;
    private double medie;
    private static List<Integer> lista = new ArrayList<>();
    private boolean promovat = false;
    private static int sequence = 0;


    public Elev(){
        sequence++;
        this.id = sequence;
        lista.add(id);
        this.nume = null;
        this.varsta = 0;
        this.medie = 0;
    }

    public Elev(String nume){
        sequence++;
        lista.add(id);
        this.id = sequence;
        this.nume = nume;
    }

    public Elev(int varsta, int medie){
        sequence++;
        lista.add(id);
        this.id = sequence;
        this.varsta = varsta;
        this.medie = medie;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        if(id < 0 || lista.contains(id)){
            System.out.println("Id ul trebuie sa fie pozitiv si unique !!");
        }
        else{
            if(this.id != 0) {
                lista.remove((Integer)this.id);
            }
            this.id = id;
            lista.add(id);
        }
    }

    public String getNume(){
        return nume;
    }

    public void setNume(String nume){
        if(nume == null || nume.isEmpty()){
            System.out.println("Numele nu are voie sa fie null sau gol !!");
        }
        else{
            this.nume = nume;
        }
    }

    public int getVarsta(){
        return varsta;
    }

    public void setVarsta(int varsta){
        if(varsta < 8 || varsta > 19){
            System.out.println("Varsta nu e corespunzatoare pentru un elev !!");
        }
        else{
            this.varsta = varsta;
        }
    }

    public double getMedie(){
        return medie;
    }

    public void setMedie(double medie){
        if(medie < 1 || medie > 10){
            System.out.println("Media trebuia sa fie intre 1 - 10 !!");
        }
        else{
            this.medie = medie;
            if(this.medie >= 5){
                this.promovat = true;
            }
            else{
                this.promovat = false;
            }
        }
    }

    public static boolean existaId(int id){
        if(lista.contains(id)){
            return true;
        }
        else{
            return false;
        }
    }

    public static List<Integer> getListaId(){
        return lista;
    }

    public boolean getPromovat(){
        return promovat;
    }

    @Override
    public String toString() {
        return "Elev{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", medie=" + medie +
                ", promovat=" + promovat +
                '}';
    }

}
