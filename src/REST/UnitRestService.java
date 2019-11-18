package REST;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Unit;
import business.UnitBusinessInterface;

@RequestScoped
@Path("/unit")
public class UnitRestService {

	@Inject
	UnitBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Unit> getUnitAsJson(){
		return service.getAllUnits();
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Unit saveUser(Unit unit) {
		service.addUnit(unit);
		return unit;
	}

}
