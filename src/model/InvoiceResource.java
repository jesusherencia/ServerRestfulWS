package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.Vente;

@Path("/invoices")
public class InvoiceResource {

	public InvoiceResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}

	@GET @Path("search/partner/{query}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Invoice> listOpenInvoicesByCustomer(@PathParam("query") String idCustomer) {
		System.out.println("findOpenInvoicesByCustomerId: " + idCustomer);
		ArrayList<Invoice> listeInvoicesB = new ArrayList<Invoice>();
		ArrayList<connexion.openerp.api.model.Invoice> listeInvoicesA = Vente.listerInvoices(Integer.valueOf(idCustomer));
		for(connexion.openerp.api.model.Invoice pA : listeInvoicesA){
			Invoice pB = new Invoice();
			pB.setId(pA.getId());
			pB.setName(pA.getName());
			pB.setRefOrder(pA.getRefOrder());
			pB.setTotal(pA.getTotal());
			listeInvoicesB.add(pB);
		}
		return listeInvoicesB;
	}

}
