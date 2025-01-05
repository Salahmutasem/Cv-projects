package FIrstPart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person {
    private String dateOfAdmission, departmentName;
    private StudentCounseling studentcouns;
    private List<StudentPerfromance> studentPerformances;

    public Student(List<StudentPerfromance> studentPerformances, String dateOfAdmission, String departmentName, String iD, String dateOfBirth, StudentCounseling studentcouns) {
        super(iD, dateOfBirth);
        this.dateOfAdmission = dateOfAdmission;
        this.departmentName = departmentName;
        this.studentcouns = studentcouns;
        this.studentPerformances = studentPerformances;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public StudentCounseling getStudentCounseling() {
        return studentcouns;
    }

    public List<StudentPerfromance> getStudentPerformances() {
        return studentPerformances;
    }

    public int getNumberOfPapers() {
        return studentPerformances.size();
    }

    public int getNumberOfSemesters() {
        List<String> semesters = new ArrayList<>();
        for (StudentPerfromance sp : studentPerformances) {
            if (!semesters.contains(sp.getSemesterID())) {
                semesters.add(sp.getSemesterID());
            }
        }
        return semesters.size();
    }

    public double getAverageMarks() {
        if (studentPerformances.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (StudentPerfromance sp : studentPerformances) {
            total += sp.getMarks();
        }
        return total / studentPerformances.size();
    }

    public double getTotalMarks() {
        double total = 0;
        for (StudentPerfromance sp : studentPerformances) {
            total += sp.getMarks();
        }
        return total;
    }

    public double getMaxMarks() {
        if (studentPerformances.isEmpty()) {
            return Double.NaN;
        }
        double max = studentPerformances.get(0).getMarks();
        for (StudentPerfromance sp : studentPerformances) {
            if (sp.getMarks() > max) {
                max = sp.getMarks();
            }
        }
        return max;
    }

    public double getMinMarks() {
        if (studentPerformances.isEmpty()) {
            return Double.NaN;
        }
        double min = studentPerformances.get(0).getMarks();
        for (StudentPerfromance sp : studentPerformances) {
            if (sp.getMarks() < min) {
                min = sp.getMarks();
            }
        }
        return min;
    }

    public void printStatistics() {
        System.out.println("Number of Papers: " + getNumberOfPapers());
        System.out.println("Number of Semesters: " + getNumberOfSemesters());
        System.out.println("Average Marks: " + getAverageMarks());
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Max Marks: " + getMaxMarks());
        System.out.println("Min Marks: " + getMinMarks());
    }
    public static List<Student> retrieveStudentsByCriteria(List<Student> students, String departmentName, String dobStart, String dobEnd, String doaStart, String doaEnd) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Student> result = new ArrayList<>();
        try {
            Date dobStartDate = dateFormat.parse(dobStart);
            Date dobEndDate = dateFormat.parse(dobEnd);
            Date doaStartDate = dateFormat.parse(doaStart);
            Date doaEndDate = dateFormat.parse(doaEnd);

            for (Student student : students) {
                
                if (student.getDob().equals("DOB") || student.getDateOfAdmission().equals("DOA")) {
                    continue;
                }

                Date studentDob = dateFormat.parse(student.getDob());
                Date studentDoa = dateFormat.parse(student.getDateOfAdmission());
                if (student.getDepartmentName().equals(departmentName) && 
                    !studentDob.before(dobStartDate) && !studentDob.after(dobEndDate) && 
                    !studentDoa.before(doaStartDate) && !studentDoa.after(doaEndDate)) {
                    result.add(student);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
