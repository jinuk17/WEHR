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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="wehr.DepartmentDto")
@Table(name="wehr_department")
public class DepartmentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="end_dt")
	private Date endDt;
	
	@Column(name="act")
	private String act;
	
	@Column(name="mail")
	private String mail;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="company_id")
	@JsonIgnore
	private CompanyDto companyDto;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="parent_id")
	@JsonIgnore
	private DepartmentDto parentDto;
	
	@OneToMany(mappedBy="parentDto",fetch=FetchType.LAZY)
	private List<DepartmentDto> children = new ArrayList<DepartmentDto>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "wehr_dept_has_emp", 
			joinColumns = {@JoinColumn(name = "department_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "employee_id", nullable = false, updatable = false) })
	@JsonIgnore
	private List<EmployeeDto> employees = new ArrayList<EmployeeDto>(); 

	@Transient
	private boolean collapsed;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
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

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}

	public DepartmentDto getParentDto() {
		return parentDto;
	}

	public void setParentDto(DepartmentDto parentDto) {
		this.parentDto = parentDto;
	}

	public List<DepartmentDto> getChildren() {
		return children;
	}

	public void setChildren(List<DepartmentDto> children) {
		this.children = children;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	
	public void setEmployeeDto(EmployeeDto employeeDto){
		if(this.employees == null){
			this.employees = new ArrayList<EmployeeDto>();
		}
		
		this.employees.add(employeeDto);
	}

	public boolean isCollapsed() {
		if(parentDto == null){
			this.collapsed = false;
		}else{
			this.collapsed = true;
		}
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}
	
}
