package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	protected Integer id;
	protected String name;

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}
