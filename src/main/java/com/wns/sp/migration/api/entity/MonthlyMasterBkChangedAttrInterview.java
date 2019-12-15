/**
 * 
 */
package com.wns.sp.migration.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entity class
 * @author Dilip
 *
 */

@Entity
@Table(name="MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW")
public class MonthlyMasterBkChangedAttrInterview implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyMasterBkChangedAttrInterview.class);
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="nvic")
	private String nvic;
	
	@Column(name="old_new_flag")
	private String oldNewFlag;

	@Column(name="family")
	private String family;

	@Column(name="year")
	private String year;

	@Column(name="bodystyle")
	private String bodyStyle;

	@Column(name="country")
	private String country;

	@Column(name="turbo")
	private String turbo;

	@Column(name="fuel")
	private String fuel;

	@Column(name="drive")
	private String drive;

	@Column(name="valid_data")
	private String validData;

	
	public MonthlyMasterBkChangedAttrInterview() {
		super();
	}

	/**
	 * @param id
	 * @param nvic
	 * @param oldNewFlag
	 * @param family
	 * @param year
	 * @param bodyStyle
	 * @param country
	 * @param turbo
	 * @param fuel
	 * @param drive
	 * @param validData
	 */
	public MonthlyMasterBkChangedAttrInterview(Long id, String nvic, String oldNewFlag, String family, String year,
			String bodyStyle, String country, String turbo, String fuel, String drive, String validData) {
		this.id = id;
		this.nvic = nvic;
		this.oldNewFlag = oldNewFlag;
		this.family = family;
		this.year = year;
		this.bodyStyle = bodyStyle;
		this.country = country;
		this.turbo = turbo;
		this.fuel = fuel;
		this.drive = drive;
		this.validData = validData;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nvic
	 */
	public String getNvic() {
		return nvic;
	}

	/**
	 * @param nvic the nvic to set
	 */
	public void setNvic(String nvic) {
		this.nvic = nvic;
	}

	/**
	 * @return the oldNewFlag
	 */
	public String getOldNewFlag() {
		return oldNewFlag;
	}

	/**
	 * @param oldNewFlag the oldNewFlag to set
	 */
	public void setOldNewFlag(String oldNewFlag) {
		this.oldNewFlag = oldNewFlag;
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the bodyStyle
	 */
	public String getBodyStyle() {
		return bodyStyle;
	}

	/**
	 * @param bodyStyle the bodyStyle to set
	 */
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the turbo
	 */
	public String getTurbo() {
		return turbo;
	}

	/**
	 * @param turbo the turbo to set
	 */
	public void setTurbo(String turbo) {
		this.turbo = turbo;
	}

	/**
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the drive
	 */
	public String getDrive() {
		return drive;
	}

	/**
	 * @param drive the drive to set
	 */
	public void setDrive(String drive) {
		this.drive = drive;
	}

	/**
	 * @return the validData
	 */
	public String getValidData() {
		return validData;
	}

	/**
	 * @param validData the validData to set
	 */
	public void setValidData(String validData) {
		this.validData = validData;
	}

		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthlyMasterBkChangedAttrInterview [id=" + id + ", nvic=" + nvic + ", oldNewFlag=" + oldNewFlag
				+ ", family=" + family + ", year=" + year + ", bodyStyle=" + bodyStyle + ", country=" + country
				+ ", turbo=" + turbo + ", fuel=" + fuel + ", drive=" + drive + ", validData=" + validData + "]";
	}
	
	
}
