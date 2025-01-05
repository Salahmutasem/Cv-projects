package FIrstPart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Loader {
	
public List<Department> loadeDeprtemnt() {
	List<Department> departments = new  ArrayList<>();
	//List<String> lines = new  ArrayList<>();
	BufferedReader reader;
	try {
		reader =new BufferedReader(new FileReader("//Users//salahmutasem//Desktop//data set//Department_Information.txt"));
		String line = reader.readLine();
		
		while (line != null) {
			String[] parts = line.split("\\|");
			if (parts.length >= 3) {
				String departmentID =parts[0];
				String departmentName = parts[1];
				String departmentEstablishmentDate = parts[2].split("T")[0];
				Department department = new Department(departmentID, departmentName, departmentEstablishmentDate); 
				departments.add(department);
			}
			
			//lines.add(line);
			//System.out.println(line);
			line = reader.readLine();
			
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return departments;
}

public List<StudentCounseling> loadStudentCouns() {
	List<StudentCounseling> studentCounselingList = new  ArrayList<>();
	BufferedReader reader;
	try {
		reader =new BufferedReader(new FileReader("//Users//salahmutasem//Desktop//data set//Student_Counceling_Information.txt"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split("\\|");
			if (parts.length >=5) {
				String studentID = parts[0];
				String dateOfAdmission = parts[1].split("T")[0];
				String dateofBirth = parts[2].split("T")[0];
				String choiceOfDepartment = parts[3];
				String departmentName = parts[4];
				StudentCounseling studentCounseling = new StudentCounseling(dateOfAdmission, choiceOfDepartment,departmentName, studentID, dateofBirth);
				studentCounselingList.add(studentCounseling);
				
			}
			line = reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return studentCounselingList;
}

public List<Employee> loadEmployees() {
	
	List<Employee> employeeList = new  ArrayList<>();
	BufferedReader reader;
	try {
		reader =new BufferedReader(new FileReader("/Users/salahmutasem/Desktop/data set/Employee_Information.txt"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split("\\|");
			if (parts.length >= 4) {
				String employeeID = parts[0];
				String dateOfBirth = parts[1].split("T")[0];
				String dateOfJoining = parts[2].split("T")[0];
				String departmentID = parts[3];
				Employee employee = new Employee(employeeID, dateOfBirth, dateOfJoining, departmentID);
				employeeList.add(employee);
			}
			
			line = reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return employeeList;
}

public List<StudentPerfromance> loadStudentPerformance() {
	List<StudentPerfromance> StudentPerfromacnceList = new  ArrayList<>();
	
	BufferedReader reader;
	try {
		reader =new BufferedReader(new FileReader("/Users/salahmutasem/Desktop/data set/Student_Performance_Data.txt"));
		String line = reader.readLine();
		 if (line != null && line.contains("Marks")) {
             line = reader.readLine();
         }
		
		while (line != null) {
			String[] parts = line.split("\\|");
			if(parts.length >= 5) {
				String studentID = parts[0];
				String semesterID = parts[1];
				String paperID = parts[2];
				String paperName = parts[3];
				double marks = Double.parseDouble(parts[4]);
				StudentPerfromance studentPerfromacne = new StudentPerfromance(studentID, semesterID, paperID, paperName, marks);
				StudentPerfromacnceList.add(studentPerfromacne);
			}
			//System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return StudentPerfromacnceList;
}
}