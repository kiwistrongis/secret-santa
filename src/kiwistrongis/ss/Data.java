package kiwistrongis.ss;

//standard library imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Data {
	public Vector<Person> people;

	public Data( File datafile)
			throws FileNotFoundException {
		Scanner in = new Scanner( datafile);
		in.nextLine();
		people = new Vector<Person>();

		while( in.hasNextLine()){
			//get line info
			String line = in.nextLine();
			int first = line.indexOf(',') + 1;
			int last = line.lastIndexOf(',');

			//extract email
			String email = line.substring( last + 1);

			//extract name
			boolean quotations =
				line.charAt( first) == '"' &&
				line.charAt( last - 1 ) == '"';
			if( quotations){
				first++;
				last--;}
			String name = line.substring( first, last);

			//add entry
			people.add( new Person( name, email));}}
}