package org.restapp.showrrom.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restapp.showrrom.model.ProductsEntity;
import org.restapp.showrrom.service.ProductsService;


@Path("showroom/brands")
public class ProductsController {

	ProductsService service = new ProductsService();

	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductsEntity> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category,@QueryParam("start") int start,@QueryParam("end") int end) {
		List<ProductsEntity> productlist;
		if (category != null) {
			productlist = service.getProductsByBrandIDAndCategory(brandId, category);

		} else {
			productlist = service.getProducts(brandId);

		}
		if(end>0) {
			productlist=productlist.subList(start, end);
		}

		return productlist;

	}

}
