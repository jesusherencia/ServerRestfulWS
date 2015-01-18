package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SaleOrder {

	protected Integer id;
    protected Integer client_id;
    protected String refOrder;
    protected Integer product_id;
    protected Double quantity;
    protected Double prix;
    protected Double total;
    
    public SaleOrder(){
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public String getRefOrder() {
		return refOrder;
	}

	public void setRefOrder(String refOrder) {
		this.refOrder = refOrder;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
