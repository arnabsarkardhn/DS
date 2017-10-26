package com.arnab.algos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ExtractObjectPropertyRecursively {

static String path1 = "school/section/secNo";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		List<Object> obj = new ArrayList<Object>();
		
		String path = "school/section/secNo"; 
		System.out.println(path.substring(path.lastIndexOf("section") + "section".length()));
		System.out.println(extractObjectPropertyValue(path, emp, obj));
		
	}
	
	public static <T> List<Object> extractObjectPropertyValue(String path, T emp, List<Object> param) {
		T obj = emp; 
		String splits[] = path.split("/");
		for(String token : splits) {
			if(obj instanceof Collection) {
				for(T x : (Collection<T>)obj) {
					x = getPropertyValue(x, token);
					if(x != null && (x instanceof Boolean || x instanceof String)) 
						param.add(x);
					if((path.lastIndexOf(token) + token.length() + 1) <= path.length())
						extractObjectPropertyValue(path.substring(path.lastIndexOf(token) + token.length() + 1), x, param);
				}
			} else  {
				obj = getPropertyValue(obj, token);
				if(obj instanceof String || obj instanceof Boolean) {
					param.add(obj);
					return param;
				} else {
					extractObjectPropertyValue(path.substring(path.lastIndexOf(token) + token.length() + 1), obj, param);
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
		System.out.println(value);
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
	
}
class Section {
	private String secNo;
	/*Section(String sec) {
		secNo = sec;
	}*/
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
	
	
}

