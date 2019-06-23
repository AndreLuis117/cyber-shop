package br.com.cybershop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clientId;
	@Column(length=800)
	@NotNull
	private String name;
	@NotNull
	private String lastname;
	@NotNull
	private String cpf;
	@NotNull
	private String email;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String password;
	@NotNull
	private String genre;
	@NotNull
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date birthDate;
	@NotNull
	private boolean status;
	@NotNull
	private String adressCep;
	@NotNull
	private String adressCity;
	@NotNull
	private String adress_Street;
	@NotNull
	private String adress_State;
	@NotNull
	private String adressNeighborhood;
	@NotNull
	private String adressNumber;
	private String adressComplement;
	
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
