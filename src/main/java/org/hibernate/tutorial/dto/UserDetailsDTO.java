package org.hibernate.tutorial.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

//If we use only @Entity then the default name will be class name.
//But if we use this then the default name will be this ati instead of class name.
@Entity(name = "ati")
// This name should be exact table name present in database
@Table(name = "users")
// We can use this here or can put this on getUserId() column.
// @GenericGenerator(name = "SEQ", strategy = "increment")
public class UserDetailsDTO implements Serializable {

	private Long userId;
	private String userName;
	private Set<AddressDTO> listOfAddresses = new HashSet<>();

	// This will be saved as different columns
	// in the database.
	// @EmbeddedId
	// private AddressDTO addressDTO;

	public UserDetailsDTO() {
	}

	// @GeneratedValue(generator = "SEQ")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * public AddressDTO getAddressDTO() { return addressDTO; }
	 * 
	 * public void setAddressDTO(AddressDTO addressDTO) { this.addressDTO =
	 * addressDTO; }
	 */

	// For lazy and eager fetch on collections.
	// @ElementCollection(fetch = FetchType.LAZY)
	@ElementCollection()
	@JoinTable(name = "User_Addresses", joinColumns = @JoinColumn(name = "USER_ID"))
	public Set<AddressDTO> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<AddressDTO> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
}
