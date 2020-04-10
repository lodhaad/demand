package com.tradeai.demand.dto;

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

}
