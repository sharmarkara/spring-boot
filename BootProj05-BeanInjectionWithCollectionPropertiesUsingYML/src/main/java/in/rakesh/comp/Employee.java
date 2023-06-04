package in.rakesh.comp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "employee")
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
	private String name;
	private long id;
	private Company company;
	private String[] skillSet;
	private List<String> projectNames;
	private Set<Long> mobileNumbers;
	private Map<String, Object> idDetails;

	
	
	public Map<String, Object> getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}

	public Set<Long> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<Long> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public List<String> getProjectNames() {
		return projectNames;
	}

	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}

	public String[] getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", company=" + company + ", skillSet="
				+ Arrays.toString(skillSet) + ", projectNames=" + projectNames + ", mobileNumbers=" + mobileNumbers
				+ ", idDetails=" + idDetails + "]";
	}

}
