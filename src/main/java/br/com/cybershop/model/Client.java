package br.com.cybershop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clientId;
	@Column(length=800)
	private String name;
	private String lastname;
	private long cpf;
	private String email;
	private String phoneNumber;
	private String password;
	private String genre;
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date birthDate;
	private int adressCep;
	private String adressCity;
	private String adress_Street;
	private String adress_State;
	private String adressNeighborhood;
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
	
	
	public int getAdressCep() {
		return adressCep;
	}
	public void setAdressCep(int adressCep) {
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
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
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
	
	
	

}
