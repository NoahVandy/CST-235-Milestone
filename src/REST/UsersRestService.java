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

import beans.User;
import business.UsersBusinessInterface;

@RequestScoped
@Path("/user")
public class UsersRestService {

	@Inject
	UsersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersAsJson(){
		return service.getUsers();
	}
	
	@GET
	@Path("/get/{username}/{password}/{email}/{phonenumber}/{usercode}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("phonenumber") int phoneNumber, @PathParam("usercode") int userCode) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setUserCode(userCode);
		return user;
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User saveUser(User user) {
		service.authenticateRegistration(user);
		return user;
	}
	
	@POST
	@Path("/update/{usercode}/{username}/{password}/{email}/{phonenumber}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user, @PathParam("usercode") int usercode, @PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("phonenumber") int phoneNumber) {
		User newUser = new User();
		newUser.setUserCode(usercode);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setPhoneNumber(phoneNumber);
		// TODO: add method to update user!!
		User updatedUser = service.updateUser(user, newUser);
		return updatedUser;
	}
	
	@GET
	@Path("/delete/{username}/{password}/{email}/{phonenumber}/{usercode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("phonenumber") int phoneNumber, @PathParam("usercode") int userCode){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setUserCode(userCode);
		// TODO: add method to delete user!!
		return "Logic to Come!";
	}

}