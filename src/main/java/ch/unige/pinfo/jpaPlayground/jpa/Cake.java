package ch.unige.pinfo.jpaPlayground.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CAKE")
public class Cake {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE")
	private CakeType type;
	
	@Column(name="PURPOSE")
	private String purpose;
	
	@ManyToOne
	private Baker baker;

	public CakeType getType() {
		return type;
	}

	public void setType(CakeType type) {
		this.type = type;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id + " --- " + type.toString() + " "+ purpose + "\n made by: " + baker.getName();
	}

	public Baker getBaker() {
		return baker;
	}

	public void setBaker(Baker baker) {
		this.baker = baker;
	}
	
}
