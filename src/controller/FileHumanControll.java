package controller;

import java.io.IOException;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Human;

public class FileHumanControll {
	private static final Logger LOG = Logger.getLogger(FileHumanControll.class);
	
	private static final String FILE_NAME = "HumansData";
	private static Path path = Paths.get(FILE_NAME);
	
	public static void createFile() {
		try {
			Files.createFile(path);
		} catch (IOException e) {
			LOG.error("Ошибка - IOException; Methos - createFile; Class - FileHumanControll");
			Dialogs.showErrorDialog("Ошибка при создании файла (IOException)", null);
		}
	}
	
	public static void saveFile(List<Human> list) {
		try {
			OutputStream fileOutputStream = Files.newOutputStream(path);
			ObjectOutputStream objectPutputStream = new ObjectOutputStream(fileOutputStream);
			objectPutputStream.writeObject(new ArrayList<Human>(list));
			objectPutputStream.close();
		} catch (IOException e) {
			LOG.error("Ошибка - IOException; Methos - saveFile; Class - FileHumanControll");
			Dialogs.showErrorDialog("Ошибка во время записи файла (IOException)", null);
		}
	}
	
	public static List<Human> openFile(){
		InputStream fileInputStream;
		try {
			fileInputStream = Files.newInputStream(path);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		List<Human> list = (List<Human>) objectInputStream.readObject();
		return list;
		} catch (ClassNotFoundException e) {
			LOG.error("Ошибка - ClassNotFoundException; Methos - openFile; Class - FileHumanControll");
			return null;
		} catch (IOException e) {
			LOG.error("Ошибка - IOException; Methos - openFile; Class - FileHumanControll");
			return null;
		}
	}
	
}
