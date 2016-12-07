package tuotejpa;

import java.util.List;

import javax.persistence.*;

public class TestTuotePeritytJpa {

	public static void main(String[] args) throws Exception {
		// Startataan H2 TCP-serverimoodissa
        org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();

		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_tuoteperityt");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();

		Kirja k1 = new Kirja();
		k1.setIsbn("A123");
		k1.setNimi("Core Java");
		k1.setHinta(26.99);
		k1.setTekijat("Cay Horstmann");

		Kirja k2 = new Kirja();
		k2.setIsbn("A223");
		k2.setNimi("JavaScript Ninja");
		k2.setTekijat("John Resig");
		k2.setHinta(33.50);

		Kirja k3 = new Kirja();
		k3.setIsbn("A313");
		k3.setNimi("Thinking Of Java");
		k3.setTekijat("Bruce Eckel");
		k3.setHinta(9.95);

		Cd cd1 = new Cd("Iron Maiden", "Powerslave", 3048, 8, 19.95);
		Cd cd2 = new Cd("Tom Petty", "Full Moon Fever", 2398, 12, 14.95);
		Cd cd3 = new Cd("Paula Koivuniemi", "Luotan Sydämen Ääneen", 2850, 12, 4.95);
		Cd cd4 = new Cd("The Beatles", "Abbey Road", 2545, 17, 29.95);

		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k3);
		manageri.persist(cd1);
		manageri.persist(cd2);
		manageri.persist(cd3);
		manageri.persist(cd4);

		transaktio.commit();

		// haetaan ja tulostetaan kaikki tietokannassa olevat Kirja-entiteetit
		@SuppressWarnings("unchecked")
		List<Kirja> haetut = manageri.createNamedQuery("etsiKaikkiKirjat").getResultList();
		for (Kirja k : haetut) {
			System.out.println("Rivi: " + (Kirja) k);
		}

		// Etsi kaikki annettua hinta kalliimmat Cd-entiteetit
		@SuppressWarnings("unchecked")
		List<Cd> haetut2 = manageri.createNamedQuery("etsiKaalliitLevyt").setParameter("rajahinta", 15).getResultList();
		for (Cd cd : haetut2) {
			System.out.println("Rivi: " + cd);
		}

		// Etsi kaikki annettua hinta halvemmat Tuote-entiteetit (myös siitä periytytyt entiteetit)
		@SuppressWarnings("unchecked")
		List<Tuote> haetut3 = manageri.createNamedQuery("etsiHalvatTuotteet").setParameter("rajahinta", 15).getResultList();
		for (Tuote t : haetut3) {
			if (t instanceof Kirja)
				System.out.println("Kirja: " + t);
			else if (t instanceof Cd)
				System.out.println("Cd: " + t);
		}

		manageri.close();
		tehdas.close();
        // Lopetetaan h2-palvelin
        server.stop();

	}
}
