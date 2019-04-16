package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import jpa.*;
import services.ServiceBatch;
import services.ServiceProgram;
import services.ServiceSlot;
import services.ServiceStudent;

public class ActionStudent extends ActionSupport{
	
	private List<String> Semester;
	private int StudentId;
	private String selectedSemester;
	private int sem , adddrop;
	private List<Object []> ResultInTermAcad;
	private List<Object []> courseSlot[];
	private List<slot> slot;
	private HashMap<String , Integer> hm; 
	private find_result result;
	private double current_credit_register;
	private double current_credit_earn;
	private double current_grade_point;
	private double cpi;
	private double spi;
	private double till_credit_register;
	private double till_credit_earn;
	private double till_grade_point;
	private List<String> selectedCourse;
	private int availCourse;
	private requirment requirment;
	private List<String> Authority;
	private int[] current;
	private int[] all;
	private String selectedAuthority;
	private String remark;
	private student Student = new student();
	private List<program> program;
	private List<batch> batch;
	
	

	public int getAdddrop() {
		return adddrop;
	}

	public void setAdddrop(int adddrop) {
		this.adddrop = adddrop;
	}

	public List<program> getProgram() {
		return program;
	}

	public void setProgram(List<program> program) {
		this.program = program;
	}

	public List<batch> getBatch() {
		return batch;
	}

	public void setBatch(List<batch> batch) {
		this.batch = batch;
	}

	public student getStudent() {
		return Student;
	}

	public void setStudent(student student) {
		Student = student;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSelectedAuthority() {
		return selectedAuthority;
	}

	public void setSelectedAuthority(String selectedAuthority) {
		this.selectedAuthority = selectedAuthority;
	}

	public int[] getCurrent() {
		return current;
	}

	public void setCurrent(int[] current) {
		this.current = current;
	}

	public int[] getAll() {
		return all;
	}

	public void setAll(int[] all) {
		this.all = all;
	}

	public List<String> getAuthority() {
		return Authority;
	}

	public void setAuthority() {
		List<String> a = new ArrayList<>();
		a.add("UG");a.add("PG");
		Authority = a;
	}

	public requirment getRequirment() {
		return requirment;
	}

	public void setRequirment(requirment requirment) {
		this.requirment = requirment;
	}

	public int getAvailCourse() {
		return availCourse;
	}

	public void setAvailCourse(int availCourse) {
		this.availCourse = availCourse;
	}

	public List<String> getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(List<String> selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public double getCurrent_credit_register() {
		return current_credit_register;
	}

	public void setCurrent_credit_register(double current_credit_register) {
		this.current_credit_register = current_credit_register;
	}

	public double getCurrent_credit_earn() {
		return current_credit_earn;
	}

	public void setCurrent_credit_earn(double current_credit_earn) {
		this.current_credit_earn = current_credit_earn;
	}

	public double getCurrent_grade_point() {
		return current_grade_point;
	}

	public void setCurrent_grade_point(double current_grade_point) {
		this.current_grade_point = current_grade_point;
	}

	public double getCpi() {
		return cpi;
	}

	public void setCpi(double cpi) {
		this.cpi = cpi;
	}

	public double getSpi() {
		return spi;
	}

	public void setSpi(double spi) {
		this.spi = spi;
	}

	public double getTill_credit_register() {
		return till_credit_register;
	}

	public void setTill_credit_register(double till_credit_register) {
		this.till_credit_register = till_credit_register;
	}

	public double getTill_credit_earn() {
		return till_credit_earn;
	}

	public void setTill_credit_earn(double till_credit_earn) {
		this.till_credit_earn = till_credit_earn;
	}

	public double getTill_grade_point() {
		return till_grade_point;
	}

	public void setTill_grade_point(double till_grade_point) {
		this.till_grade_point = till_grade_point;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public find_result getResult() {
		return result;
	}

	public void setResult(find_result result) {
		this.result = result;
	}

	public HashMap<String, Integer> getHm() {
		return hm;
	}

	public void setHm() {

		HashMap<String,Integer> a = new HashMap<>();
		a.put("AA",10);a.put("AB", 9);a.put("BB", 8);a.put("BC", 7);a.put("CC", 6);
		a.put("CD", 5);a.put("DD", 4);a.put("F", 0);a.put("P", 0);
		this.hm = a;
	}

	public List<slot> getSlot() {
		return slot;
	}

	public void setSlot(List<slot> slot) {
		this.slot = slot;
	}

	public List<Object[]>[] getCourseSlot() {
		return courseSlot;
	}

	public void setCourseSlot(List<Object[]>[] courseSlot) {
		this.courseSlot = courseSlot;
	}

	public List<Object []> getResultInTermAcad() {
		return ResultInTermAcad;
	}

	public void setResultInTermAcad(List<Object []> resultInTermAcad) {
		ResultInTermAcad = resultInTermAcad;
	}

	public String getSelectedSemester() {
		return selectedSemester;
	}

	public void setSelectedSemester(String selectedSemester) {
		this.selectedSemester = selectedSemester;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public List<String> getSemester() {
		return Semester;
	}

	public void setSemester() {
		List<String> s = new ArrayList<>();
		s.add("semester 1");s.add("semester 2");
		s.add("semester 3");s.add("semester 4");
		s.add("semester 5");s.add("semester 6");
		s.add("semester 7");s.add("semester 8");s.add("summer 1");
		s.add("summer 2");s.add("summer 3");
		Semester = s;
	}

	public String execute()
	{
		return "done";
	}
	
	public String Student()
	{
		setStudentId(201501041);
		setSemester();
		return "success";
	}
	
	public String getStudentRegistration()
	{
		ServiceStudent ss = new ServiceStudent();
		List<String> ta = ss.getTermAcadFromSemesterAndStdId(getStudentId(), getSelectedSemester());
		setStudentId(getStudentId());
		setSelectedSemester(getSelectedSemester());
		setSem(Integer.parseInt(getSelectedSemester().split(" ")[1]));
		
		List<Object []> result = ss.getCourseResultInTermAcad(getStudentId(),Integer.parseInt(ta.get(1)), ta.get(0));
		
		if(result.isEmpty())
		{
			if(ss.checkValidity(Integer.parseInt(ta.get(1)), ta.get(0)))
			{
				List<Object []> rc = ss.getCourseInTermAcad(getStudentId(), Integer.parseInt(ta.get(1)), ta.get(0));
				setSlot(new ServiceSlot().getSlot());
				setCourseSlot(ss.getSoltWiseCourse(rc));
				return "register";
			}
			else
				return "error_register_over";
		}
		else
		{
			if(ss.checkValidityAddDrop(Integer.parseInt(ta.get(1)), ta.get(0)) && getAdddrop()==0)
			{
				List<Object []> rc = ss.getCourseInTermAcad(getStudentId(), Integer.parseInt(ta.get(1)), ta.get(0));
				setSlot(new ServiceSlot().getSlot());
				setCourseSlot(ss.getSoltWiseCourse(rc));
				setAdddrop(1);
				return "error_register";
			}
			else if(ss.checkValidityAddDrop(Integer.parseInt(ta.get(1)), ta.get(0)) && getAdddrop()==1)
			{
				List<Object []> rc = ss.getCourseInTermAcad(getStudentId(), Integer.parseInt(ta.get(1)), ta.get(0));
				setSlot(new ServiceSlot().getSlot());
				setCourseSlot(ss.getSoltWiseCourse(rc));
				setAdddrop(1);
				return "register";
			}
			else
			{
				return "error_register";
			}
		}
	}
	
	public String getStudentResult()
	{
		
		ServiceStudent ss = new ServiceStudent();
		List<String> ta = ss.getTermAcadFromSemesterAndStdId(getStudentId(), getSelectedSemester());
		setStudentId(getStudentId());
		setSelectedSemester(getSelectedSemester());
		setSem(Integer.parseInt(getSelectedSemester().split(" ")[1]));
		setHm();
		
		List<Object []> result = ss.getCourseResultInTermAcad(getStudentId(),Integer.parseInt(ta.get(1)), ta.get(0));
		
		if(!result.isEmpty())
		{
			setResultInTermAcad(result);
			setResult(ss.getResult(getStudentId()));
			return "result";
		}
		else
		{
			return "error_result";
		}
	}
	
	public String StudentErrorHandel()
	{
		return "done";
	}
	
	public String RegisterStudentSummary()
	{
		ServiceStudent ss = new ServiceStudent();
		int total_avaiCourse = getAvailCourse();
		int std_id = getStudentId();
		String sem = getSelectedSemester();
		requirment r = ss.getRequirment(std_id);
		
		int a[] = new int[4];
		int b[] = new int[4];
		
		a[1] = ss.getCurrentCourseNoByType(std_id, sem,"Technical Elective", getSelectedCourse(),0);
		a[2] = ss.getCurrentCourseNoByType(std_id, sem,"Science Elective", getSelectedCourse(),0);
		a[3] = ss.getCurrentCourseNoByType(std_id, sem,"Other Elective", getSelectedCourse(),0);
		a[0] = ss.getCurrentCourseNoByType(std_id, sem,"Group Elective", getSelectedCourse(),0);
		
		b[1] = a[1] + ss.getCurrentCourseNoByType(std_id, sem,"Technical Elective", getSelectedCourse(),1);
		b[2] = a[2] + ss.getCurrentCourseNoByType(std_id, sem,"Science Elective", getSelectedCourse(),1);
		b[3] = a[3] + ss.getCurrentCourseNoByType(std_id, sem,"Other Elective", getSelectedCourse(),1);
		b[0] = a[0] + ss.getCurrentCourseNoByType(std_id, sem,"Group Elective", getSelectedCourse(),1);
		
		setCurrent(a);
		setAll(b);
		setResultInTermAcad(ss.getCurrentCourseFromCourseCode(std_id, sem, getSelectedCourse()));
		setRequirment(r);
		setAuthority();
		setAvailCourse(total_avaiCourse);
		setStudentId(std_id);
		setAdddrop(getAdddrop());
		setSem(Integer.parseInt(sem.split(" ")[1]));
		setResult(ss.getResult(std_id));
		
		return "success";
	}
	
	public String RegisterStudent()
	{
		int std_id = getStudentId();
		int sem = getSem();
		int adddrop = getAdddrop();
		
		ServiceStudent ss = new ServiceStudent();
		List<String> a = ss.getTermAcadFromSemesterAndStdId(std_id, "semester "+sem);
		
		if(adddrop==1)
		{
			ss.deleteRegisteredStudent(std_id, Integer.parseInt(a.get(1)),a.get(0));
			ss.RegisterStudent(std_id, Integer.parseInt(a.get(1)), a.get(0), getSelectedCourse(), getRemark());
		}
		else
	 		ss.RegisterStudent(std_id, Integer.parseInt(a.get(1)), a.get(0), getSelectedCourse(), getRemark());
		return "done";
	}
	
	public String UpdateStudentFindResult()
	{
		ServiceStudent ss = new ServiceStudent();
		ss.addResult(getStudentId(), getSem(), getCurrent_credit_register(), getCurrent_credit_earn(), getCurrent_grade_point(), getSpi(), getTill_credit_register(), getTill_credit_earn(),getTill_grade_point(),getCpi());
		return "done";
	}
	
	public String editStudentProfile()
	{
		setProgram(new ServiceProgram().getProgram());
		setBatch(new ServiceBatch().getBatch());
		setStudent(new ServiceStudent().getStudent(getStudentId()));
		return "success";
	}
	
	public String editStudent()
	{
		ServiceStudent ss = new ServiceStudent();
		ss.editStudent(getStudent());
		return "done";
	}
}
