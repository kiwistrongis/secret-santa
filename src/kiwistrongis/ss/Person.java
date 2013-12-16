package kiwistrongis.ss;

public class Person {
	public String name;
	public String email;
	public Person santa = null;
	public Person santee = null;

	public Person( String name, String email){
		this.name = name;
		this.email = email;}

	public void setSanta( Person other){
		this.santa = other;
		other.santee = this;}

	public String toString(){
		return String.format( "{%s,%s}->%s",
			name, email, santa==null? "null" : santa.name);}
}