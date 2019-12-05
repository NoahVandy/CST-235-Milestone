package business;

import beans.User;
import data.DataAccessInterface;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 * Session Bean implementation class UsersBusinessService
 */
@Alternative
@Stateless
@Local(UsersBusinessInterface.class)
public class UsersBusinessService implements UsersBusinessInterface {

	@Inject
	DataAccessInterface<User> dataService;

	
    /**
     * Default constructor. 
     */
    public UsersBusinessService() {
    }

	/**
     * @see UsersBusinessInterface#getUsers()
     */
    public List<User> getUsers() {
        // TODO Auto-generated method stub
			return dataService.findAll();
    }

	/**
     * @see UsersBusinessInterface#authenticateUser(User)
     */
    public User authenticateUser(User login) {
    	User loginUser = null;
    	// loop to be able to run through the existing users 
    	if(dataService.findBy(login) != null) 
    	{
    		loginUser = dataService.findBy(login);
    	}
		return loginUser;
			
    }

	/**
     * @see UsersBusinessInterface#setUsers(List<User>)
     */
    public void setUsers(List<User> users) {
        // TODO Auto-generated method stub
    }

	/**
	 * going to make sure that two users can't be created with the same username or usercode
     * @see UsersBusinessInterface#authenticateRegistration(User)
     */
    public boolean authenticateRegistration(User register) {
    	// loop to run through existing users
    	for (User user : dataService.findAll()) 
		{
    		// if there is a user with the same username or usercode that someone is trying to create, registration will fail
			if(register.getUsername().equals(user.getUsername()))
			{
				System.out.println("There is already a user with the username: " + register.getUsername());
				return false;
			}
			if(register.getUserCode() == user.getUserCode()) {
				System.out.println("There is already a user with the same usercode: " + register.getUserCode());
				return false;
			}
		}
    	// add user that did not match with existing user to the list
    	dataService.create(register);
		return true;
    }

	public User updateUser(User originalUser, User updatedUser) {
		if(dataService.updateRest(originalUser, updatedUser) == true)
		{
			originalUser = updatedUser;
		}
		else 
		{
			updatedUser = null;
		}
		
		return updatedUser;
	}

	public User findUserbyId(int id) 
	{
		return dataService.findById(id);
	}

}
