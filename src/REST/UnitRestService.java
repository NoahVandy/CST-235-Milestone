package REST;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Unit;
import business.UnitBusinessInterface;

@RequestScoped
@Path("/unit")
public class UnitRestService {

	@Inject
	UnitBusinessInterface service;
	
	/**
	 * getting the full list of the units returned as JSON
	 * @return
	 */
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Unit> getUnitAsJson(){
		return service.getAllUnits();
	}
	
	/**
	 * process saving a new unit
	 * @param unit
	 * @return
	 */
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Unit saveUnit(Unit unit) {
		service.addUnit(unit);
		return unit;
	}
	
	/**
	 * Process update a unit
	 * @param unit
	 * @param unitNumber
	 * @param unitCode
	 * @return
	 */
	@POST
	@Path("/update/{unitNumber}/{unitCode}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Unit updateUnit(Unit unit, @PathParam("unitNumber") int unitNumber, @PathParam("unitCode") int unitCode) {
		Unit newUnit = new Unit();
		newUnit.setUnitCode(unitCode);
		newUnit.setUnitNumber(unitNumber);
		newUnit.setItemList(unit.getItemList());
		return service.updateUnit(unit, newUnit);
	}
	
	@GET
	@Path("/delete/{unitNumber}/{unitCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteUnit(@PathParam("unitNumber") int unitNumber, @PathParam("unitCode") int unitCode){
		Unit unit = new Unit();
		unit.setUnitCode(unitCode);
		unit.setUnitNumber(unitNumber);
		if(service.deleteUnit(unit)) {
			service.deleteUnit(unit);
			return "Succesfuly Deleted";
		}
		return "Something Went Wrong";
	}

}
