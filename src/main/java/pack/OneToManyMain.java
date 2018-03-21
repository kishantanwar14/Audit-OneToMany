package pack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyMain 
{
	public static void main(String[] args) 
	{
		//create();
		//update();
	    delete();
	}
	
	    public static void create()
	    {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditOnetoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Starting insertion in Database---------");
			em.getTransaction().begin();
			
	        Department d1 = new Department();
	        d1.setDname("IT");
	        d1.setDmob("78546622");
	        d1.setCreatedOn(new Date());
	        em.persist(d1);
	        
	        Department d2 = new Department();
	        d2.setDname("Account");
	        d2.setDmob("84555452");
	        d2.setCreatedOn(new Date());
	        em.persist(d2);
	        
	       /* System.out.println();
	        System.out.println();
	        System.out.println("Generated Department = " + d1.getDname());
	        System.out.println("Saving Department to Database");*/
	        
	        
	        //ArrayList<Employee> empList = new ArrayList<Employee>();
	        List<Employee> empList = new ArrayList<Employee>();
	        
	        Employee e1 = new Employee();
	        e1.setEname("John");
	        e1.setEmob("1111111111");
	        e1.setEsal("1000000");
	        e1.setDepartment(d1);
	        e1.setCreatedOn(new Date());
	        empList.add(e1);

	        
	        Employee e2 = new Employee();
	        e2.setEname("Jenny");
	        e2.setEmob("222222222");
	        e2.setEsal("2000000");
	        e2.setDepartment(d1);
	        e2.setCreatedOn(new Date());
	        empList.add(e2);
	        
	        
	        Employee e3 = new Employee();
	        e3.setEname("Janadhan");
	        e3.setEmob("3333333333333");
	        e3.setEsal("3000000");
	        e3.setDepartment(d1);
	        e3.setCreatedOn(new Date());
	        empList.add(e3);
	        
	        Employee e4 = new Employee();
	        e4.setEname("Tararampam");
	        e4.setEmob("4444444444");
	        e4.setEsal("4000000");
	        e4.setDepartment(d1);
	        e4.setCreatedOn(new Date());
	        //empList.add(e4);
	        
	       e4.setDepartment(d2);
	        
	        
	        
	        d1.setEmployee(empList);
	        em.persist(d1);
	        em.persist(e4);
			em.getTransaction().commit();
			em.close();			
			emf.close() ;
	    }
	    
	  
	    public static void update() 
	    {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditOnetoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Starting updation in Database---------");
			em.getTransaction().begin();
			
			Employee e1 = em.find(Employee.class, 2);
			e1.setEname("Kishan");
			e1.setEsal("100000000000");
			e1.setEmob("941000000");
			e1.setCreatedOn(new Date()); 
			
			/* String hql = "update Department d set d.departName=:dname where d.ID=2";
			Query query = em.createQuery(hql);
			query.setParameter("dname","Accounts modified");
			em.persist(updateCount);
			query.executeUpdate();*/
			
			em.getTransaction().commit();
			em.close();
			emf.close();
	    }
	    
	    
	   public static void delete()
	   {
		   	EntityManagerFactory emf = Persistence.createEntityManagerFactory("auditOnetoMany");
			EntityManager em = emf.createEntityManager();
			System.out.println("-----------Starting deletion in Database---------");
			em.getTransaction().begin();
			
			Employee empdel = em.find(Employee.class, 7);
			em.remove(empdel);
			
			/*em.getTransaction().begin();
			Query query=em.createQuery("delete from Employee e where e.id=1");  
			query.executeUpdate(); */
			
			
			empdel.setCreatedOn(new Date());
			em.getTransaction().commit();
			em.close();
		    emf.close();
	   }
}


