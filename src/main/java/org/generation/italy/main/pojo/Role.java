package org.generation.italy.main.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	public Role() {}
	
	public Role(String name) {
		setName(name);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	
	@Override
	public int hashCode() {
		
		if (this.id != null) return getId();
		
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Role)) return false;
		
		return obj.hashCode() == hashCode();
	}
	
	@Override
	public String toString() {
		return getId() + " - " + getName();
	}
}
