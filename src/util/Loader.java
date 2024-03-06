package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Loader<E> {
	public static <E> E loadFile() throws Exception{
		try (FileInputStream streamIn = new FileInputStream(Names.getName()); ObjectInputStream objectinputstream = new ObjectInputStream(streamIn)){
			return (E) objectinputstream.readObject();
		} 
		catch (FileNotFoundException e1) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new Exception("File does not exist");
	}
}
