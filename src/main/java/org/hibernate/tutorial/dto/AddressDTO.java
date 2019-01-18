package org.hibernate.tutorial.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressDTO implements Serializable {

	private String city;
	private String houseNo;
/*	private String state;
	private String colonyName;
*/
	public AddressDTO() {
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

/*	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "COLONY_NAME")
	public String getColonyName() {
		return colonyName;
	}

	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}*/
}
