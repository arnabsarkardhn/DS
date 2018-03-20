package com.arnab.BST;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.arnab.algos.Employee;
import com.arnab.algos.School;
import com.arnab.algos.Section;

public class ValidatorObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean f1 = false;
		boolean f2 = false;
		System.out.println( f1 & f2);
		
		Section s1 = new Section("A");
		Section s2 = new Section("B");
		List<Section> lstSec = new ArrayList<Section>(); lstSec.add(s1); lstSec.add(s2);
		School sc1 = new School("1", "De", s1);
		School sc2 = new School("2", "DeX", s1);
		School sc3 = new School("3", "DeN", s2);
		List<School> lstSch = new ArrayList<School>();
		lstSch.add(sc1); lstSch.add(sc2); lstSch.add(sc3);
		Employee emp = new Employee("123", sc1);
		
		String path = "school/section/secNo";
		System.out.println(listOf(path, emp));
		
	}
	
	public static Object listOf(String path, Employee emp) {
		Object obj = emp;
		Queue<String> queue = new PriorityQueue<String>();
		String splits[] = path.split("/");
		for(String token : splits) {
			obj = getPropertyValue(obj, token);
		}
		return obj;
	}
	
	public static <T> T getPropertyValue(final T object, final String fieldName) {
		Object value = null;
		try{
			Class<?> c = object.getClass();
			Field f = c.getDeclaredField(fieldName);
			f.setAccessible(true);
			value = f.get(object);
		} catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		}
		return (T) value;
	}
	
}

class Employee {
	private String id;
	private School school;
	Employee(String p, School p1) {
		id = p; school = p1; 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
}
class School {
	private String scId;
	private String scName;
	private Section section;
	/*private List<Section> section;
	School(String p, String p1, List<Section> sec) {
		scId = p; scId = p1; section = sec;
	}*/
	School(String p, String p1, Section sec) {
		scId = p; scId = p1; section = sec;
	}
	public String getScId() { 
		return scId;
	}
	public void setScId(String scId) {
		this.scId = scId;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	/*public List<Section> getSection() {
		return section;
	}
	public void setSection(List<Section> section) {
		this.section = section;
	}*/
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
}
class Section {
	private String secNo;
	Section(String sec) {
		secNo = sec;
	}
	public String getSecNo() {
		return secNo;
	}
	public void setSecNo(String secNo) {
		this.secNo = secNo;
	}
	
}

