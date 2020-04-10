package com.tradeai.demand.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

public class DemandPositionResponse {
	
	private Integer demandId;

	private Integer batchId;

	private String clientId;

	private String securityId;

	private Long quantity;

	private String dateOfDemand;

	private String settlementDate;

	private Double clientDemandConversionPercentage;


}
