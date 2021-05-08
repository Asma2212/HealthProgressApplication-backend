package healthP.Health.Progress.model ;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;

import javax.persistence.Table;
//import org.hibernate.annotations.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name = "patient")
// @Table(name = patient.TABLE_NAME)
public class patient implements Serializable {
	// public static final String TABLE_NAME="PATIENT";
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String password;
	@Column(nullable = false, updatable = false)
	private String codePatient ;
	public patient(){}

	public patient(String codep,String name,String email,String password)
	{
		this.codePatient = codep;
		this.name=name;
		this.email=email;
		this.password=password;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getCodePatient() {
		return this.codePatient;
	}

	public void setCodePatient(String codePatient) {
		this.codePatient = codePatient;
	}
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", email='" + getEmail() + "'" +
			", password='" + getPassword() + "'" +
			"}";
	}
}