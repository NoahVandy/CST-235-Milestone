package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import business.UnitBusinessInterface;


@ManagedBean 
@ViewScoped
public class unitController {

	@Inject
	UnitBusinessInterface service;
	
	public UnitBusinessInterface getService() {
		return service;
	}
	
}
