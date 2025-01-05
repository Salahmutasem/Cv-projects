package FIrstPart;
import java.util.ArrayList;
import java.util.List;

public class Department implements RetreiveInfoById<Department>{
private String departmentID, departmentName, deprtmentEstablishDate;

public Department(String departmentID, String departmentName, String deprtmentEstablishDate) {
	this.departmentID = departmentID; 
	this.departmentName = departmentName;
	this.deprtmentEstablishDate = deprtmentEstablishDate;
}

public String getDepartmentID() {
	return departmentID;
}
public String getDepartmentName() {
	return departmentName;
}
public String getDeprtmentEstablishDate() {
	return deprtmentEstablishDate;
}

public void setDepartmentID(String departmentID) {
	this.departmentID = departmentID;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public void setDeprtmentEstablishDate(String deprtmentEstablishDate) {
	this.deprtmentEstablishDate = deprtmentEstablishDate;
}

@Override
public List<Department> retrieveByID(String id, List<Department> list) {
	List<Department> result = new ArrayList<>();
	for(Department department : list) {
		if (department.getDepartmentID().equals(id)) {
			result.add(department);
		}
	}
	return result;
}
public int getNumberOfEmployee(List<Employee> employees) {
	int count = 0;
	for(Employee employee : employees) {
		if (employee.getDepartmentID().equals(this.departmentID)) {
			count++;
		}
	}
	return count;
}
public int getNumberOfStudents(List<Student> students) {
	int count = 0 ;
	for (Student student : students) {
		if (student.getDepartmentName().equals(this.departmentName)) {
			count++;
		}
	}
	return count;
}
public void printStatistics(List<Employee> employees, List<Student> students) {
	System.out.println("Department ID: " + this.departmentID);
	System.out.println("Department Name: " + this.departmentName);
	System.out.println("Number of Employees: " + getNumberOfEmployee(employees));
	System.out.println("Number of students: " + getNumberOfStudents(students));
}
public void printDepartmentInfo(List<Employee> employees, List<Student> students) {
    System.out.println("Department ID: " + this.departmentID);
    System.out.println("Department Name: " + this.departmentName);
    System.out.println("Department Establish Date: " + this.deprtmentEstablishDate);

    System.out.println("\nEmployees in this Department:");
    for (Employee employee : employees) {
        if (employee.getDepartmentID().equals(this.departmentID)) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("Date of Joining: " + employee.getDateJoining());
            System.out.println("//////////");
        }
    }
    System.out.println("\nStudents in this Department:");
    for (Student student : students) {
        if (student.getDepartmentName().equals(this.departmentName)) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Date of Birth: " + student.getDob());
            System.out.println("Date of Admission: " + student.getDateOfAdmission());
            System.out.println("Student Counseling: " + student.getStudentCounseling().getChoiceOfDepartment());
            System.out.println("///////////////");
        }
    }
}

}