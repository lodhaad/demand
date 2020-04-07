package com.tradeai.demand.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "demand", schema = "demand")
@IdClass(DemandPositionId.class)
public class DemandPosition {
	
	@Id
	@Column (name = "batch_id")
	private Integer batchId;
	
	@Id
	@Column (name = "position_id")
	private Integer postionId;
	
	@Column (name = "client_id")
	private String clientId;
	
	@Column (name = "security_id")
	private String securityId;
	
	@Column (name = "quantity")
	private Long quantity; 
	
	@Column (name = "date_of_demand")
	private Date dateOfDemand; 
	
	@Column (name = "date_of_settlement_date")
	private Date settlementDate;
	
	
	@Column (name = "client_conversion_percentage")
	private Double clientDemandConversionPercentage;	

}
