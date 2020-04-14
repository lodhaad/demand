package com.tradeai.demand.input;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DemandRequest {
	
	
	
	private String clientId;

	private String securityId;

	private Long quantity;

	private String dateOfDemand;

	private String settlementDate;

	private Double clientDemandConversionPercentage;
	


	
	

}
