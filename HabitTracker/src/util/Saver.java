package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saver<E> {
	public static <E extends Serializable> void saveClass(E object) {
		try (FileOutputStream fout = new FileOutputStream(Names.getName()); ObjectOutputStream oos = new ObjectOutputStream(fout)){
			oos.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
