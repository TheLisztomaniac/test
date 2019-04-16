package actions;

import java.util.*;
import jpa.*;
import services.ServiceProgram;
import services.ServiceSlot;
import services.ServiceTerm;
import services.ServiceYear;

import com.opensymphony.xwork2.ActionSupport;

public class ActionSlotAllotment extends ActionSupport{
	
	private List<acad_year> AcadYear; 
	private List<term> Term;
	private List<program> Program;
	private List<slot> Slot;
	private List<Object []> QueryResult;
	
	private int selectedAcad;
	private int selectedProgram;
	private int selectedSlot;
	private String selectedTerm;
	
	public List<Object[]> getQueryResult() {
		return QueryResult;
	}

	public void setQueryResult(List<Object[]> queryResult) {
		QueryResult = queryResult;
	}

	public int getSelectedAcad() {
		return selectedAcad;
	}

	public void setSelectedAcad(int selectedAcad) {
		this.selectedAcad = selectedAcad;
	}

	public int getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(int selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public int getSelectedSlot() {
		return selectedSlot;
	}

	public void setSelectedSlot(int selectedSlot) {
		this.selectedSlot = selectedSlot;
	}

	public String getSelectedTerm() {
		return selectedTerm;
	}

	public void setSelectedTerm(String selectedTerm) {
		this.selectedTerm = selectedTerm;
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

	public List<program> getProgram() {
		return Program;
	}

	public void setProgram(List<program> program) {
		Program = program;
	}

	public List<slot> getSlot() {
		return Slot;
	}

	public void setSlot(List<slot> slot) {
		Slot = slot;
	}

	public String execute()
	{
		return "done";
	}
	
	public String getSlotAllotment()
	{
		setAcadYear(new ServiceYear().getYear());
		setProgram(new ServiceProgram().getProgram());
		setTerm(new ServiceTerm().getTerm());
		setSlot(new ServiceSlot().getSlot());
		return "success";
	}
	
	public String getSlotAllotmentQuery()
	{
		setSelectedSlot(getSelectedSlot());
		setSelectedProgram(getSelectedProgram());
		setQueryResult(new ServiceSlot().getSlotQueryResult(getSelectedTerm(), getSelectedAcad(), getSelectedProgram(), getSelectedSlot()));
		return "success";
	}
}
