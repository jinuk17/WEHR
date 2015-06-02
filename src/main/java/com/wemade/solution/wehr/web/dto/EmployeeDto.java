package com.wemade.solution.wehr.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="wehr.EmployeeDto")
@Table(name="wehr_employee")
public class EmployeeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="code")
	private String code;
	
	@Column(name="act")
	private String act;

	@Column(name="mail")
	private String mail;
	
	@Column(name="tel_no")
	private String tel;
	
	@Column(name="grade_name")
	private String gradeName;
	
	@Column(name="emp_type")
	private String empType;
	
	@Column(name="emp_status")
	private Integer empStatus;
	
	@Column(name="issue_dt")
	private Date issueDt;
	
	@Column(name="retire_dt")
	private Date retireDt;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="company_id")
	private CompanyDto companyDto;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="person_id")
	private PersonDto personDto;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="duty_id")
	private DutyDto dutyDto;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	private List<DepartmentDto> departments = new ArrayList<DepartmentDto>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}

	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	public DutyDto getDutyDto() {
		return dutyDto;
	}

	public void setDutyDto(DutyDto dutyDto) {
		this.dutyDto = dutyDto;
	}

	public List<DepartmentDto> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentDto> departments) {
		this.departments = departments;
	}
	
	public void setDepartmentDto(DepartmentDto departmentDto){
		if(this.departments == null){
			this.departments = new ArrayList<DepartmentDto>();
		}
		
		this.departments.add(departmentDto);
	}

	public Date getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(Date issueDt) {
		this.issueDt = issueDt;
	}

	public Date getRetireDt() {
		return retireDt;
	}

	public void setRetireDt(Date retireDt) {
		this.retireDt = retireDt;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public Integer getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Integer empStatus) {
		this.empStatus = empStatus;
	}
	
	
}
