package com.tradeai.demand.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class DemandPositionDTO {

	private Integer demandId;

	private Integer batchId;

	private String clientId;

	private String securityId;

	private Long quantity;

	private Date dateOfDemand;

	private Date settlementDate;

	private Double clientDemandConversionPercentage;
	
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public void setDateOfDemand(String date) throws ParseException {
		
		dateOfDemand = format.parse(date);
	}
	
	public String getDateOfDemand() { 
		return format.format(dateOfDemand);
	}
	
	
public void setSettlementDate(String date) throws ParseException {
		
	settlementDate = format.parse(date);
	}
	
	public String getSettlementDate() { 
		return format.format(settlementDate);
	}
	
	

}
