package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.views.freemarker.tags.RadioModel;

import jpa.*;
import services.*;

public class ActionRegistrar extends ActionSupport{
	
	private List<program> program;
	private List<Integer> batch , semesterList ;
	private List<Object []> StudentId , StudentSem[];
	private List<String> semester , courseUndo , remark;
	private int selectedProgram;
	private int selectedBatch , selectedSingleStudent;
	private String selectedSemester;
	private String selectedTerm , selectedReminder , selectedCourse;
	private int selectedAcad;
	private List<Integer> selectedStudent;
	private List<acad_year> acad;
	private List<term> term;
	private List<course> course;
	private List<String> reminder;
	@Temporal(TemporalType.DATE)
	private Date openRegistraton;
	@Temporal(TemporalType.DATE)
	private Date closeRegistraton;
	private List<Object []> ResultInTermAcad;
	private int check ;
	private List<student> Student;
	private String heading;

	public List<Integer> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList() {
		List<Integer> s = new ArrayList<>();
		for(int i=1;i<=7;i++)
			s.add(i);
		this.semesterList = s;
	}

	public List<Object[]>[] getStudentSem() {
		return StudentSem;
	}

	public void setStudentSem(List<Object[]>[] studentSem) {
		StudentSem = studentSem;
	}

	public String getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	}


	public List<course> getCourse() {
		return course;
	}


	public void setCourse(List<course> course) {
		this.course = course;
	}


	public String getHeading() {
		return heading;
	}


	public void setHeading(String heading) {
		this.heading = heading;
	}


	public List<student> getStudent() {
		return Student;
	}


	public void setStudent(List<student> student) {
		Student = student;
	}


	public List<String> getRemark() {
		return remark;
	}


	public void setRemark(List<String> remark) {
		this.remark = remark;
	}


	public int getCheck() {
		return check;
	}


	public void setCheck(int check) {
		this.check = check;
	}


	public List<String> getCourseUndo() {
		return courseUndo;
	}


	public void setCourseUndo(List<String> courseUndo) {
		this.courseUndo = courseUndo;
	}


	public List<Object[]> getResultInTermAcad() {
		return ResultInTermAcad;
	}


	public void setResultInTermAcad(List<Object[]> resultInTermAcad) {
		ResultInTermAcad = resultInTermAcad;
	}


	public int getSelectedSingleStudent() {
		return selectedSingleStudent;
	}


	public void setSelectedSingleStudent(int selectedSingleStudent) {
		this.selectedSingleStudent = selectedSingleStudent;
	}


	public List<String> getReminder() {
		return reminder;
	}
	

	public String getSelectedReminder() {
		return selectedReminder;
	}

	public void setSelectedReminder(String selectedReminder) {
		this.selectedReminder = selectedReminder;
	}

	public void setReminder() {
		List<String> r = new ArrayList<>();
		r.add("2 days before end date");
		r.add("5 days before end date");
		r.add("7 days before end date");
		this.reminder = r;
	}

	public Date getOpenRegistraton() {
		return openRegistraton;
	}

	public void setOpenRegistraton(Date openRegistraton) {
		this.openRegistraton = openRegistraton;
	}

	public Date getCloseRegistraton() {
		return closeRegistraton;
	}

	public void setCloseRegistraton(Date closeRegistraton) {
		this.closeRegistraton = closeRegistraton;
	}

	public String getSelectedTerm() {
		return selectedTerm;
	}

	public void setSelectedTerm(String selectedTerm) {
		this.selectedTerm = selectedTerm;
	}

	public int getSelectedAcad() {
		return selectedAcad;
	}

	public void setSelectedAcad(int selectedAcad) {
		this.selectedAcad = selectedAcad;
	}

	public List<acad_year> getAcad() {
		return acad;
	}

	public void setAcad(List<acad_year> acad) {
		this.acad = acad;
	}

	public List<term> getTerm() {
		return term;
	}

	public void setTerm(List<term> term) {
		this.term = term;
	}

	public List<Integer> getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(List<Integer> selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<Object []> getStudentId() {
		return StudentId;
	}

	public void setStudentId(List<Object []> studentId) {
		StudentId = studentId;
	}

	public int getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(int selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public int getSelectedBatch() {
		return selectedBatch;
	}

	public void setSelectedBatch(int selectedBatch) {
		this.selectedBatch = selectedBatch;
	}

	public String getSelectedSemester() {
		return selectedSemester;
	}

	public void setSelectedSemester(String selectedSemester) {
		this.selectedSemester = selectedSemester;
	}

	public List<program> getProgram() {
		return program;
	}

	public void setProgram(List<program> program) {
		this.program = program;
	}

	public List<Integer> getBatch() {
		return batch;
	}

	public void setBatch(List<Integer> batch) {
		this.batch = batch;
	}

	public List<String> getSemester() {
		return semester;
	}

	public void setSemester() {
		List<String> s = new ArrayList<>();
		s.add("semester 1");s.add("semester 2");
		s.add("semester 3");s.add("semester 4");
		s.add("semester 5");s.add("semester 6");
		s.add("semester 7");s.add("semester 8");s.add("summer 1");
		s.add("summer 2");s.add("summer 3");
		this.semester = s;
	}

	public String execute()
	{
		return "done";
	}
	
	public String Registrar()
	{
		setSemester();
		setProgram(new ServiceProgram().getProgram());
		setBatch(new ServiceBatch().getBatchString());
		return "success";
	}
	
	public String getRegistrarForm()
	{
		if(getCheck()==1)
		{
			List<String> c_undo = getCourseUndo();
			int std = getSelectedSingleStudent();
			String sem = getSelectedSemester();
			ServiceStudent ss = new ServiceStudent();
			ss.deleteRegisterCourse(c_undo, std, sem);
		}
		
		int batch = getSelectedBatch();
		String fakeId = batch+"00000";
		List<String> a = new ServiceStudent().getTermAcadFromSemesterAndStdId(Integer.parseInt(fakeId), getSelectedSemester());
		setStudentId(new ServiceRegistrar().getStudentRequest(Integer.parseInt(a.get(1)),a.get(0)));
		setSelectedBatch(batch);
		setSelectedProgram(getSelectedProgram());
		setSelectedSemester(getSelectedSemester());
		return "success";
	}
	
	public String getUnRegistrarForm()
	{
		int batch = getSelectedBatch();
		String fakeId = batch+"00000";
		List<String> a = new ServiceStudent().getTermAcadFromSemesterAndStdId(Integer.parseInt(fakeId), getSelectedSemester());
		setStudentId(new ServiceRegistrar().getStudentRegistered(Integer.parseInt(a.get(1)), a.get(0)));
		setSelectedBatch(batch);
		setSelectedProgram(getSelectedProgram());
		setSelectedSemester(getSelectedSemester());
		return "success";
	}
	
	public String ConformRegistrar()
	{
		ServiceRegistrar sr = new ServiceRegistrar();
		sr.conformRegister(getSelectedStudent(),getSelectedSemester(),getRemark());
		return "done";
	}
	
	public String ConformUnRegistrar()
	{
		ServiceRegistrar sr = new ServiceRegistrar();
		sr.conformUnRegister(getSelectedStudent(),getSelectedSemester());
		return "done";
	}
	
	public String RegistrarSchedule()
	{
		setAcad(new ServiceYear().getYear());
		setTerm(new ServiceTerm().getTerm());
		return "success";
	}
	
	public String RegistrarScheduleForm()
	{
		setSelectedAcad(getSelectedAcad());
		setSelectedTerm(getSelectedTerm());
		setReminder();
		return "success";
	}
	
	public String RegistrarScheduleForm1()
	{
		setSelectedAcad(getSelectedAcad());
		setSelectedTerm(getSelectedTerm());
		setReminder();
		return "success";
	}

	public String addRegistrarSchedule()
	{
		reminder_id rid = new reminder_id(getSelectedTerm(), getSelectedAcad()); 
		reminder r = new reminder();
		r.setRid(rid);
		r.setOpen_registration(getOpenRegistraton());
		r.setClose_registration(getCloseRegistraton());
		
		//set reminder according to date
		int days = Integer.parseInt(getSelectedReminder().split(" ")[0]);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(getCloseRegistraton());
		cal.add(Calendar.DATE, -days);
		r.setReminder_date(cal.getTime());
		
		ServiceRegistrar sr = new ServiceRegistrar();
		sr.addReminderSchedule(r);
		return "done";
	}
	
	public String UpdateRegistrarSchedule()
	{
		reminder_id rid = new reminder_id(getSelectedTerm(), getSelectedAcad()); 
		reminder r = new reminder();
		r.setRid(rid);
		r.setOpen_adddrop(getOpenRegistraton());
		r.setClose_adddrop(getCloseRegistraton());
		
		//set reminder according to date
		int days = Integer.parseInt(getSelectedReminder().split(" ")[0]);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(getCloseRegistraton());
		cal.add(Calendar.DATE, -days);
		r.setReminder_date(cal.getTime());
		
		ServiceRegistrar sr = new ServiceRegistrar();
		sr.updateReminderSchedule(r);
		return "done";
	}
	
	public String RegistrarSeeForm()
	{
		ServiceStudent ss = new ServiceStudent();
		List<String> ta = ss.getTermAcadFromSemesterAndStdId(getSelectedSingleStudent(), getSelectedSemester());
		setSelectedSingleStudent(getSelectedSingleStudent());;
		setSelectedSemester(getSelectedSemester());
		setSelectedProgram(getSelectedProgram());
		setSelectedBatch(getSelectedBatch());
		
		List<Object []> result = ss.getCourseResultInTermAcad(getSelectedSingleStudent(),Integer.parseInt(ta.get(1)), ta.get(0));
		setResultInTermAcad(result);
		return "success";
	}
	
	public String seeRegistrarstudentList()
	{
		setStudent(new ServiceStudent().getStudentListInSem(getSelectedProgram(), getSelectedBatch(), getSelectedSemester()));
		setHeading("Registerd");
		return "success";
	}
	
	public String seeRegistrarstudentList1()
	{
		setStudent(new ServiceStudent().getStudentListNotInSem(getSelectedProgram(), getSelectedBatch(), getSelectedSemester()));
		setHeading("Unregisterd");
		return "ok";
	}
	
	public String RegistrarResultAnalysis()
	{
		setAcad(new ServiceYear().getYear());
		setTerm(new ServiceTerm().getTerm());
		setCourse(new ServiceCourses().getCourses());
		setBatch(new ServiceBatch().getBatchString());
		setProgram(new ServiceProgram().getProgram());
		setSemesterList();
		return "success";
	}
	
	public String RegistrarResultAnalysiscoursewise()
	{
		ServiceRegistrar sr = new ServiceRegistrar();
		setStudentId(sr.getStudentRegisteredByCourse(getSelectedAcad(), getSelectedTerm(), getSelectedCourse()));
		setSelectedAcad(getSelectedAcad());
		setSelectedCourse(getSelectedCourse());
		setSelectedTerm(getSelectedTerm());
		return "success";
	}
	
	public String RegistrarResultAnalysisstudente()
	{
		List<Object []> ans = new ServiceRegistrar().getResultAllSemByStd(getSelectedSingleStudent());
		
		List<Object[]> s[] = new ArrayList[8];
		
		for(int i=0;i<=7;i++)
			s[i] = new ArrayList<>();
		
		for(Object [] i : ans)
		{
			student_registration sr = (student_registration)i[1];
			int sem = new ServiceRegistrar().getSemFromStdAcadTerm(getSelectedSingleStudent(), sr.getSrid().getTaid().getA_year(), sr.getSrid().getTaid().getT_name());
			s[sem].add(i);
		}
		
		setStudentSem(s);
		setSemesterList();
		return "success";
	}
	
	public String RegistrarResultAnalysissemester()
	{
		ServiceStudent ss = new ServiceStudent();
		List<student> sl = ss.getStudentListInSem(getSelectedProgram(), getSelectedBatch(), "semester "+getSelectedSemester());
		List<String> a = ss.getTermAcadFromSemesterAndStdId(Integer.parseInt(getSelectedBatch()+"00000"), "semester "+getSelectedSemester());
		
		for(student s : sl)
		{
			List<Object []> cs = ss.getCourseInTermAcad(s.getStd_id(), Integer.parseInt(a.get(1)), a.get(0));
		}
		
		System.out.println(getSelectedSemester());
		//List<Object []> cs = new ServiceStudent().getCourseInTermAcad(getSelectedBatch(), a_year, t_name)
		return "success";
	}
}
