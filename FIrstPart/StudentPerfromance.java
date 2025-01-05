package FIrstPart;

import java.util.List;
import java.util.ArrayList;
public class StudentPerfromance  implements RetreiveInfoById<StudentPerfromance> {
private String studntId, semesterID, paperID, paperName;
private double marks; 

public StudentPerfromance(String studntId, String semesterID, String paperID, String paperName, double marks) {
	this.marks = marks;
	this.paperID = paperID;
	this.paperName = paperName;
	this.semesterID = semesterID;
	this.studntId = studntId;
}
public String getStudntId() {
	return studntId;
}
public String getSemesterID() {
	return semesterID;
}
public String getPaperID() {
	return paperID;
}
public String getPaperName() {
	return paperName;
}
public double getMarks() {
	return marks;
}
@Override
public List<StudentPerfromance> retrieveByID(String id, List<StudentPerfromance> list) {
	List<StudentPerfromance> perfromances = new ArrayList<>();
	for (StudentPerfromance performance: list) {
		if (performance.getStudntId().equals(id)) {
			perfromances.add(performance);
		}
	}
	return perfromances;
}
}