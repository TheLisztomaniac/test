package actions;
import java.util.*;
import jpa.*;
import services.*;

import com.opensymphony.xwork2.ActionSupport;

public class ActionProgram extends ActionSupport {
	
	private List<program> programList;
	private List<String> DurationUnit;
	private List<faculty> facultyList;
	private program p;
	private int ProgramId;
	
	public List<faculty> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(List<faculty> facultyList) {
		this.facultyList = facultyList;
	}

	public int getProgramId() {
		return ProgramId;
	}

	public void setProgramId(int programId) {
		ProgramId = programId;
	}

	public program getP() {
		return p;
	}

	public void setP(program p) {
		this.p = p;
	}

	public List<String> getDurationUnit() {
		return DurationUnit;
	}

	public void setDurationUnit() {
		List<String> d = new ArrayList<>();
		d.add("Year");d.add("Semester");d.add("Term");d.add("Month");
		DurationUnit = d;
	}
	
	public List<program> getProgramList() {
		return programList;
	}

	public void setProgramList(List<program> programList) {
		this.programList = programList;
	}
	
	public String execute()
	{
		return "";
	}
	
	public String getProgram()
	{
		setProgramList(new ServiceProgram().getProgram());
		return "success";
	}
	
	public String addProgramForm()
	{
		ServiceFaculty sf = new ServiceFaculty();
		setFacultyList(sf.getFaculty());
		setDurationUnit();
		return "success";
	}
	
	public String addProgram()
	{
		program p = getP();
		ServiceProgram sp = new ServiceProgram();
		sp.addProgram(p);
		return "done";
	}
	
	public String editProgramForm()
	{
		ServiceFaculty sf = new ServiceFaculty();
		ServiceProgram sp = new ServiceProgram();
		setFacultyList(sf.getFaculty());
		setDurationUnit();
		setP(sp.getProgramById(getProgramId()));
		return "success";
	}
	
	public String editProgram()
	{
		program p = getP();
		ServiceProgram sp = new ServiceProgram();
		sp.editProgram(p , getProgramId());
		return "done";
	}
	
	public String deleteProgram()
	{
		ServiceProgram sp = new ServiceProgram();
		sp.deleteProgram(sp.getProgramById(getProgramId()));
		return "done";
	}
}
