package FIrstPart;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements RetreiveInfoById<Employee>{
private String dateOfJoining, departmentID;

public Employee (String iD, String dateOfBirth, String dateOfJoining, String departmentID)  {
	super(iD, dateOfBirth);
	
	this.dateOfJoining = dateOfJoining;
	this.departmentID = departmentID;
}
public String getDateJoining() {
	return dateOfJoining;
}
public String getDepartmentID() {
	return departmentID;
}
@Override
public List<Employee>retrieveByID(String id, List<Employee> list) {
	List<Employee> result = new ArrayList<>();
	for(Employee employee: list) {
		if (employee.getId().equals(id)) {
		 result.add(employee);
		}
	}
	return result;
}
}