package br.com.cybershop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clientId;
	@Column(length=800)
	@NotNull()
	@NotEmpty(message="Preencha este campo")
	private String name;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String lastname;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String cpf;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String email;
	@NotEmpty(message="Preencha este campo")
	@NotNull
	private String phoneNumber;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String password;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String genre;
	@NotNull
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date birthDate;
	@NotNull
	private boolean status;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adressCep;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adressCity;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adress_Street;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adress_State;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adressNeighborhood;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adressNumber;
	@NotNull
	@NotEmpty(message="Preencha este campo")
	private String adressComplement;
	@OneToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser() {
		this.user = new User();
		this.user.setPassword(password);
		this.user.setUsername(email);
		this.user.setRole("client");
	}
	public String getAdressNumber() {
		return adressNumber;
	}
	public void setAdressNumber(String adressNumber) {
		this.adressNumber = adressNumber;
	}
	public String getAdressComplement() {
		return adressComplement;
	}
	public void setAdressComplement(String adressComplement) {
		this.adressComplement = adressComplement;
	}
	
	
	public String getAdressCep() {
		return adressCep;
	}
	public void setAdressCep(String adressCep) {
		this.adressCep = adressCep;
	}
	public String getAdressCity() {
		return adressCity;
	}
	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}
	public String getAdress_Street() {
		return adress_Street;
	}
	public void setAdress_Street(String adress_Street) {
		this.adress_Street = adress_Street;
	}
	public String getAdress_State() {
		return adress_State;
	}
	public void setAdress_State(String adress_State) {
		this.adress_State = adress_State;
	}
	public String getAdressNeighborhood() {
		return adressNeighborhood;
	}
	public void setAdressNeighborhood(String adressNeighborhood) {
		this.adressNeighborhood = adressNeighborhood;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
