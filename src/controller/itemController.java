package controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.ItemBusinessInterface;

@ManagedBean
@ViewScoped
public class itemController {

	@Inject
	ItemBusinessInterface service;
	
	public ItemBusinessInterface getService() {
		return service;
		
		

	}
}

