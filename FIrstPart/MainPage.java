package FIrstPart;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainPage {

	public static void main(String[] args) {
		
		
		        Loader loader = new Loader();
		        List<Department> departments = loader.loadeDeprtemnt();
             	List<StudentCounseling> studentCounselingList = loader.loadStudentCouns();
		    	List<StudentPerfromance> studentPerfromanceList = loader.loadStudentPerformance();
		    	List<Employee> employeeList = loader.loadEmployees();
		    	List<Student> studentList = createStudents(studentCounselingList, studentPerfromanceList);
		        Scanner input = new Scanner(System.in);

		        System.out.println("The following are the operations that you may use in this system");
		        System.out.println("Write the number of the operation that you want to do");

		        System.out.println("1) Retrieve the information based on ID");
		        System.out.println("2) Retrieve the information Of specific student based on Department, Date of birth and date of admission");
		        System.out.println("3) Perform statistical operation on student performance such as average and so on.");
		        System.out.println("4) Number of employee or student in the department.");
		        System.out.println("5) Retrieve student info and employee info belonging to a specific department.");

		        int num = input.nextInt();
		        input.nextLine();  

		switch(num)
		{
		case 1:
			Scanner input2 = new Scanner(System.in);
			System.out.println("Please enter the number of the operation that you want to apply");
			System.out.println("1) You want to retrieve department information");
			System.out.println("2) You want to retrieve student counseling information");
			System.out.println("3) You want to retrieve employee information");
			System.out.println("4) You want to retrieve student performance information");
			
			
			int num2 = input2.nextInt();
			    switch(num2) {
			    case 1:
			    	System.out.println("Please enter the Department ID:");
	                String departmentId = input.nextLine();
	                List<Department> departmentList = new Department("","","").retrieveByID(departmentId, departments);
	                if (!departmentList.isEmpty()) {
	                	Department department = departmentList.get(0);
	                    System.out.println("Department ID: " + department.getDepartmentID());
	                    System.out.println("Department Name: " + department.getDepartmentName());
	                    System.out.println("Department Establish Date: " + department.getDeprtmentEstablishDate());
	                } else {
	                    System.out.println("No department found with ID: " + departmentId);
	                }
			    	break;
			    case 2:
			    	System.out.println("Please enter the student Id");
			    	String studentId = input.nextLine();
			    	List<StudentCounseling> studentCounselingListResult = new StudentCounseling("","","", "", "").retrieveByID(studentId, studentCounselingList);
			    	if (!studentCounselingListResult.isEmpty()) {
			    		StudentCounseling studentCounseling = studentCounselingListResult.get(0);
			    		System.out.println("Student ID: " + studentCounseling.getStudentID());
			    		System.out.println("Date of Admission: " +studentCounseling.getStudentID());
			    		System.out.println("Dtae of Birth: " + studentCounseling.getDateOfBirth());
			    		System.out.println("choice of Department: " + studentCounseling.getChoiceOfDepartment());
			    		System.out.println("Department Name : " + studentCounseling.getDepartmentName());
			    	} else {
			    		System.out.println("No student counseling found with ID: " +studentId);
			    	}
		
			    break;
			    case 3:
			    	System.out.println("Please enter the employee id:");
			    	String employeeId = input.nextLine();
			    	 List<Employee> employeeListResult = new Employee("", "", "", "").retrieveByID(employeeId, employeeList);
			    	if (!employeeListResult.isEmpty()) {
			    		Employee employee = employeeListResult.get(0);
			    		System.out.println("Employee ID: " + employee.getId());
			    		System.out.println("Date of Birth: " + employee.getDob());
			    		System.out.println("Date of joining :" + employee.getDepartmentID());
			    		System.out.println("Department ID: "+ employee.getDepartmentID());	
			    	} else {
			    		System.out.println("No employee found with ID:" +employeeId);
			    	}
			    break;
			    case 4:
			    System.out.println("Please enter the student ID: ");
			    String studentPerfromanceId = input.nextLine();
			    List<StudentPerfromance>  studentPerformances = new StudentPerfromance("","","", "", 0).retrieveByID(studentPerfromanceId, studentPerfromanceList);
			    if(!studentPerformances.isEmpty()) {
			    
			   for(StudentPerfromance studentPerformance : studentPerformances) {
				  System.out.println("Student ID: " + studentPerformance.getStudntId()); 
				  System.out.println("Semester ID: " + studentPerformance.getSemesterID());
				  System.out.println("paper ID: " + studentPerformance.getPaperID());
				  System.out.println("Paper Name: " + studentPerformance.getPaperName());
				  System.out.println("Marks: " + studentPerformance.getMarks());
				  System.out.println("///////////////////");
			   }
			    }
			     else {
			    	System.out.println("No student perofrmance found with ID: " + studentPerfromanceId);
			    }
			    	break;
			    	default: 
			    		System.out.println("Invalid entry");
			    }
			break;
		case 2: 
		    System.out.println("Please enter the Department Name:");
		    String departmentName = input.nextLine();
		    System.out.println("Please enter the Date of Birth Start Range (yyyy-MM-dd):");
		    String dobStart = input.nextLine();
		    System.out.println("Please enter the Date of Birth End Range (yyyy-MM-dd):");
		    String dobEnd = input.nextLine();
		    System.out.println("Please enter the Date of Admission Start Range (yyyy-MM-dd):");
		    String doaStart = input.nextLine();
		    System.out.println("Please enter the Date of Admission End Range (yyyy-MM-dd):");
		    String doaEnd = input.nextLine();

		    List<Student> filteredStudents = Student.retrieveStudentsByCriteria(studentList, departmentName, dobStart, dobEnd, doaStart, doaEnd);
		    if (!filteredStudents.isEmpty()) {
		        for (Student student : filteredStudents) {
		            System.out.println("Student ID: " + student.getId());
		            System.out.println("Date of Birth: " + student.getDob());
		            System.out.println("Date of Admission: " + student.getDateOfAdmission());
		            System.out.println("Department Name: " + student.getDepartmentName());
		            System.out.println("Student Counseling: " + student.getStudentCounseling().getChoiceOfDepartment());
		            System.out.println("-------------------------");
		        }
		    } else {
		        System.out.println("No students found with the given criteria.");
		    }
			break;
		case 3:
			 System.out.println("Enter the student ID to perform statistical operations:");
			    String studentIdForStats = input.nextLine();
			    List<StudentPerfromance> studentPerformancesForStats = new StudentPerfromance("", "", "", "", 0).retrieveByID(studentIdForStats, studentPerfromanceList);
			    if (!studentPerformancesForStats.isEmpty()) {
			        Student student = new Student(studentPerformancesForStats, "", "", studentIdForStats, "", null);
			        student.printStatistics();
			    } else {
			        System.out.println("No student performance found with ID: " + studentIdForStats);
			    }
		break;
		
    case 4: 
    	 System.out.println("Please enter the Department ID:");
    	    String departmentIdForStats = input.nextLine();
    	    List<Department> departmentListForStats = new Department("", "", "").retrieveByID(departmentIdForStats, departments);
    	    if (!departmentListForStats.isEmpty()) {
    	        Department department = departmentListForStats.get(0);
    	        department.printStatistics(employeeList, createStudents(studentCounselingList, studentPerfromanceList));
    	    } else {
    	        System.out.println("No department found with ID: " + departmentIdForStats);
    	    }
	break;
	
    case 5: 
    	  System.out.println("Please enter the Department ID:");
    	    String departmentIdForInfo = input.nextLine();
    	    List<Department> departmentListForInfo = new Department("", "", "").retrieveByID(departmentIdForInfo, departments);
    	    if (!departmentListForInfo.isEmpty()) {
    	        Department department = departmentListForInfo.get(0);
    	        department.printDepartmentInfo(employeeList, studentList);
    	    } else {
    	        System.out.println("No department found with this ID.");
    	    }
    	break;
		}
		
		input.close();
		}
	private static List<Student> createStudents(List<StudentCounseling> studentCounselingList, List<StudentPerfromance> studentPerformanceList) {
	    List<Student> students = new ArrayList<>();
	    for (StudentCounseling sc : studentCounselingList) {
	        List<StudentPerfromance> studentPerformances = new ArrayList<>();
	        for (StudentPerfromance sp : studentPerformanceList) {
	            if (sp.getStudntId().equals(sc.getStudentID())) {
	                studentPerformances.add(sp);
	            }
	        }
	        Student student = new Student(studentPerformances, sc.getDateOfAdmission(), sc.getDepartmentName(), sc.getStudentID(), sc.getDateOfBirth(), sc);
	        students.add(student);
	    }
	    return students;
	}
}
	
