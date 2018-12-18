package przyrost2.zaptyania;

import przyrost2.tabele.Cennik;
import przyrost2.tabele.Pociag;
import przyrost2.tabele.Przewoznik;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Zapytania {

    //1.Oblicz cenę biletu
    //  input: 2 stacje, klasa, pociąg
    //  zakładamy, że klient wybrał istniejące połączenie i dane są poprawne
    public static void oblCene(String stacja1, String stacja2, int klasa, int pociag, EntityManager manager) {
        manager.getTransaction().begin();
        System.out.println(pociag);
        Przewoznik przewoznik = manager.createQuery("select p.przewoznik from Pociag p where p.id = "+pociag,Przewoznik.class).getSingleResult();
        int przewoznikID = przewoznik.getId();
        System.out.println("PrzewoznikID: "+przewoznikID);
        Cennik cennik = manager.createQuery("select cennik from Przewoznik where id="+przewoznikID,Cennik.class).getSingleResult();
        float stawka;
        if (klasa==1)
            stawka = cennik.getStawkaZaKmKl1();
        else
            stawka = cennik.getStawkaZaKmKl2();
        System.out.println("Stawka: "+stawka);
        manager.getTransaction().commit();
    }
    //2.Wyświtl rozkład jazdy

    //3.Wyszukaj połączenie

    //4.W jakim mieście jest największa stacja

    //5.Kurde nie wiem

    public static void main(String args[]) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager manager = factory.createEntityManager();
        try {
            oblCene("asd","sdf",2,202,manager);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            factory.close();
        }
    }
}
