package business;

import java.util.List;

import beans.User;

public interface UsersBusinessInterface {

	/**
	 * takes in a user that is trying to login and and verifies that the attemped username and password are in the system already
	 * @param login
	 * @return
	 */
	public User authenticateUser(User login);
	/**
	 * takes in a new user's information and will check if the username and usercode are already used to verify that there can't be two of the same users with that 	username and password
	 * @param registration
	 * @return
	 */
	public boolean authenticateRegistration(User registration);
	public List<User> getUsers();
	public void setUsers(List<User> users);
	public User updateUser(User originalUser, User updatedUser);
	public User findUserbyId(int id);
}
