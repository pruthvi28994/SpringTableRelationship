package com.pruthvi.relations.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruthvi.relations.entity.Employee;

/**
 * @author pruthvi
 */
@Repository
public interface EmployeeRepositoy extends JpaRepository<Employee, Integer> {

	//Fetches all Employee with Given Email ID
	Optional<Employee> findByEmail(String email);
	
	//Fetches all Employee who does'nt belongs to given Department ID and Order by Ascending Order
	Optional<List<Employee>> findByDepartmentIdNotOrderByIdAsc(Integer departmentId);
	
	
	//Fetche all Employess who DOB is greater than Given DOB and by Given Gender
	Optional<List<Employee>> findByGenderAndDobGreaterThanOrderByIdDesc(String gender,Integer dob);
	
	
	//Count By Department ID
	Integer countByDepartmentId(Integer departmentId);
	
	
	//Custom Query using NameParameter Template
	@Query(value = "SELECT DOB FROM EMPLOYEE WHERE EMAIL = :email AND DEPARTMENTID = :departmentId",nativeQuery = true)
	Integer getDOBbyEmployeeWithEmailAndDepartmentId(@Param("email") String email,@Param("departmentId") Integer departmentId);

	@Query(value = "SELECT PROJECT_ID FROM EMPLOYEE_PROJECTS WHERE EMPLOYEE_ID = :employeeId",nativeQuery = true)
	List<Integer> getProjectIdForGivenEmployee(@Param("employeeId") Integer employeeId);
}
