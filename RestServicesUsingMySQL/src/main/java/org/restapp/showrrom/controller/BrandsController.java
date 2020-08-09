package org.restapp.showrrom.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.restapp.showrrom.model.BrandsEntity;
import org.restapp.showrrom.model.RelationsLink;
import org.restapp.showrrom.service.BrandsService;

@Path("showroom/brands")
public class BrandsController {

	BrandsService service = new BrandsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandsEntity> getBrands() {
		return service.getBrands();
	}

	@GET
	@Path("{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandsEntity getBrand(@PathParam("brandId") int brandId, @Context UriInfo uri) {
		RelationsLink self = new RelationsLink(uri.getAbsolutePath().toString(), "self");
		RelationsLink products = new RelationsLink(
				uri.getAbsolutePathBuilder().path("products").resolveTemplate("brandId", brandId).toString(),
				"products");
		List<RelationsLink> link = new ArrayList<RelationsLink>();
		link.add(self);
		link.add(products);
		BrandsEntity brand = new BrandsEntity();
		brand.setLink(link);

		return brand;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBrand(BrandsEntity brand, @Context UriInfo uri) {
		service.addBrand(brand);
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		Response response = Response.created(location).entity(brand).build();
		return response;
	}

	@PUT
	@Path("{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBrand(@PathParam("brandId") int brandId, BrandsEntity brand) {
		brand.setBrandId(brandId);
		service.updateBrand(brand);
	}

	@DELETE
	@Path("{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId) {
		service.deleteBrand(brandId);
	}

}
