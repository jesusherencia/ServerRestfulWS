package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invoice {
	protected Integer id;
	protected String name;
	protected String refOrder;
	protected Double total;

	public Invoice() {
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

	public String getRefOrder() {
		return refOrder;
	}

	public void setRefOrder(String refOrder) {
		this.refOrder = refOrder;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
}
