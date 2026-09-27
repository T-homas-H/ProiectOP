import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        int optiune;
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        List<Elev> totiElevii = new ArrayList<>();
        List<Sala> toateSalile = new ArrayList<>();

        do{
            System.out.println("Alegeti o optiune : 1 - Adauga elev, 2 - Creeaza sala, 3 - Adauga elev intr o sala, 4 - Afisaza toti elevii,\n                    5 - Afisaza toate salile, 6 - Afiseaza elevii unei sali, 7 - Cauta elev dupa ID,\n                    8 - Muta elev dintr o sala in alta, 9 - Sterge elev, 10 - Sterge sala,\n                    11 - Filtreaza elevii promovati, 12 - Filtreaza elevii nepromovati,\n                    13 - Filtreaza elevii dupa interval medie, 14 - Filtreaza elevii dupa varsta,\n                    15 - Cauta elev dupa nume, 16 - Afiseaza statistici, 17 - Sorteaza elevii,\n                    0 - Inchide aplicatia");
            optiune = scn.nextInt();
            switch(optiune){
                case 1:
                    Elev elev = new Elev();
                    System.out.println("Nume:");
                    elev.setNume(scn.next());
                    System.out.println("Varsta:");
                    elev.setVarsta(scn.nextInt());
                    System.out.println("Medie:");
                    elev.setMedie(scn.nextDouble());
                    totiElevii.add(elev);
                    break;
                case 2:
                    Sala sala = new Sala();
                    System.out.println("Denumire:");
                    sala.setDenumire(scn.next());
                    System.out.println("Capacitate");
                    sala.setCapacitate(scn.nextInt());
                    toateSalile.add(sala);
                    break;
                case 3:
                    System.out.println("Introduceti id elev:");
                    int adaugareElev = scn.nextInt();
                    System.out.println("Introduceti id sala destinatie:");
                    int destinatieSala = scn.nextInt();

                    Elev elevGasit = null;
                    for (Elev e : totiElevii) {
                        if (e.getId() == adaugareElev) {
                            elevGasit = e;
                            break;
                        }
                    }

                    Sala salaGasita = null;
                    for (Sala s : toateSalile) {
                        if (s.getIdSala() == destinatieSala) {
                            salaGasita = s;
                            break;
                        }
                    }

                    if (elevGasit == null) {
                        System.out.println("Elevul cu Id ul respectiv nu exista !!");
                    } else if (salaGasita == null) {
                        System.out.println("Sala cu Id ul respectiv nu exista !!");
                    } else if (salaGasita.getListaElevi().size() >= salaGasita.getCapacitate()) {
                        System.out.println("Sala e plina, nu mai pot fi adaugati elevi.");
                    } else {
                        salaGasita.getListaElevi().add(elevGasit);
                        System.out.println("Elevul " + elevGasit.getNume() + " a fost adaugat cu succes in sala " + salaGasita.getDenumire());
                    }
                    break;
                case 4:
                    if (totiElevii.isEmpty()) {
                        System.out.println("Nu exista niciun elev inregistrat!");
                    } else {
                        for (Elev e : totiElevii) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 5:
                    if (toateSalile.isEmpty()) {
                        System.out.println("Nu exista nicio sala creata!");
                    } else {
                        for (Sala s : toateSalile) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Introduceti id ul pentru sala din care vreti sa afisati elevii:");
                    int idSalaCautata = scn.nextInt();

                    salaGasita = null;
                    for (Sala s : toateSalile) {
                        if (s.getIdSala() == idSalaCautata) {
                            salaGasita = s;
                            break;
                        }
                    }

                    if (salaGasita == null) {
                        System.out.println("Sala nu exista !!");
                    } else if (salaGasita.getListaElevi().isEmpty()) {
                        System.out.println("Sala nu are elevi in ea !!");
                    } else {
                        for (Elev e : salaGasita.getListaElevi()) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Introduceti id pentru cautare elev:");
                    int idCautare = scn.nextInt();

                    elevGasit = null;
                    for(Elev e : totiElevii){
                        if(e.getId() == idCautare){
                            elevGasit = e;
                            break;
                        }
                    }

                    if(elevGasit == null){
                        System.out.println("Elevul nu exista !!");
                    }
                    else{
                        System.out.println(elevGasit);
                    }
                    break;
                case 8:
                    System.out.println("Introduceti id pentru sala initiala:");
                    int salaInitiala = scn.nextInt();
                    System.out.println("Introduceti id pentru sala destinatie:");
                    int salaDestinatie = scn.nextInt();
                    System.out.println("Introduceti id ul elevului pe care doriti sa il mutati din sala initiala in sala destinatie:");
                    int idElev = scn.nextInt();

                    salaGasita = null;
                    Sala salaGasita2 = null;
                    elevGasit = null;

                    for(Elev e: totiElevii){
                        if(e.getId() == idElev){
                            elevGasit = e;
                            break;
                        }
                    }

                    for(Sala s: toateSalile){
                        if(s.getIdSala() == salaInitiala){
                            salaGasita = s;
                            break;
                        }
                    }

                    for(Sala s: toateSalile){
                        if(s.getIdSala() == salaDestinatie){
                            salaGasita2 = s;
                            break;
                        }
                    }

                    if(elevGasit == null){
                        System.out.println("Elevul cu id ul respectiv nu exista !!");
                    }
                    else if(salaGasita == null){
                        System.out.println("Sala initiala cu id ul respectiv nu exista !!");
                    }
                    else if(salaGasita2 == null){
                        System.out.println("Sala destinatie cu id ul respectiv nu exista !!");
                    }
                    else if(salaGasita2.getListaElevi().size() >= salaGasita2.getCapacitate()){
                        System.out.println("Sala destinatie e plina nu mai pot fi adaugati elevi !!");
                    }
                    else if (!salaGasita.getListaElevi().contains(elevGasit)) {
                        System.out.println("Elevul nu se este in sala initiala !!");
                    }
                    else{
                        salaGasita2.getListaElevi().add(elevGasit);
                        salaGasita.getListaElevi().remove(elevGasit);
                        System.out.println("Elevul " + elevGasit.getNume() + " a fost adaugat cu succes in sala noua !!");
                    }
                    break;
                case 9:
                    System.out.println("Introduceti id pentru elevul pe care doriti sa il stergeti:");
                    int elevSters = scn.nextInt();
                    elevGasit = null;

                    for (Elev e : totiElevii) {
                        if (e.getId() == elevSters) {
                            elevGasit = e;
                            break;
                        }
                    }

                    if (elevGasit == null) {
                        System.out.println("Elevul nu exista !!");
                    } else {
                        totiElevii.remove(elevGasit);

                        for (Sala s : toateSalile) {
                            s.getListaElevi().remove(elevGasit);
                        }

                        Elev.getListaId().remove((Integer) elevSters);
                        System.out.println("Elevul a fost sters cu succes !!");
                    }
                    break;
                case 10:
                    System.out.println("Introduceti id pentru sala pe care doriti sa o stergeti:");
                    int idSalaSters = scn.nextInt();

                    salaGasita = null;

                    for (Sala s : toateSalile) {
                        if (s.getIdSala() == idSalaSters) {
                            salaGasita = s;
                            break;
                        }
                    }

                    if (salaGasita == null) {
                        System.out.println("Sala nu exista!");
                    } else {
                        toateSalile.remove(salaGasita);
                        Sala.getListaId().remove((Integer) idSalaSters);
                        System.out.println("Sala a fost stearsa cu succes!");
                    }
                    break;
                case 11:
                    System.out.println("Elevii promovati sunt:");
                    for(Elev e: totiElevii){
                        if(e.getPromovat() == true){
                            System.out.println(e);
                        }
                    }
                    break;
                case 12:
                    System.out.println("Elevii nepromovati sunt:");
                    for(Elev e: totiElevii){
                        if(e.getPromovat() == false){
                            System.out.println(e);
                        }
                    }
                    break;
                case 13:
                    System.out.println("Minim:");
                    double minim = scn.nextDouble();
                    System.out.println("Maxim:");
                    double maxim = scn.nextDouble();
                    System.out.println("Elevii cu media apartinand intervalului sunt:");
                    for(Elev e: totiElevii){
                        if(e.getMedie() >= minim && e.getMedie() <= maxim){
                            System.out.println(e);
                        }
                    }
                    break;
                case 14:
                    System.out.println("Introduceti o varsta pentru a filtra elevii:");
                    int age = scn.nextInt();

                    System.out.println("Elevii cu varsta de " + age + " sunt:");
                    for(Elev e: totiElevii){
                        if(e.getVarsta() == age){
                            System.out.println(e);
                        }
                    }
                    break;
                case 15:
                    System.out.println("Introduceti nume pentru a cauta elev:");
                    String nume = scn.next();

                    System.out.println("Elevul/Elevii cu numele '" + nume + "' sunt :");
                    for(Elev e: totiElevii){
                        if(e.getNume().equals(nume)){
                            System.out.println(e);
                        }
                    }
                    break;
                case 16:
                    if (totiElevii.isEmpty()) {
                        System.out.println("Nu exista elevi inregistrati pentru a genera statistici !!");
                    } else {
                        int totalElevi = totiElevii.size();
                        int numarPromovati = 0;
                        double sumaMedii = 0;

                        for (Elev e : totiElevii) {
                            sumaMedii += e.getMedie();
                            if (e.getPromovat()) {
                                numarPromovati++;
                            }
                        }

                        double mediaGenerala = sumaMedii / totalElevi;
                        int numarNepromovati = totalElevi - numarPromovati;

                        int totalSali = toateSalile.size();
                        int locuriTotale = 0;
                        int locuriOcupate = 0;

                        for (Sala s : toateSalile) {
                            locuriTotale += s.getCapacitate();
                            locuriOcupate += s.getListaElevi().size();
                        }

                        System.out.println("Statisticile sunt:");
                        System.out.println("Numar total elevi: " + totalElevi);
                        System.out.println("Media generala a elevilor: " + mediaGenerala);
                        System.out.println("Elevi promovati: " + numarPromovati);
                        System.out.println("Elevi nepromovati: " + numarNepromovati);
                        System.out.println("Numar total sali: " + totalSali);
                        System.out.println("Capacitate totala sali: " + locuriOcupate + "/" + locuriTotale + " locuri ocupate");
                    }
                    break;
                case 17:
                    if (totiElevii.isEmpty()) {
                        System.out.println("Nu exista elevi inregistrati pentru a fi sortati!");
                    } else {
                        totiElevii.sort((e1, e2) -> Double.compare(e2.getMedie(), e1.getMedie()));

                        System.out.println("Elevii sortati descrescator dupa medie:");
                        for (Elev e : totiElevii) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiunea trebuie sa fiu una dinte cele de mai sus !! REINCEARCA !!");
                    break;
            }
        }while(optiune != 0);
    }
}