package com.scp.HibernateDemo2.OneToOneuni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Stud sd1 = new Stud(10, "nitin");
		cla c1 = new cla(1, "tkiet", sd1);
		Configuration con = new Configuration();
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.save(sd1);
		tr.commit();
	}

}

@Entity
@Table(name = "clstb1")
class cla {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int claid;
	@Column
	String claname;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	Stud stud;

	public int getClaid() {
		return claid;
	}

	public void setClaid(int claid) {
		this.claid = claid;
	}

	public String getClaname() {
		return claname;
	}

	public void setClaname(String claname) {
		this.claname = claname;
	}

	@Override
	public String toString() {
		return "cla [claid=" + claid + ", claname=" + claname + "]";
	}

	public cla(int claid, String claname, Stud stud) {
		super();
		this.claid = claid;
		this.claname = claname;
		this.stud = stud;
	}

	public cla() {
		super();

	}

}

@Entity
@Table
class Stud {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Studid;
	@Column
	String name;

	public int getStudid() {
		return Studid;
	}

	public void setStudid(int studid) {
		Studid = studid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Stud [Studid=" + Studid + ", name=" + name + "]";
	}

	public Stud(int studid, String name) {
		super();
		Studid = studid;
		this.name = name;
	}

	public Stud() {
		super();
		// TODO Auto-generated constructor stub
	}

}
