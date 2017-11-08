package com.arnab.algos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ExtractObjectPropertyRecursively {

	
	public static <T> void main(String[] args) {
		
		try{
		
		String s = new String("hello");
		s.substring(0, 20);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

		boolean f1 = false;
		boolean f2 = false;
		System.out.println( f1 & f2);
		SubSection sub1 = new SubSection("SUB1");
		SubSection sub2 = new SubSection("SUB2");
		List<SubSection> subl = new ArrayList<SubSection>(); subl.add(sub1); 
		List<SubSection> subl2 = new ArrayList<SubSection>(); subl2.add(sub2); subl2.add(sub1);
		Section s1 = new Section("ABC", subl);
		Section s2 = new Section("BCD", subl);
		Section s3 = new Section("ABC3", subl);
		Section s4 = new Section("ABC4", subl2);
		List<Section> lstSec = new ArrayList<Section>(); lstSec.add(s1); lstSec.add(s2);
		List<Section> lstSec1 = new ArrayList<Section>(); lstSec1.add(s3);
		List<Section> lstSec2 = new ArrayList<Section>(); lstSec2.add(s4);
		School sc1 = new School("1", "De", lstSec);
		School sc2 = new School("2", "DeX", lstSec1);
		School sc3 = new School("3", "DeN", lstSec2);
		List<School> lstSch = new ArrayList<School>();
		lstSch.add(sc1); lstSch.add(sc2); lstSch.add(sc3);
		Employee emp = new Employee("123", lstSch);
			
		String path = "school/section/subSection/subSecNo"; 
		List<?> value = extractObjectPropertyValue(path, emp, new ArrayList<>());
		System.out.println(value);
		
	}
	
	/**
	 * Recursively parses the object and extracts the property value from the given path. 
	 * Works well for searching primitive/Wrapper/Object type.
	 * The leaf node can be of any type including {Primitive/Wrapper/Arrays/Collection/Object} type.
	 * </br>Collects all the matching property value at the path specified in the input parameter.  
	 * </br>How it works?
	 * </br>class Employee {
	 * </br>	String name;
	 * </br>	List<Roll> roll;
	 * </br> 	static class Roll {
	 * </br> 		String rollNo;
	 * </br>	}
	 * </br>}
	 * </br> Input: Provide path as roll/rollNo.
	 * </br> output : Bunch of all the rollNo across the object.
	 * 
	 * @param path - give the location of the property in class template. 
	 * @param objToValidate
	 * @param param List of values fetched from the specified path from the object.
	 * @return {@code List<T> of objects}
	 */
	public static <T> List<? super T> extractObjectPropertyValue(String path, T objToValidate, List<? super T> param) {
		T obj = objToValidate; 
		String splits[] = path.split("/");
		for(String token : splits) {
			if(obj instanceof Collection) {
				for(T x : (Collection<T>)obj) {
					x = getPropertyValue(x, token);
					if(null == x) 
						continue;
					if(x != null && (x instanceof Boolean || x instanceof String || splits.length == 1)) 
						param.add(x);
					if((path.indexOf(token) + token.length() + 1) <= path.length())
						extractObjectPropertyValue(path.substring(path.indexOf(token) + token.length() + 1), x, param);
				}
			} else  {
				obj = getPropertyValue(obj, token);
				if(null == obj) 
					continue;
				if(obj instanceof String || obj instanceof Boolean) {
					param.add(obj);
					return param;
				} else {
					extractObjectPropertyValue(path.substring(path.indexOf(token) + token.length() + 1), obj, param);
				}
				return param;
			} 
			return param;
		}
		return param;
	}
	
	public static <T> T getPropertyValue(final T object, final String fieldName) {
		Object value = null;
		try{
			Class<?> c = object.getClass();
			Field f = c.getDeclaredField(fieldName);
			f.setAccessible(true);
			value = f.get(object);
		} catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e);
		}
		return (T) value;
	}

}

class Employee {
	private String id;
	private List<School> school;
	Employee(String p, List<School> p1) {
		id = p; school = p1; 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<School> getSchool() {
		return school;
	}
	public void setSchool(List<School> school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "[id:]" + id + " [school:]" + school.toString();
	}
}
class School {
	private String scId;
	private String scName;
	private List<Section> section;
	School(String p, String p1, List<Section> sec) {
		scId = p; scName = p1; section = sec;
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
	public List<Section> getSection() {
		return section;
	}
	public void setSection(List<Section> section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return " [scId:]" + scId + " [scName:]" + scName + " [section:]" + section.toString();
	}
}
class Section {
	private String secNo;
	private List<SubSection> subSection;
	Section(String sec, List<SubSection> subSec) {
		secNo = sec;
		subSection = subSec;
	}
	public String getSecNo() {
		return secNo;
	}
	public void setSecNo(String secNo) {
		this.secNo = secNo;
	}
	public List<SubSection> getSubSec() {
		return subSection;
	}
	public void setSubSec(List<SubSection> subSec) {
		this.subSection = subSec;
	}
	@Override
	public String toString() {
		return " [secNo:]" + secNo + " [subSection:]" + subSection.toString();
	}
}
class SubSection {
	private String subSecNo;
	SubSection(String sec) {
		subSecNo = sec;
	}
	public String getSubSecNo() {
		return subSecNo;
	}
	public void setSubSecNo(String subSecNo) {
		this.subSecNo = subSecNo;
	}
	@Override
	public String toString() {
		return " [subSecNo:]" + subSecNo;
	}
}

