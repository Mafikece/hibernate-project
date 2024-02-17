package com.au.hibernate_demo.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.au.hibernate_demo.entity.EmployeeDTO;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Disjunction;

public class EmployeeDAO {

	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//insert
	//	EmployeeDTO dto=new EmployeeDTO();
	//	dto.setId(104);
	//	dto.setName("Keshu");
	//	dto.setDesignation("Tester");
	//	dto.setSalary(30000.00);
	//	session.save(dto);
	//	Transaction transaction = session.beginTransaction();
	//	transaction.commit();
		
		//Fetch
	//	EmployeeDTO dto = session.load(EmployeeDTO.class, 102);
	//	System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());		
		
		//Update
	//	EmployeeDTO dto2 = session.load(EmployeeDTO.class, 102);
	//	dto2.setSalary(dto2.getSalary()+10000);
	//	session.update(dto2);	
	//	Transaction transaction = session.beginTransaction();
	//	transaction.commit();
		
		//Delete
		
	//	EmployeeDTO dto = session.load(EmployeeDTO.class, 103);
	//	session.delete(dto);
	//	Transaction transaction = session.beginTransaction();
	//	transaction.commit();
	//	session.close();
		
		//Fetch More than 1 record by Query
	//	Query query = session.createQuery("from EmployeeDTO");
	//	List <EmployeeDTO> list = query.list();
	//	for (EmployeeDTO dto : list) {
	//		System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
	//	}
		
		//fetch single record with condition
	//	Query query2 = session.createQuery("from EmployeeDTO where id=101");
	//	EmployeeDTO dto = (EmployeeDTO) query2.uniqueResult();
	//	System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
		
		
		//insert by auto generated id
		
	//		EmployeeDTO dto=new EmployeeDTO();
	//		//dto.setId(104);
	//		dto.setName("Zaid");
	//		dto.setDesignation("Developer");
	//		dto.setSalary(50000.00);
	//		session.save(dto);
	//		Transaction transaction = session.beginTransaction();
	//		transaction.commit();
		//==========HCQL=================
//		Criteria cr = session.createCriteria(EmployeeDTO.class);
//		List<EmployeeDTO> list = cr.list();
//		for (EmployeeDTO dto : list) {
//			System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
//		}
//		
//		Criteria cr = session.createCriteria(EmployeeDTO.class);
//		cr.add(Restrictions.eq("designation", "Developer"));
//		cr.add(Restrictions.ge("salary", 50000.00));
//		List<EmployeeDTO> list = cr.list();
//		for (EmployeeDTO dto : list) {
//			System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
//		}
//		//AND condition
//		Criteria cr = session.createCriteria(EmployeeDTO.class);
//		cr.addOrder(Order.asc("salary"));
//		List<EmployeeDTO> list = cr.list();
//		for (EmployeeDTO dto : list) {
//			System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
//		}
		
		//with OR condition
//		org.hibernate.criterion.Disjunction or = Restrictions.disjunction();
//		or.add(Restrictions.eq("name", "Bijoy"));
//		or.add(Restrictions.eq("designation", "Tester"));
//		Criteria cr = session.createCriteria(EmployeeDTO.class);
//		cr.add(or);
//		List<EmployeeDTO> list = cr.list();
//		for (EmployeeDTO dto : list) {
//			System.out.println(dto.getName()+" "+dto.getDesignation()+" "+dto.getSalary());
//		}
		
		ProjectionList p1=Projections.projectionList();
		 p1.add(Projections.property("name"));
		 p1.add(Projections.property("salary"));
		 Criteria ctr=session.createCriteria(EmployeeDTO.class);
		 ctr.setProjection(p1);
		 List<Object[]> list = ctr.list();
		 for (Object object[] : list) {
			System.out.println(object[0]+" "+object[1]);
		}

		session.close();
		
	}

}
