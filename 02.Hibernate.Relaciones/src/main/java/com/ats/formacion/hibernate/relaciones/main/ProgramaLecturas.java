package com.ats.formacion.hibernate.relaciones.main;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import org.hibernate.criterion.Property;



import com.ats.formacion.hibernate.*;
import com.ats.formacion.hibernate.relaciones.Alquiler;
import com.ats.formacion.hibernate.relaciones.Alquiler_B;
import com.ats.formacion.hibernate.relaciones.DNI;
import com.ats.formacion.hibernate.relaciones.DNI_B;
import com.ats.formacion.hibernate.relaciones.Direccion;
import com.ats.formacion.hibernate.relaciones.Direccion_B;
import com.ats.formacion.hibernate.relaciones.PartidaNacimiento;
import com.ats.formacion.hibernate.relaciones.PartidaNacimiento2;
import com.ats.formacion.hibernate.relaciones.PartidaNacimiento_B;
import com.ats.formacion.hibernate.relaciones.Persona;
import com.ats.formacion.hibernate.relaciones.Vehiculo;
import com.ats.formacion.hibernate.relaciones.Vehiculo_B;
import com.ats.formacion.hibernate.relaciones.util.HibernateUtil;
public class ProgramaLecturas {
	
	public static void main(String[] args) {
		Persona p1= new Persona("ana",new DNI("123123123",'a'),new PartidaNacimiento("eadfas",'g'),new PartidaNacimiento2("ggggg",'r'));
//		Persona p2= new Persona("juana",new DNI("543765",'q'),new PartidaNacimiento("aaaaa",'d'),new PartidaNacimiento2("ggggg",'r'));
//		Persona p3= new Persona("pedro",new DNI("877986",'s'),new PartidaNacimiento("ggggg",'r'),new PartidaNacimiento2("ggggg",'r'));

		p1.getVehiculo().add(new Vehiculo("ford"));
		p1.getVehiculo().add(new Vehiculo("seat"));
		p1.getVehiculo().add(new Vehiculo("toyota"));
//		p2.getVehiculo().add(new Vehiculo("lancia"));
//		p2.getVehiculo().add(new Vehiculo("fiat"));
		
		p1.getAlquileres().add(new Alquiler("mayo2005"));
		p1.getAlquileres().add(new Alquiler("2006"));
//		p2.getAlquileres().add(new Alquiler("2006"));
//		p2.getAlquileres().add(new Alquiler("2007"));
//		p2.getAlquileres().add(new Alquiler("2008"));
		
		p1.getDirecciones().add(new Direccion("madrid"));
//		p2.getDirecciones().add(new Direccion("madrid"));
//		p2.getDirecciones().add(new Direccion("valencia"));
//		p2.getDirecciones().add(new Direccion("barcelo"));
//		p2.getDirecciones().add(new Direccion("sevilla"));
//		
		p1.setDni_b(new DNI_B("2343",'s'));
//		p2.setDni_b(new DNI_B("76768768",'s'));
//		p3.setDni_b(new DNI_B("9999",'j'));
		
		p1.setPartida_b(new PartidaNacimiento_B("2343",'s'));
//		p2.setPartida_b(new PartidaNacimiento_B("768876",'s'));
//		p3.setPartida_b(new PartidaNacimiento_B("234423423",'s'));
		
		
		p1.getAlquileres_b().add(new Alquiler_B("malo"));
//		p2.getAlquileres_b().add(new Alquiler_B("2006"));
//		p2.getAlquileres_b().add(new Alquiler_B("2007"));
//		p2.getAlquileres_b().add(new Alquiler_B("2008"));
		//p1.addAquiler_b(new Alquiler_B("mayo2005"));
		Alquiler_B alb1 = new Alquiler_B("mayo2005");
		alb1.setP(p1);
		p1.getAlquileres_b().add(alb1);
//		p2.addAquiler_b(new Alquiler_B("2006"));
//		p2.addAquiler_b(new Alquiler_B("2007"));
//		p2.addAquiler_b(new Alquiler_B("2008"));
//		p2.addAquiler_b(new Alquiler_B("2006"));
		
		p1.addVehiculo_B(new Vehiculo_B("600"));
		p1.addVehiculo_B(new Vehiculo_B("124"));
//		p2.addVehiculo_B(new Vehiculo_B("1500"));
//		p2.addVehiculo_B(new Vehiculo_B("panda"));
		
		Direccion_B db1 = new Direccion_B("mirar");
		p1.addDireccion_B(db1);
//		p2.addDireccion_B(db1);
		p1.addDireccion_B(new Direccion_B("jaen"));
//		p2.addDireccion_B(new Direccion_B("lugo"));
//		p2.addDireccion_B(new Direccion_B("m"));
//	
		p1.addAquiler_ExtraInfo(new Alquiler("2006"));
		p1.addAquiler_ExtraInfo(new Alquiler("199"));
//		p2.addAquiler_ExtraInfo(new Alquiler("666"));
		
		p1.addAlquiler_Ternario(new Alquiler("weqeqw"));
//		p2.addAlquiler_Ternario(new Alquiler("weqeqw"));
//		p3.addAlquiler_Ternario(new Alquiler("weqeqw"));
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.getCurrentSession();
		Transaction tx = ss.getTransaction();
		tx.begin();
		ss.save(p1);
//		ss.save(p2);
//		ss.save(p3);
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
		
		Persona miPersona = (Persona)ss.get(Persona.class, 1);
		
		System.out.println("Persona:"+miPersona.getNombre());
		System.out.println("--------------------------------");
		
		System.out.println("Vehiculos:");
		for(Vehiculo vehiculo:miPersona.getVehiculo()){
			System.out.println("-->"+vehiculo);
		}
		tx.commit();
		
		
	}
}
