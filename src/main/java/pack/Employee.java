package pack;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="employee")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name= "eid")
	private int Eid;
	
	@Column(name = "ename")
	private String Ename;
	
	@Column(name= "emob")
	private String Emob;
	
	@Column(name= "esalary")
	private String Esal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;
	
	
	@ManyToOne
	@JoinColumn(name = "did")
	private Department department;		//Reference of Department Class
	
	
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEmob() {
		return Emob;
	}
	public void setEmob(String emob) {
		Emob = emob;
	}
	public String getEsal() {
		return Esal;
	}
	public void setEsal(String esal) {
		Esal = esal;
	}

	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}