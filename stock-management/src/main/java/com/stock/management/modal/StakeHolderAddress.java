package com.stock.management.modal;
import javax.persistence.Entity;
//nilaksha
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class StakeHolderAddress {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer id =0;
		
		String address;
		String city;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

}
