package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentInvoice {
	protected Integer id;
	protected Integer invoice_id;

	public PaymentInvoice() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
}
