package com.atrium.master;

import java.util.Date;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import com.atrium.master.pojos.Prestamo;
import com.atrium.master.pojos.Usuario;
import com.atrium.master.pojos.Libro;

public class ProgramaLecturas {
	
	public static void main(String[] args) {
		Libro libro1=new Libro("1", "Libro de prueba 1","Autor 1","El libro 1 es muy feo");
		Usuario usuario1=new Usuario(1l, "11111111H", "Primer", "Usuario",666666666);
		
		Date utilDate = new Date(); // fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		
		Prestamo prestamo=new Prestamo(sqlDate, sqlDate, null);
		prestamo.setLibro(libro1);
		prestamo.setUsuario(usuario1);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.getCurrentSession();
		Transaction tx = ss.getTransaction();
		tx.begin();
		ss.save(libro1);
		ss.save(usuario1);
		ss.save(prestamo);
//		ss.delete(p3);
//		System.out.println("-----------------");
//		List<Persona> lista=ss.createQuery("From Persona")
//			.list();
//		for(Persona per:lista)
//			System.out.println(per);
//		
//		System.out.println("-----------------");
//		List<DNI_B> lista2=ss.createQuery("From DNI_B")
//			.list();
//		for(DNI_B d:lista2)
//			System.out.println(d);
//		
//		System.out.println("-----------------");
//		List<Alquiler_B> lista3=ss.createQuery("From Alquiler_B")
//			.list();
//		for(Alquiler_B a:lista3)
//			System.out.println(a);
//		
//		System.out.println("-----------------");
//		List<Vehiculo_B> lista4=ss.createQuery("From Vehiculo_B")
//			.list();
//		for(Vehiculo_B v:lista4)
//			System.out.println(v);
//		
//		System.out.println("-----------------");
//		List<Direccion_B> lista5=ss.createQuery("From Direccion_B")
//			.list();
//		for(Direccion_B d:lista5)
//			System.out.println(d);
		tx.commit();
		
		sf = HibernateUtil.getSessionFactory();
		ss = sf.getCurrentSession();
		tx = ss.getTransaction();
		tx.begin();
		System.out.println("--------------------------------");
		
		Libro libro = (Libro)ss.get(Libro.class, 1);
		
		System.out.println(libro);
		System.out.println("--------------------------------");
		
		/*System.out.println("Vehiculos:");
		for(Vehiculo vehiculo:miPersona.getVehiculo()){
			System.out.println("-->"+vehiculo);
		}*/
		tx.commit();
		
		
	}
}
