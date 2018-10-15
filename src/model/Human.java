package model;

import java.io.Serializable;
import java.util.Date;

public class Human implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 564369494421213575L;
	
	private String name;
	private int age;
	private Date dirhtday;

	public Human(String name, int age, Date dirhtday) {
		setName(name);
		setAge(age);
		setDirhtday(dirhtday);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDirhtday() {
		return dirhtday;
	}

	public void setDirhtday(Date dirhtday) {
		this.dirhtday = dirhtday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dirhtday == null) ? 0 : dirhtday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (dirhtday == null) {
			if (other.dirhtday != null)
				return false;
		} else if (!dirhtday.equals(other.dirhtday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
