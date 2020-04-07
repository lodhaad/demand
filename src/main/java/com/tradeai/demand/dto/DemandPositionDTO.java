package com.tradeai.demand.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class DemandPositionDTO {

	private Integer batchId;

	private Integer postionId;

	private String clientId;

	private String securityId;

	private Long quantity;

	private Date dateOfDemand;

	private Date settlementDate;

	private Double clientDemandConversionPercentage;

}
