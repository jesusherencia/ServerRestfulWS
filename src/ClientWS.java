import javax.ws.rs.core.MediaType;

import model.PaymentInvoice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientWS {
	
	public static void main(String[]args){
		
		Client client = Client.create();
//        WebResource resource = client.resource("http://localhost:8080/TestRestfulWS/rest/products");
// 
//        // Get response as String
//        String string = resource.accept(MediaType.APPLICATION_XML)
//                .get(String.class);
//        System.out.println(string);
//        
//        // Get response as List<Customer>
//        List<Product> customers = resource.accept(MediaType.APPLICATION_XML)
//                .get(new GenericType<List<Product>>(){});
//        System.out.println(customers.size());
//        
//        // create purchase order
//        WebResource resource1 = client.resource("http://localhost:8080/TestRestfulWS/rest/purchaseorders");
//        
//        PurchaseOrder po = new PurchaseOrder();
//        po.setId(1);
//        
//        ClientResponse response = resource1.accept(MediaType.APPLICATION_XML).post(
//        ClientResponse.class, po);
//        
//        System.out.println(response);
        
        // Get response as List<Customer>
//        WebResource resource2 = client.resource("http://localhost:8080/TestRestfulWS/rest/invoices/search/partner/6");
//        List<Invoice> invoices = resource2.accept(MediaType.APPLICATION_XML)
//                .get(new GenericType<List<Invoice>>(){});
//        System.out.println(invoices.size());
        
        WebResource resource1 = client.resource("http://127.0.0.1:8080/TestRestfulWS/rest/paymentinvoices");
		PaymentInvoice pi = new PaymentInvoice();
		pi.setInvoice_id(5);
		ClientResponse response = resource1.accept(MediaType.APPLICATION_XML).post(
		ClientResponse.class, pi);

	}
	
}