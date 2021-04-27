package com.hitsa.fleetmgmt.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String capital;
	private String description;
	private String nationality;
	private String continent;
	
	// one country and many states so OneToMany annotation.
	@OneToMany(mappedBy="country")
	// in state class we already did join. so mappedBy is telling hibernate that after join operation done 
	// and in the result of join operation we have to map each state with the country that it belongs to.
	//mappedBy parameter is used to indicate that the given column is owned by another entity.
	// here the owner Entity is state which has a join column "countryid" that stores the id value and has a 
	// foreign key to the Country Entity.
	private List<State> states;
}