package ch.unige.pinfo.jpaPlayground.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BAKER")
public class Baker implements Serializable{

	private static final long serialVersionUID = -7336831212199215915L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SPECIALITY")
	private String speciality;
	
	@OneToMany(mappedBy="baker")
	private List<Cake> cakelist = new ArrayList<Cake>();
	
	
	public List<Cake> getCakelist() {
		return cakelist;
	}

	@Override
	public String toString() {
		return "Baker #"+id+" "+name+"(Speciality: "+speciality+")" + "made "+cakelist.size() + " cakes";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Long getId() {
		return id;
	}
	
}
