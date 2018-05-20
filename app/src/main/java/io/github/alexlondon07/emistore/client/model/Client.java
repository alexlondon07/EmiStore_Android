package io.github.alexlondon07.emistore.client.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Client implements Serializable{


	@SerializedName("ide_client")
	private Long ideClient;

	@SerializedName("identification")
	private String identification;

	@SerializedName("name")
	private String name;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("cellphone")
	private String cellphone;

	@SerializedName("city")
	private String city;

	@SerializedName("enable")
	private String enable;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setIdentification(String identification){
		this.identification = identification;
	}

	public String getIdentification(){
		return identification;
	}

	public void setIdCliente(Long idCliente){
		this.ideClient = idCliente;
	}

	public Long getIdCliente(){
		return ideClient;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setEnable(String enable){
		this.enable = enable;
	}

	public String getEnable(){
		return enable;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCellphone(String cellphone){
		this.cellphone = cellphone;
	}

	public String getCellphone(){
		return cellphone;
	}

	@Override
 	public String toString(){
		return 
			"Client{" +
			"lastName = '" + lastName + '\'' + 
			",identification = '" + identification + '\'' + 
			",ideClient = '" + ideClient + '\'' +
			",city = '" + city + '\'' + 
			",enable = '" + enable + '\'' + 
			",name = '" + name + '\'' + 
			",cellphone = '" + cellphone + '\'' + 
			"}";
		}
}
