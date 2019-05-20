package com.stock.management.modal;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.NotEmpty;

//----- Sahan Part -----
@Entity
public class OpenStock {
	 final String percentage ="%";
     final String stringDenote ="s";
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id = 0;

    ZonedDateTime date;
    
    
    @NotNull(message = "valid user information")
    @Min(value = 1 ,message="valid user information")
    Integer user;
    
    
    @NotNull
    @Size(min=1, message="a reason for the entry log")
    String reason;

    @OneToMany(mappedBy = "openStock", cascade = CascadeType.ALL)
    List<OpenStockDetails> openStockDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public int getDate() {
//        return date;
//    }
//
//    public void setDate(int date) {
//        this.date = date;
//    }
    
    public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	
//    public String getUser() {
//        return user;
//    }
//
//	public void setUser(String user) {
//        this.user = user;
//    }
	
	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}
	
    public String getReason() {
        return reason;
    }

	public void setReason(String reason) {
        this.reason = reason;
    }

    public List<OpenStockDetails> getOpenStockDetails() {
        return openStockDetails;
    }

    public void setOpenStockDetails(List<OpenStockDetails> openStockDetails) {
        this.openStockDetails = openStockDetails;
    }
}
