package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.ConnexionOpenErp;

@Path("/customers")
public class CustomerResource {

	public CustomerResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Customer> findAll() {
		System.out.println("findAll");
		ArrayList<Customer> listeCustomerB = new ArrayList<Customer>();
		ArrayList<connexion.openerp.api.model.Customer> listeCustomerA = ConnexionOpenErp.listerCustomers();;
		for(connexion.openerp.api.model.Customer pA : listeCustomerA){
			Customer pB = new Customer();
			pB.setId(pA.getId());
			pB.setName(pA.getName());
			listeCustomerB.add(pB);
		}
		return listeCustomerB;
	}
//
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Customer findById(@PathParam("id") String id) {
		List<Customer> liste = findAll();
		for(Customer c : liste){
			if (c.getId().equals(Integer.valueOf(id))){
				return c;
			}
		}
		return null;
	}

}
