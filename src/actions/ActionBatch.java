package actions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;
import jpa.*;
import services.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
public class ActionBatch extends ActionSupport{
	private int ProgramId;
	private program p;
	private term_acad_id taid;
	private List<batch> BatchList;
	private File student_file;
	private List<term> existingTermList;
	private int batch_name;
	private InputStream inputStream;
	private String fileName="app";
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public term_acad_id getTaid() {
		return taid;
	}
	public void setTaid(term_acad_id taid) {
		this.taid = taid;
	}
	public int getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(int batch_name) {
		this.batch_name = batch_name;
	}
	public program getP() {
		return p;
	}
	public void setP(program p) {
		this.p = p;
	}
	public File getStudent_file() {
		return student_file;
	}
	public void setStudent_file(File student_file) {
		this.student_file = student_file;
	}
	public List<term> getExistingTermList() {
		return existingTermList;
	}
	public void setExistingTermList(List<term> existingTermList) {
		this.existingTermList = existingTermList;
	}
	public int getProgramId() {
		return ProgramId;
	}
	public void setProgramId(int programId) {
		ProgramId = programId;
	}
	public List<batch> getBatchList() {
		return BatchList;
	}
	public void setBatchList(List<batch> batchList) {
		BatchList = batchList;
	}
	
	public String getBatch() throws IOException
	{
		setBatchList(new ServiceBatch().getBatch());
		return "success";
	}
	public String addBatch() throws IOException
	{
		byte[] byte_file = new byte[(int) student_file.length()]; 

		FileInputStream fis = new FileInputStream(student_file);
		fis.read(byte_file); //read file into bytes[]
		fis.close();
		
	    batch batch_obj = new batch();
		batch_obj.setTaid(getTaid());
		batch_obj.setPbid(new program_batch_id(getProgramId(),getBatch_name()));
		batch_obj.setStudent_file(byte_file);
		new ServiceBatch().addBatch(batch_obj);
		return "done";
	}
	public String addBatchForm()
	{
		setP(new ServiceProgram().getProgramById(ProgramId));
		setExistingTermList(new ServiceTerm().getTerm());
		return "success";
	}
	public String fileDownloadBatch()
	{
		byte[] byte_data=new ServiceBatch().fileDownloadBatch(new program_batch_id(ProgramId,batch_name));
		setInputStream(new ByteArrayInputStream (byte_data));
        return "success";
	}
}
