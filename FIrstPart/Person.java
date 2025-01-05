package FIrstPart;

public class Person {
private String iD, dateOfBirth;

public Person(String iD, String dateOfBirth) {
	this.dateOfBirth= dateOfBirth;
	this.iD = iD;
}

public String getId() {
	return iD;
}
public String getDob() {
	return dateOfBirth;
}

}