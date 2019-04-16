package actions;

import java.util.*;
import jpa.*;
import services.*;

import com.opensymphony.xwork2.ActionSupport;

public class ActionAcadTermCourse extends ActionSupport{

	private List<acad_year> AcadYear;
	private List<term> Term;
	private List<Object []> Offer;
	private List<faculty> Faculty;
	private List<course> CourseList;
	
	private int selectedAcad;
	private String selectedterm;
	private int selectedFaculty;
	private String selectedCourse;
	private int selectedOffer;
	
	public int getSelectedOffer() {
		return selectedOffer;
	}

	public void setSelectedOffer(int selectedOffer) {
		this.selectedOffer = selectedOffer;
	}

	private course c;
	
	public course getC() {
		return c;
	}

	public void setC(course c) {
		this.c = c;
	}

	public List<course> getCourseList() {
		return CourseList;
	}

	public void setCourseList(List<course> courseList) {
		CourseList = courseList;
	}

	public String getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public int getSelectedFaculty() {
		return selectedFaculty;
	}

	public void setSelectedFaculty(int selectedFaculty) {
		this.selectedFaculty = selectedFaculty;
	}

	public List<faculty> getFaculty() {
		return Faculty;
	}

	public void setFaculty(List<faculty> faculty) {
		Faculty = faculty;
	}

	public List<Object[]> getOffer() {
		return Offer;
	}

	public void setOffer(List<Object[]> offer) {
		Offer = offer;
	}

	public int getSelectedAcad() {
		return selectedAcad;
	}

	public void setSelectedAcad(int selectedAcad) {
		this.selectedAcad = selectedAcad;
	}

	public String getSelectedterm() {
		return selectedterm;
	}

	public void setSelectedterm(String selectedterm) {
		this.selectedterm = selectedterm;
	}

	public List<acad_year> getAcadYear() {
		return AcadYear;
	}

	public void setAcadYear(List<acad_year> acadYear) {
		AcadYear = acadYear;
	}

	public List<term> getTerm() {
		return Term;
	}

	public void setTerm(List<term> term) {
		Term = term;
	}

	public String execute()
	{
		return "";
	}
	
	public String getAcadTermCourse()
	{
		setAcadYear(new ServiceYear().getYear());
		setTerm(new ServiceTerm().getTerm());
		return "success";
	}
	
	public String getAcadTermCourseForm()
	{
		setOffer(new ServiceOffer().getOfferByTermAndYear(getSelectedterm(), getSelectedAcad()));
		setSelectedAcad(getSelectedAcad());
		setSelectedterm(getSelectedterm());
		return "success";
	}
	
	public String addAcadTermCourseForm()
	{
		setCourseList(new ServiceCourses().getCourses());
		setFaculty(new ServiceFaculty().getFaculty());
		setSelectedAcad(getSelectedAcad());
		setSelectedterm(getSelectedterm());
		setC(new ServiceCourses().getCourseById(getSelectedCourse()));
		return "success";
	}
	public String addAcadTermCourse()
	{
		ServiceOffer so = new ServiceOffer();
		so.addAcadTermCourseOffer(getSelectedterm(), getSelectedAcad(), getSelectedFaculty(), getC().getC_code());
		return "done";
	}
	
	public String editAcadTermCourseForm()
	{
		setFaculty(new ServiceFaculty().getFaculty());
		setC(new ServiceCourses().getCourseById(getSelectedCourse()));
		setSelectedAcad(getSelectedAcad());
		setSelectedterm(getSelectedterm());
		return "success";
	}
	
	public String editAcadTermCourse()
	{
		ServiceOffer so = new ServiceOffer();
		so.editAcadTermCourseOffer(getSelectedterm(), getSelectedAcad(), getSelectedFaculty(), getC().getC_code(),getSelectedOffer());
		return "done";
	}
	
	public String deleteAcadTermCourse()
	{
		ServiceOffer so = new ServiceOffer();
		so.deleteAcadTermCourseOffer(getSelectedterm(), getSelectedAcad(), getSelectedFaculty(), getSelectedCourse(),getSelectedOffer());
		return "done";
	}
}
