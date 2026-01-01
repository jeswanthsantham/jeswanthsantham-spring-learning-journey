package com.deliveryapp.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Restaurant {
	private String restaurantName;
	@Id
	@GeneratedValue(generator = "rest_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "rest_gen",sequenceName = "restaurant_seq",initialValue = 1,allocationSize = 1)
	private Integer restaurantId;
	
	@Enumerated(EnumType.STRING)
	private Category category; //veg or nonveg
	
	private double ratings;
	
	@OneToOne(cascade = CascadeType.ALL) //save child while saving parent
	@JoinColumn(name = "address_id") // to give a proper column name
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //save child while saving parent
	@JoinColumn(name= "restaurant_id") // restaurant_id added to menu_item table
	private Set<MenuItem> menuItems; 
	
	@ManyToOne
	@JoinColumn(name = "brand_id") // to give a proper column name
    private Brand brand;
	
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="restaurant_cuisine",
	           joinColumns = @JoinColumn(name="restaurant_id"),
			   inverseJoinColumns =@JoinColumn(name="cuisine_id"))
	private Set<Cuisine> cuisines;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="restaurant_serviceType",joinColumns = @JoinColumn(name="restaurant_id"))
	private Set<String> serviceType; //dining,delivery,nightlife

	@Override
	public int hashCode() {
		return Objects.hash(restaurantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(restaurantId, other.restaurantId);
	}
	
	
}














