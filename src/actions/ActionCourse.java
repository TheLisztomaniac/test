package actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jpa.*;
import services.ServiceCourses;
import services.ServiceFaculty;
import services.ServiceProgram;

public class ActionCourse extends ActionSupport{
	
	private List<course> CourseList;
	private List<String> PreCourseList;
	private List<String> Level;
	private List<String> Category;
	private List<String> Discipline;
	private List<String> AssessmentType;
	private course c;
	private String CourseCode;
	
	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public List<String> getPreCourseList() {
		return PreCourseList;
	}

	public void setPreCourseList(List<String> preCourseList) {
		PreCourseList = preCourseList;
	}
	
	public course getC() {
		return c;
	}

	public void setC(course c) {
		this.c = c;
	}

	public List<String> getLevel() {
		return Level;
	}

	public void setLevel() {
		
		List<String> level = new ArrayList<>();
		level.add("UG");level.add("PG");
		Level = level;
	}

	public List<String> getCategory() {
		return Category;
	}

	public void setCategory() {
		
		List<String> c = new ArrayList<>();
		c.add("A");c.add("B");c.add("C");c.add("D");
		Category = c;
	}

	public List<String> getDiscipline() {
		return Discipline;
	}

	public void setDiscipline() {
		
		List<String> d = new ArrayList<>();
		d.add("IT");d.add("CT");d.add("EL");d.add("SC");d.add("HM");d.add("ES");
		Discipline = d;
	}

	public List<String> getAssessmentType() {
		return AssessmentType;
	}

	public void setAssessmentType() {
		
		List<String> d = new ArrayList<>();
		d.add("Grade");d.add("Pass/Fail");
		AssessmentType = d;
	}

	public List<course> getCourseList() {
		return CourseList;
	}

	public void setCourseList(List<course> courseList) {
		CourseList = courseList;
	}

	public String execute()
	{
		return "";
	}
	
	public String getCourse()
	{
		setCourseList(new ServiceCourses().getCourses());
		return "success";
	}
	
	public String addCourseForm()
	{
		setCategory();
		setDiscipline();
		setLevel();
		setAssessmentType();
		setCourseList(new ServiceCourses().getCourses());;
		return "success";
	}
	
	public String addCourse()
	{
		course c = getC();
		ServiceCourses sc = new ServiceCourses();
		sc.addCourse(c);
		sc.addPreRequisiteCourse(c.getC_code(), getPreCourseList());
		return "done";
	}
	
	public String editCourseForm()
	{
		setCategory();
		setDiscipline();
		setLevel();
		setAssessmentType();
		ServiceCourses sc = new ServiceCourses();
		setCourseList(sc.getCourses());
		setC(sc.getCourseById(getCourseCode()));
		return "success";
	}
	
	public String editCourse()
	{
		course c = getC();
		ServiceCourses sc = new ServiceCourses();
		sc.editCourse(c, c.getC_code());
		sc.editPreRequisiteCourse(c.getC_code(),getPreCourseList());
		return "done";
	}
	
	public String deleteCourse()
	{
		ServiceCourses sc = new ServiceCourses();
		sc.deletePreRequisiteCourse(sc.getCoursePreRequisiteListById(getCourseCode()));
		sc.deleteCourse(sc.getCourseById(getCourseCode()));
		return "done";
	}

}
