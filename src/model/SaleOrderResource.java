package model;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.Vente;

@Path("/saleorders")
public class SaleOrderResource {

	public SaleOrderResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}
//
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public SaleOrder create(SaleOrder so) {
		System.out.println("creating sale order");
		so.setId(Vente.creerSalesOrder(so.getClient_id()));
		Vente.creerLigneSalesOrder(so.getId(), so.getProduct_id(), so.getQuantity());
		return so;
	}

}
