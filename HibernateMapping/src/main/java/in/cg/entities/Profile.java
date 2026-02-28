package in.cg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String profileNumber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfileNumber() {
		return profileNumber;
	}
	public void setProfileNumber(String profileNumber) {
		this.profileNumber = profileNumber;
	}
	
	
}
