package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connexion.openerp.api.ConnexionOpenErp;

@Path("/products")
public class ProductResource {

	public ProductResource() {
		// TODO Auto-generated constructor stub
		Connexion.connexion();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> findAll() {
		System.out.println("findAll");
		ArrayList<Product> listeProductsB = new ArrayList<Product>();
		ArrayList<connexion.openerp.api.model.Product> listeProductsA = ConnexionOpenErp.listerProducts();
		for(connexion.openerp.api.model.Product pA : listeProductsA){
			Product pB = new Product();
			pB.setId(pA.getId());
			pB.setName(pA.getName());
			pB.setQtyAvailable(pA.getQtyAvailable());
			pB.setPrixVente(pA.getPrixVente());
			listeProductsB.add(pB);
		}
		
//		listeProductsB.add(new Product(1,"adfasdf"));
//		listeProductsB.add(new Product(2,"afwefwaef"));
		return listeProductsB;
	}

//	@GET @Path("search/{query}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public List<Product> findByName(@PathParam("query") String query) {
//		System.out.println("findByName: " + query);
//		return dao.findByName(query);
//	}
//
//	@GET @Path("{id}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Product findById(@PathParam("id") String id) {
//		System.out.println("findById " + id);
//		return dao.findById(Integer.parseInt(id));
//	}
//
//	@POST
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Product create(Product product) {
//		System.out.println("creating product");
//		return dao.create(product);
//	}
//
//	@PUT @Path("{id}")
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Product update(Product product) {
//		System.out.println("Updating product: " + product.getName());
//		dao.update(product);
//		return product;
//	}
//	
//	@DELETE @Path("{id}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public void remove(@PathParam("id") int id) {
//		dao.remove(id);
//	}

}
