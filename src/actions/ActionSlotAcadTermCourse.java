package actions;

import java.util.*;

import org.apache.struts2.dispatcher.Dispatcher;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.ConfigurationManager;

import jpa.*;
import services.*;

public class ActionSlotAcadTermCourse extends ActionSupport{
	
	private List<acad_year> AcadYear;
	private List<term> Term;
	private List<program> Program;
	private List<batch> Batch;
	private List<slot> Slot;
	private List<String> Type;
	private List<Object []> Offer;
	
	private int selectedAcad;
	private String selectedterm;
	private List<Integer> selectedProgram;
	private List<Integer> selectedBatch;
	private String selectedType;
	private int selectedSlot;
	private int selectedOffer;
	private int selectedFaculty;
	private String selectedCourse;
	private boolean click;
	private boolean slotMasterclick;
	
	

	public boolean isSlotMasterclick() {
		return slotMasterclick;
	}

	public void setSlotMasterclick(boolean slotMasterclick) {
		this.slotMasterclick = slotMasterclick;
	}

	public int getSelectedOffer() {
		return selectedOffer;
	}

	public void setSelectedOffer(int selectedOffer) {
		this.selectedOffer = selectedOffer;
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	public List<Integer> getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(List<Integer> selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public List<Integer> getSelectedBatch() {
		return selectedBatch;
	}

	public void setSelectedBatch(List<Integer> selectedBatch) {
		this.selectedBatch = selectedBatch;
	}

	public String getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}

	public int getSelectedSlot() {
		return selectedSlot;
	}

	public void setSelectedSlot(int selectedSlot) {
		this.selectedSlot = selectedSlot;
	}

	public int getSelectedFaculty() {
		return selectedFaculty;
	}

	public void setSelectedFaculty(int selectedFaculty) {
		this.selectedFaculty = selectedFaculty;
	}

	public String getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	
	public void setType(List<String> type) {
		Type = type;
	}

	public List<String> getType() {
		return Type;
	}

	public void setType() {
		
		List<String> type = new ArrayList<>();
		type.add("Core");
		type.add("Technical Elective");
		type.add("Group Elective");
		type.add("Other Elective");
		type.add("Science Elective");
		Type = type;
	}

	public List<batch> getBatch() {
		return Batch;
	}

	public void setBatch(List<batch> batch) {
		Batch = batch;
	}

	public List<slot> getSlot() {
		return Slot;
	}

	public void setSlot(List<slot> slot) {
		Slot = slot;
	}

	public List<program> getProgram() {
		return Program;
	}

	public void setProgram(List<program> program) {
		Program = program;
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
	
	public String getSlotAcadTermCourse()
	{
		setAcadYear(new ServiceYear().getYear());
		setTerm(new ServiceTerm().getTerm());
		return "success";
	}
	
	public String getSlotAcadTermCourseForm()
	{
		if(isSlotMasterclick())
		{
			setOffer(new ServiceOffer().getSlotOfferByTermAndYear(getSelectedterm(), getSelectedAcad()));
		}
		else if(isClick())
		{
			setOffer(new ServiceOffer().getSlotOfferByTermAndYear(getSelectedterm(), getSelectedAcad()));
			if(getOffer().size()==0)
				return "done";
			new ServiceOffer().addSlotAcadTermCourse(getSelectedProgram(), getSelectedBatch(), getSelectedOffer(), getSelectedSlot(), getSelectedType());
		}
		else
		{
			setOffer(new ServiceOffer().getOfferByTermAndYear(getSelectedterm(), getSelectedAcad()));
		}
		
		setProgram(new ServiceProgram().getProgram());
		setSlot(new ServiceSlot().getSlot());
		setBatch(new ServiceBatch().getBatch());
		setType();
		setSelectedAcad(getSelectedAcad());
		setSelectedterm(getSelectedterm());
		
		ConfigurationManager configMan=Dispatcher.getInstance().getConfigurationManager();
		configMan.reload();
		
		return "success";
	}
}
