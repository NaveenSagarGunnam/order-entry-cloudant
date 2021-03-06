package com.ibm.orderentry;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

@RestController
@RequestMapping("/orderentry")
public class OrderEntryController {
	
	@Autowired
	private CloudantClient client;
	
	private Database db;
    
	@RequestMapping("service/{message}")
	public String welcome(@PathVariable String message) {

		return message +" !!! IBM CLOUD Tool chain sample deployment..";
	}

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String orderRequestPersist(@RequestBody OrderRequest order) {
    	db = client.database("orders", false);
    	order.set_id("KYNDRYL-"+ UUID.randomUUID().toString());
    	order.setOrderId(System.currentTimeMillis());
       
        Response r = null;
        if (order != null) {
            r = db.post(order);
        }
        return "Order successfully created  with Order ID "+ order.getOrderId();
    }

    // Query reviews for all documents
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<OrderRequest> getAll() {
    	db = client.database("orders", false);
    	// Get all documents from orders
        List<OrderRequest> allDocs = null;
        try {
            
                allDocs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse()
                            .getDocsAs(OrderRequest.class);
            } catch (Exception e) {
           
            	System.out.println("Exception thrown : " + e.getMessage());
        }
        return allDocs;
    }
}
