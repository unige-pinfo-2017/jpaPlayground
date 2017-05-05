package ch.unige.pinfo.jpaPlayground;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.unige.pinfo.jpaPlayground.jpa.Baker;
import ch.unige.pinfo.jpaPlayground.jpa.Cake;
import ch.unige.pinfo.jpaPlayground.jpa.CakeType;

public class BakerTest {

	@Test
	public void testBaker(){
		
		Baker tom = new Baker();
		tom.setName("Tom");
		tom.setSpeciality("Croissants");
		
		Baker steve = new Baker();
		steve.setName("Steve");
		steve.setSpeciality("Bread");
		
		Cake c = new Cake();
		c.setPurpose("for Stefan");
		c.setType(CakeType.Cupcake);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tom);
		em.persist(steve);
		em.persist(c);
		
		tom.getCakelist().add(c);
		c.setBaker(tom);
		
		em.persist(tom);
		em.persist(c);
		
		em.getTransaction().commit();
		
		Query q = em.createQuery("select b from Baker b where :id ");
		List<Baker> bakers = q.getResultList();
		for(Baker b : bakers){
			System.out.println(b.toString());
		}
		
		em.close();
		emf.close();
		
	}
}
