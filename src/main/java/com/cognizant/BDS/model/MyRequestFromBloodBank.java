package com.cognizant.BDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "blood_request_from_bank_mapping")
public class MyRequestFromBloodBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapping_id")
	private long id;
	@Column(name = "available_blood_id")
	private int availableBloodId;
	@JoinColumn(name = "available_blood_id")
	private String bloodGroup;	
	@JoinColumn(name = "requestor_id")
	private String firstName;
	@JoinColumn(name = "requestor_id")
	private String lastName;	
	@JoinColumn(name = "blood_bank_id")
	private String bloodBankName;
	@Column(name = "is_approved")
	private boolean approved;
	@Column(name = "is_rejected")
	private boolean rejected;
	@Column(name = "is_pending")
	private boolean pending;
	
	
	
	public MyRequestFromBloodBank() {
		super();
	}



	public MyRequestFromBloodBank(long id, int availableBloodId, String bloodGroup, String firstName, String lastName,
			String bloodBankName, boolean approved, boolean rejected, boolean pending) {
		super();
		this.id = id;
		this.availableBloodId = availableBloodId;
		this.bloodGroup = bloodGroup;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bloodBankName = bloodBankName;
		this.approved = approved;
		this.rejected = rejected;
		this.pending = pending;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getAvailableBloodId() {
		return availableBloodId;
	}



	public void setAvailableBloodId(int availableBloodId) {
		this.availableBloodId = availableBloodId;
	}



	public String getBloodGroup() {
		return bloodGroup;
	}



	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getBloodBankName() {
		return bloodBankName;
	}



	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}



	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}



	public boolean isRejected() {
		return rejected;
	}



	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}



	public boolean isPending() {
		return pending;
	}



	public void setPending(boolean pending) {
		this.pending = pending;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + availableBloodId;
		result = prime * result + ((bloodBankName == null) ? 0 : bloodBankName.hashCode());
		result = prime * result + ((bloodGroup == null) ? 0 : bloodGroup.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (pending ? 1231 : 1237);
		result = prime * result + (rejected ? 1231 : 1237);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyRequestFromBloodBank other = (MyRequestFromBloodBank) obj;
		if (approved != other.approved)
			return false;
		if (availableBloodId != other.availableBloodId)
			return false;
		if (bloodBankName == null) {
			if (other.bloodBankName != null)
				return false;
		} else if (!bloodBankName.equals(other.bloodBankName))
			return false;
		if (bloodGroup == null) {
			if (other.bloodGroup != null)
				return false;
		} else if (!bloodGroup.equals(other.bloodGroup))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pending != other.pending)
			return false;
		if (rejected != other.rejected)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "MyRequestFromBloodBank [id=" + id + ", availableBloodId=" + availableBloodId + ", bloodGroup="
				+ bloodGroup + ", firstName=" + firstName + ", lastName=" + lastName + ", bloodBankName="
				+ bloodBankName + ", approved=" + approved + ", rejected=" + rejected + ", pending=" + pending + "]";
	}
	
	

	

	
	
	

}
