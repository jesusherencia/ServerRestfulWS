package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.Payment;
import connexion.openerp.api.Vente;

@Path("/paymentinvoices")
public class PaymentInvoiceResource {

	public PaymentInvoiceResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PaymentInvoice create(PaymentInvoice pi) {
		System.out.println("creating payment from invoice");
		Payment.creerVoucherSaleFromInvoice(pi.getInvoice_id());
		return pi;
	}

}
