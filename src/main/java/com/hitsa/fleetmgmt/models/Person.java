package com.hitsa.fleetmgmt.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
// mapped super class tells that this class will be inherited by other classes and this class is not used for
// instantiate purpose (objects should not be created from these classes to avoid redundancy because objects of 
// sub-classes can easily use methods and properties of this class);
public class Person {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String othername;
	private String title;
	private String initials;
	private String socialSecurityNumber;
	private String gender;
	private String maritalStatus;
	
	// many person one country.
	/**person is owner of country entity so it's columns are acquired by foreign key countryid. */
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Integer countryid;
	
	/**person is owner of state entity so it's columns are acquired by foreign key stateid. */
	/** observe that we have not used mappedBy in state class as we done in country class. Because we dont want
	 * list of states. In country class we want list of states so country is mapped to state.
	 * If we want to map each person with the state that it belongs then we can do by usin mappedBy("state") in
	 * state class.
	 */
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;
	private Integer stateid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
}
