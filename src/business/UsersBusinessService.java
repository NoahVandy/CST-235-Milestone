package business;

import beans.User;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class UsersBusinessService
 */
@Alternative
@Stateless
@Local(UsersBusinessInterface.class)
public class UsersBusinessService implements UsersBusinessInterface {

	// used temporarily until the database is standing 
	List<User> userList = new ArrayList<User>();
    /**
     * Default constructor. 
     */
    public UsersBusinessService() {
        // TODO Auto-generated constructor stub
    	userList.add(new User("NoahVandy", "1234", "test@test.com", "816-555-0000", 1111));
    	userList.add(new User("JasonStine", "1234", "test@test.com", "816-555-0000", 1112));
    	userList.add(new User("MarkReha", "1234", "test@test.com", "816-555-0000", 1114));
    }

	/**
     * @see UsersBusinessInterface#getUsers()
     */
    public List<User> getUsers() {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see UsersBusinessInterface#authenticateUser(User)
     */
    public User authenticateUser(User login) {
    		// loop to be able to run through the existing users 
			for (User user : userList) 
			{
				// if there is a match between existing users and the tried login and password, it will return a user that gets passed into the controller
				if(login.getUsername().equals(user.getUsername()) && login.getPassword().equals(user.getPassword()))
				{
					System.out.println("Username is: " + user.getUsername() + " Password is: " + user.getPassword());
					return user;
				}
			}
			return null;
			
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
    	for (User user : userList) 
		{
    		// if there is a user with the same username or usercode that someone is trying to create, registration will fail
			if(register.getUsername().equals(user.getUsername()) || register.getUserCode() == user.getUserCode())
			{
				System.out.println("There is already a user with the username: " + register.getUsername());
				return false;
			}
		}
    	// add user that did not match with existing user to the list
    	userList.add(register);
		return true;
    }

}
