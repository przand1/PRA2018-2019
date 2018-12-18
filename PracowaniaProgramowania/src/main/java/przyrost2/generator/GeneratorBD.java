package przyrost2.generator;

import przyrost2.tabele.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeneratorBD {

    public static void main(String[] args) {

        EntityManager manager = null;
        EntityManagerFactory entityManagerFactory = null;


        //stwórz stacje
        Stacja amowo = new Stacja("Amowo","Amowo",1);
        Stacja bemowo = new Stacja("Bemowo","Bemowo",1);
        Stacja cemowo = new Stacja("Cemowo Główny","Cemowo",3);
        Stacja demowo = new Stacja("Demowo","Demowo",2);
        Stacja emowo = new Stacja("Emowo","Emowo",2);
        Stacja efowo = new Stacja("Efowo","Efowo",2);
        Stacja gemowo = new Stacja("Gemowo","Gemowo",3);
        Stacja wies = new Stacja("Jakaś Wieś","Jakaś Wieś",2);
        Stacja koniec = new Stacja("Koniec Świata","Koniec Świata",1);
        Stacja dmGlowny = new Stacja("Duże Miasto Główny","Duże Miasto",5);
        Stacja dmPol = new Stacja("Duże Miasto Południe","Duże Miasto",3);
        Stacja dmFab = new Stacja("Duże Miasto Fabryka","Duże Miasto",3);
        Stacja dmPrzed = new Stacja("Duże Miasto Przedmieścia","Duże Miasto",3);
        Stacja imGlowny = new Stacja("Inne Miasto Główny","Inne Miasto ",4);
        Stacja imPln = new Stacja("Inne Miasto Przedmieścia","Inne Miasto ",3);

        //stwórz odcinki
        OdcinekTrasy ab = new OdcinekTrasy(amowo,bemowo,18.5f);
        OdcinekTrasy bdmpo = new OdcinekTrasy(bemowo,dmPol,25.2f);
        OdcinekTrasy dmpodmg = new OdcinekTrasy(dmPol,dmGlowny,3.0f);
        OdcinekTrasy dmgdmf = new OdcinekTrasy(dmGlowny,dmFab,5.2f);
        OdcinekTrasy dmfc = new OdcinekTrasy(dmFab,cemowo,30.0f);
        OdcinekTrasy cd = new OdcinekTrasy(cemowo,demowo,28.8f);
        OdcinekTrasy ce = new OdcinekTrasy(cemowo,emowo,44.4f);
        OdcinekTrasy ef = new OdcinekTrasy(emowo,efowo,41.9f);
        OdcinekTrasy fimg = new OdcinekTrasy(efowo,imGlowny,52.2f);
        OdcinekTrasy imgimp = new OdcinekTrasy(imGlowny,imPln,7.1f);
        OdcinekTrasy imgjw = new OdcinekTrasy(imGlowny,wies,20.5f);
        OdcinekTrasy jwks = new OdcinekTrasy(wies,koniec,10.7f);
        OdcinekTrasy jwg = new OdcinekTrasy(wies,gemowo,25.2f);
        OdcinekTrasy gdmprz = new OdcinekTrasy(gemowo,dmPrzed,21.6f);
        OdcinekTrasy dmprzdmg = new OdcinekTrasy(dmPrzed,dmGlowny,4.6f);

        //stwórz cenniki
        Cennik c1 = new Cennik(2.4f,1.5f);
        Cennik c2 = new Cennik(2.8f,1.2f);

        //stwórz przewoźników
        Przewoznik szybki = new Przewoznik(c2,"Szybki Transport sp.z.o.o.","SzP","ul. Krótka 4, Duże Miasto, 12-345");
        Przewoznik regio = new Przewoznik(c1,"Transport Regionalny Inc","TREG","ul. Kościelna 21/6, Inne Miasto, 98-765");

        //stwórz pociągi
        Pociag adReg = new Pociag(regio,200,55.5f);
        Pociag dmImSz = new Pociag(szybki,150,88f);
        Pociag deImSz = new Pociag(szybki,220,111f);
        Pociag imKsReg = new Pociag(regio,120,49.5f);

        //stwórz trasy
        List<OdcinekTrasy> trasa = new ArrayList<>();
        trasa.add(dmprzdmg);
        trasa.add(gdmprz);
        trasa.add(jwg);
        trasa.add(imgjw);
        Trasa DuzeInne = new Trasa(trasa,dmImSz);

        trasa.clear();
        trasa.add(imgimp);
        trasa.add(imgjw);
        trasa.add(jwks);
        Trasa InneKoniec = new Trasa(trasa,imKsReg);

        trasa.clear();
        trasa.add(ab);
        trasa.add(bdmpo);
        trasa.add(dmpodmg);
        trasa.add(dmgdmf);
        trasa.add(dmfc);
        trasa.add(cd);
        Trasa AmDe = new Trasa(trasa,adReg);

        trasa.clear();
        trasa.add(cd);
        trasa.add(ce);
        trasa.add(ef);
        trasa.add(fimg);
        Trasa DeInne = new Trasa(trasa,deImSz);

        //stwórz postoje
        List<Postoj> postojList = new ArrayList<>();
        postojList.add(new Postoj(adReg,amowo,null,
                ZonedDateTime.of(2018,12,14,14,18,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,bemowo,ZonedDateTime.of(2018,12,14,14,38,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,14,39,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,dmPol,ZonedDateTime.of(2018,12,14,15,6,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,15,8,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,dmGlowny,ZonedDateTime.of(2018,12,14,15,11,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,15,20,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,dmFab,ZonedDateTime.of(2018,12,14,15,26,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,15,28,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,cemowo,ZonedDateTime.of(2018,12,14,16,0,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,16,1,0,0, ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(adReg,demowo,ZonedDateTime.of(2018,12,14,16,32,0,0, ZoneId.of("UTC+1")),
                null));

        postojList.add(new Postoj(dmImSz,dmGlowny,null,
                ZonedDateTime.of(2018,12,14,7,5,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(dmImSz,dmPrzed,ZonedDateTime.of(2018,12,14,7,7,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,7,9,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(dmImSz,gemowo,ZonedDateTime.of(2018,12,14,7,24,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,7,25,31,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(dmImSz,wies,ZonedDateTime.of(2018,12,14,7,42,0,0, ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,14,7,7,43,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(dmImSz,imGlowny,ZonedDateTime.of(2018,12,14,7,57,0,0, ZoneId.of("UTC+1")),
                null));

        postojList.add(new Postoj(imKsReg,imPln,null,
                ZonedDateTime.of(2018,12,15,10,15,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(imKsReg,imGlowny,ZonedDateTime.of(2018,12,15,10,23,0,0,ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,15,10,26,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(imKsReg,wies,ZonedDateTime.of(2018,12,15,10,51,0,0,ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,15,10,52,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(imKsReg,wies,ZonedDateTime.of(2018,12,15,11,5,0,0,ZoneId.of("UTC+1")),
                null));

        postojList.add(new Postoj(deImSz,demowo,null,
                ZonedDateTime.of(2018,12,16,15,50,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(deImSz,cemowo,ZonedDateTime.of(2018,12,16,16,5,0,0,ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,16,16,10,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(deImSz,emowo,ZonedDateTime.of(2018,12,16,16,34,0,0,ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,16,16,35,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(deImSz,efowo,ZonedDateTime.of(2018,12,16,16,58,0,0,ZoneId.of("UTC+1")),
                ZonedDateTime.of(2018,12,16,17,0,0,0,ZoneId.of("UTC+1"))));
        postojList.add(new Postoj(deImSz,imGlowny,ZonedDateTime.of(2018,12,16,17,28,0,0,ZoneId.of("UTC+1")),
                null));


        try {

            //taka nazwa jak w persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //utworz entityManagera
            manager = entityManagerFactory.createEntityManager();

            manager.getTransaction().begin();

            //zapisz stacje
            manager.persist(amowo);
            manager.persist(bemowo);
            manager.persist(dmPol);
            manager.persist(dmGlowny);
            manager.persist(dmFab);
            manager.persist(cemowo);
            manager.persist(demowo);
            manager.persist(emowo);
            manager.persist(efowo);
            manager.persist(imGlowny);
            manager.persist(imPln);
            manager.persist(wies);
            manager.persist(koniec);
            manager.persist(gemowo);
            manager.persist(dmPrzed);

            //zapisz odcinki
            manager.persist(ab);
            manager.persist(bdmpo);
            manager.persist(dmpodmg);
            manager.persist(dmgdmf);
            manager.persist(dmfc);
            manager.persist(cd);
            manager.persist(ce);
            manager.persist(ef);
            manager.persist(fimg);
            manager.persist(imgimp);
            manager.persist(imgjw);
            manager.persist(jwks);
            manager.persist(jwg);
            manager.persist(gdmprz);
            manager.persist(dmprzdmg);

            //zapisz cenniki
            manager.persist(c1);
            manager.persist(c2);

            //zapisz przewoźników
            manager.persist(szybki);
            manager.persist(regio);

            //zapisz pociągi
            manager.persist(adReg);
            manager.persist(deImSz);
            manager.persist(imKsReg);
            manager.persist(dmImSz);

            //zapisz trasy
            manager.persist(DuzeInne);
            manager.persist(InneKoniec);
            manager.persist(AmDe);
            manager.persist(DeInne);

            //zapisz postoje
            for (Postoj p : postojList)
                manager.persist(p);

            manager.flush();
            manager.getTransaction().commit();

        } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }
}
