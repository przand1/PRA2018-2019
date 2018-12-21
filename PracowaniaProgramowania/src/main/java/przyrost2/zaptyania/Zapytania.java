package przyrost2.zaptyania;

import przyrost2.tabele.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Zapytania {

    //1.Oblicz cenę biletu
    //  input: 2 stacje, klasa, pociąg
    //  zakładamy, że klient wybrał istniejące połączenie i dane są poprawne
    public static float oblCene(String stacja1Name, String stacja2Name, int klasa, int pociag, EntityManager manager) {

        manager.getTransaction().begin();

        Przewoznik przewoznik = manager.createQuery("select p.przewoznik from Pociag p where p.id = "+pociag,Przewoznik.class).getSingleResult();

        Cennik cennik = manager.createQuery("select q.cennik from Przewoznik q where q.id=" + przewoznik.getId(), Cennik.class).getSingleResult();

        float stawka;
        float km = 0;
        if (klasa==1)
            stawka = cennik.getStawkaZaKmKl1();
        else
            stawka = cennik.getStawkaZaKmKl2();

        Trasa trasa = manager.createQuery("select t from Trasa t where t.pociag.id=" + pociag, Trasa.class).getSingleResult();
        float wynik = 0f;

        //Wszystkie połączenia wychodzące ze stacji początkowej
        List<OdcinekTrasy> kandydaci = manager.createQuery("select o from OdcinekTrasy o where o.stacja1.nazwa like \'" + stacja1Name + "\'", OdcinekTrasy.class).getResultList();

        while (!kandydaci.isEmpty()) {
            //Jedno z leży na danej trasie
            out:
            for (OdcinekTrasy oK : kandydaci) {
                for (OdcinekTrasy oT : trasa.getPrzebiegTrasy()) {
                    if (oK.equals(oT)) {
                        wynik += oK.getDlugosc();
                        if (oK.getStacja2().getNazwa().equals(stacja2Name))
                            return wynik * stawka;
                        else {
                            stacja1Name = oK.getStacja2().getNazwa();
                            break out;
                        }
                    }
                }
            }
            kandydaci = manager.createQuery("select o from OdcinekTrasy o where o.stacja1.nazwa like \'" + stacja1Name + "\'", OdcinekTrasy.class).getResultList();
        }

        manager.getTransaction().commit();

        return 0;
    }

    //2.Wyświetl rozkład jazdy
    //input: stacja, zakres czsowy
    public static void rozklad(String nazwaStacji, ZonedDateTime czasOd, ZonedDateTime czasDo, EntityManager manager) {
        List<Postoj> postoje = manager.createQuery("select p from Postoj p where p.stacja.nazwa like\'" + nazwaStacji + "\'", Postoj.class).getResultList();
        postoje.forEach(postoj -> System.out.println(postoj.getId()));
    }

    //3.Wyszukaj połączenie

    //4.W jakim mieście jest największa stacja

    //5.Kurde nie wiem

    public static void main(String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager manager = factory.createEntityManager();
        try {
//            System.out.printf( "Cena biletu: %.2f\n",oblCene("Demowo", "Inne Miasto Główny", 2, 203, manager) );
            rozklad("Inne Miasto Główny", ZonedDateTime.of(2017, 12, 14, 14, 18, 0, 0, ZoneId.of("UTC+1")), ZonedDateTime.of(2019, 12, 14, 14, 18, 0, 0, ZoneId.of("UTC+1")), manager);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            factory.close();
        }
    }
}
