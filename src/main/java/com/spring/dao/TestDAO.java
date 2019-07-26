package com.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.spring.pojo.User;

@Repository
public class TestDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Autowired
	private HibernateTemplate template;
	
/*	
	static{
		sessionfactory=new AnnotationConfiguration().configure().buildSessionFactory();
	}
*/
	@Transactional
	public String register(User user, Model m){
		try{
			System.out.println("SessionFactory object is: "+sessionfactory);
			System.out.println("Template object is: "+template);
			//Session session = sessionfactory.openSession();
			template.save(user);
			
		//	Transaction transaction = session.beginTransaction();
			//transaction.commit();
			//session.close();
		
			//session.beginTransaction().commit();
			}catch(HibernateException he){
				m.addAttribute("message", "the user already exists");
			}
			//System.out.println(user.getEmailId());
			return "login";
	}
}
