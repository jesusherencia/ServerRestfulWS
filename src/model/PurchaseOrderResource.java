package model;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.Achat;

@Path("/purchaseorders")
public class PurchaseOrderResource {

	public PurchaseOrderResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}
//
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PurchaseOrder create(PurchaseOrder po) {
		System.out.println("creating product");
		Integer po_id = Achat.creerPurchaseOrder(po.getClient_id());
		return po;
	}

}
