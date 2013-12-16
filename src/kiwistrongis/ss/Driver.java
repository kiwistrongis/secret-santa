package kiwistrongis.ss;

//standard library imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;

//javax.mail imports
import javax.mail.MessagingException;

//secret santa program
public class Driver {
	public static void main( String [] args){
		//setup mail server
		Mailer mailer = new Mailer();
		//setup logger
		File logfile = new File( "error.log");
		if( logfile.exists())
			logfile.delete();
		PrintWriter errorlog;
		try { errorlog = new PrintWriter( logfile);}
		catch( FileNotFoundException exception){
			errorlog = new PrintWriter( System.out);}

		//load data file
		File datafile = new File( "data/responses.csv");
		Data data = null;
		try{ data = new Data( datafile);}
		catch( FileNotFoundException exception){
			errorlog.println( exception.getStackTrace());
			throw new RuntimeException(
				"Critical failure - datafile load failed",
				exception);}

		Random random = new Random( System.currentTimeMillis());
		Vector<Person> source = new Vector<Person>(
			data.people);}

		/*for( Person person : data.people){
			Person santa = person;
			if( source.size() == 1){
				santa = source.get( 0);
				if( santa == person){
					for( Person other : data.people)
						if( other != person && 
			while( santa != person)
				santa = source.get(
					random.nextInt( source.size()));*/

		//record information


		/*//setup content
		String to = "kalev.sikes@gmail.com";
		String content = "hello there";

		try{
			if( false) mailer.send( to, content);}
		catch ( MessagingException exception) {
			errorlog.println( exception.getStackTrace());}}*/
}