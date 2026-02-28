package com.assignment.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserServiceTest {
	private UserService service;
	
	@BeforeEach
	void init() {
		service  = new UserService();
	}
	
	@ParameterizedTest
	@CsvSource(
			value = {"null, user123", ", user123"},
			nullValues = "null"
			)
	public void shouldThrowUserNameException(String username, String password) {
		assertThrows(UserNameCannotBeNullException.class, ()->{
			service.registerUser(username, password);
		});
	}
	
	@ParameterizedTest
	@CsvSource({"Abhinav, user123", "Rohan, rohan1"})
	public void shouldThrowExceptionForWeakPassword(String username, String password) {
		assertThrows(PasswordDoesntMatched.class, ()->{
			service.registerUser(username, password);
		});
	}
	
	@ParameterizedTest
	@CsvSource({"Abhinav1501, @Bhinav1525", "Rohan111, Roh@n111"})
	public void shouldAcceptTheRegistration(String username, String password) {
		assertAll("Valid user registration",
	            () -> assertDoesNotThrow(() -> service.registerUser(username, password)),
	            () -> assertTrue(password.length() >= 8),
	            () -> assertFalse(username.isBlank())
	        );
	}
}
