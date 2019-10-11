package business;

import java.util.List;

import beans.User;

public interface UsersBusinessInterface {

	public User authenticateUser(User login);
	public boolean authenticateRegistration(User registration);
	public List<User> getUsers();
	public void setUsers(List<User> users);
}
