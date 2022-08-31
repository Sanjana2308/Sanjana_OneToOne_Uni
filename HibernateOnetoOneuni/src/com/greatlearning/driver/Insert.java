package com.greatlearning.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class Insert {
	public static void main(String [] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		//create session 
		Session session=factory.getCurrentSession();
		
		try {
			//create the object
			Teacher teacher= new Teacher("Harshit","Choudhry","harshit@org.com");
			TeacherDetails teacherDetails = new TeacherDetails("vikas","playFootball");
			
			teacher.setTeacherDetails(teacherDetails);
			
			//start session
			session.beginTransaction();
			
			// save the teacher
			session.save(teacher);
			
			//commit transections
			session.getTransaction().commit();

		}
		finally {
			factory.close();
		}
	}

}
