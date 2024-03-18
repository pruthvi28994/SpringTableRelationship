package com.pruthvi.relations.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruthvi.relations.entity.Address;

import jakarta.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	
	/**
	 * Pagable can be used for Pagination functionality
	 * LIKE clause can be created in different ways
	 * %{value}% -> contains , Containing , isContaining , Like
	 * NOTE When LIke is used even wild card '%' should be sent within parameter
	 * '{Value}% -> StartsWith
	 * '%{Value} -> EndsWith
	 * 
	 */
	
    //Retrieve all Address whose state is Like
	List<Address> findByStateLikeIgnoringCase(String state);
	
	//Retrieve all Address which City starts with And State which ends with Ignoring case
	List<Address> findByCityStartsWithIgnoringCaseAndStateEndsWithIgnoringCase(String city,String state);
	
	
	//Retrieve all Address whose state is not Like
	List<Address> findByStateNotContaining(String state);
	
	List<Address> findByCountryNotContains(String country);
	
	
	//IN Clause
	List<Address> findByStateIn(List<String> states);

	/**
	 * Custom Update When Object is passed as request Param
	 * {@link entityName} will auto-maps Entity Name
	 * @param address
	 * @return
	 */
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying(flushAutomatically = true)
	@Query(value = "UPDATE #{#entityName} SET ADDRESSLINEONE = :#{#address.addressLineOne}, CITY = :#{#address.city} WHERE ID = :#{#address.id} "
			+ "AND STATE = :#{#address.state}",nativeQuery = true)
	public Integer updateAddressDetails(@Param(value = "address") Address address);
}
