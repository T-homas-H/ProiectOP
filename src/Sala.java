import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int idSala;
    private String denumire;
    private int capacitate;
    private List<Elev> listaElevi = new ArrayList<>();
    private static List<Integer> listaId = new ArrayList<>();
    private static int sequence = 0;

    public Sala(){
        sequence++;
        idSala = sequence;
        listaId.add(this.idSala);
        denumire = "Sala necunoscuta";
        capacitate = 0;
    }

    public Sala(String denumire, int capacitate){
        sequence++;
        this.idSala = sequence;
        listaId.add(this.idSala);
        this.denumire = denumire;
        this.capacitate = capacitate;
    }

    public Sala(int capacitate, List<Elev> listaElevi){
        sequence++;
        this.idSala = sequence;
        listaId.add(this.idSala);
        this.capacitate = capacitate;
        if(listaElevi != null){
            this.listaElevi = listaElevi;
        }
    }

    public int getIdSala(){
        return idSala;
    }

    public void setIdSala(int id){
        if(id <= 0 || listaId.contains(id)){
            System.out.println("Id ul salii trebuie sa fie pozitiv si unique !!");
        }
        else{
            if(this.idSala != 0){
                listaId.remove((Integer)this.idSala);
            }
            this.idSala = id;
            listaId.add(id);
        }
    }

    public String getDenumire(){
        return denumire;
    }

    public void setDenumire(String denumire){
        if(denumire == null || denumire.isEmpty()){
            System.out.println("Denumirea nu are voie sa fie null sau goala !!");
        }
        else{
            this.denumire = denumire;
        }
    }

    public int getCapacitate(){
        return capacitate;
    }

    public void setCapacitate(int capacitate){
        if(capacitate <= 0 || capacitate > 30){
            System.out.println("Capacitatea trebuie sa fie mai mare de 0 !!");
        }
        else{
            this.capacitate = capacitate;
        }
    }

    public List<Elev> getListaElevi(){
        return listaElevi;
    }

    public void setListaElevi(List<Elev> listaNoua){
        if(listaNoua == null || listaNoua.size() > this.capacitate){
            System.out.println("Lista nu poate fi null sau sa depaseasca capacitatea");
        }
        else{
            this.listaElevi = listaNoua;
        }
    }

    public static boolean existaId(int id){
        if(listaId.contains(id)){
            return true;
        }
        else{
            return false;
        }
    }

    public void adaugarenSala(Elev elev){
        if(listaElevi.contains(elev)){
            System.out.println("Elevul exista deja in clasa!!");
        }
        else{
            listaElevi.add(elev);
        }
    }

    public static List<Integer> getListaId(){
        return listaId;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala=" + idSala +
                ", denumire='" + denumire + '\'' +
                ", capacitate=" + capacitate +
                ", elevi=" + listaElevi +
                '}';
    }
}