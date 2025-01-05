package FIrstPart;

import java.util.ArrayList;
import java.util.List;

public class StudentCounseling implements RetreiveInfoById<StudentCounseling>{
private String dateOfAdmission, choiceOfDepartment, departmentName, studentID, dateOfBirth;

public StudentCounseling(String dateOfAdmission, String choiceOfDepartment, String departmentName, String studentID, String dateOfBirth) {
	this.choiceOfDepartment = choiceOfDepartment;
	this.dateOfAdmission = dateOfAdmission;
	this.departmentName = departmentName;
	this.dateOfBirth = dateOfBirth;
	this.studentID = studentID;
}

public String getDateOfAdmission() {
	return dateOfAdmission;
}
public String getChoiceOfDepartment() {
	return choiceOfDepartment;
}
public String getDepartmentName() {
	return departmentName;
}
public String getStudentID() {
	return studentID;
}
public String getDateOfBirth() {
	return dateOfBirth;
}

@Override
public List<StudentCounseling> retrieveByID(String id, List<StudentCounseling> list) {
	List<StudentCounseling> result = new ArrayList<>();
	for(StudentCounseling studentCounseling: list) {
		if (studentCounseling.getStudentID().equals(id)) {
	      result.add(studentCounseling);
		}
	}
	return result;
}
}