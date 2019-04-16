package actions;
import jpa.*;
import services.*;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ActionYear extends ActionSupport
{
	private List<acad_year> AcadYearList;
	private int y;

	public List<acad_year> getAcadYearList() {
		return AcadYearList;
	}


	public void setAcadYearList(List<acad_year> acadYearList) {
		AcadYearList = acadYearList;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String getYear()
	{
		setAcadYearList(new ServiceYear().getYear());
		return "success";
	}
	public String addYear()
	{
		new ServiceYear().addYear(getY());
		return "done";
	}
	public String addYearForm()
	{
		return "success";
	}
	public String deleteYear()
	{
		new ServiceYear().deleteYear(getY());
		return "done";
	}


}