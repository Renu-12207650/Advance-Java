package com.assignment.day1;

public class UserService {
	public void registerUser(String username, String password) throws UserNameCannotBeNullException, PasswordDoesntMatched {
		if(username == null || username.equals("")) {
			throw new UserNameCannotBeNullException("Username cannot be null or blank");
		}
		
		if(password.length() < 8 ) {
			throw new PasswordDoesntMatched("Length must be more than 8");
		}
		
		System.out.println("User registerd successfully");
	}
}

class UserNameCannotBeNullException extends Exception{
	public UserNameCannotBeNullException(String message) {
		super(message);
	}
}

class PasswordDoesntMatched extends Exception{
	public PasswordDoesntMatched(String message) {
		super(message);
	}
}