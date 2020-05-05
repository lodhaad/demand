package com.tradeai.demand.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradeai.demand.dto.DemandPositionDTO;
import com.tradeai.demand.input.DemandRequest;
import com.tradeai.demand.output.DemandPositionResponse;
import com.tradeai.demand.service.DemandService;

@RestController
@RequestMapping("/demand")
public class DemandPositionController {

	@Autowired
	private DemandService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(path = "/{batchId}")
	public ResponseEntity<List<DemandPositionResponse>> getDemandByBatchId(@PathVariable String batchId) {

		Integer batchIdInt = Integer.parseInt(batchId);

		List<DemandPositionDTO> list = service.getPositionsForBatch(batchIdInt);

		List<DemandPositionResponse> response = new ArrayList<DemandPositionResponse>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		

		for(DemandPositionDTO resonseElement : list ) {
			DemandPositionResponse responseEle = new DemandPositionResponse();
			responseEle.setDemandId(resonseElement.getDemandId());
			responseEle.setSecurityId(resonseElement.getSecurityId());
			
			
			
		}

		return new ResponseEntity<List<DemandPositionResponse>>(response, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping(path = "/client/{clientId}/security/{secId}/settlement-date/{settlementDate}")
	
	public ResponseEntity<List<DemandPositionResponse>> getDemandByClientAndSecurityAndSettlementDate(
			@PathVariable String clientId,
			@PathVariable String secId,
			@PathVariable String settlementDate
			
			) {
		

		List<DemandPositionDTO> list = service.getDemandByClientSecurityAndSettlementDate(clientId, settlementDate, secId);



		List<DemandPositionResponse> response = new ArrayList<DemandPositionResponse>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		

		for(DemandPositionDTO resonseElement : list ) {
			DemandPositionResponse responseEle = new DemandPositionResponse();
			responseEle.setDemandId(resonseElement.getDemandId());
			responseEle.setSecurityId(resonseElement.getSecurityId());
			
			
			
		}

		return new ResponseEntity<List<DemandPositionResponse>>(response, HttpStatus.OK);
	}

	
	
	

	@GetMapping(path = "/health")

	public String health() {
		return "running ";
	}

	@GetMapping(path = "/client/{clientId}/date/{dateOfLoad}")
	public ResponseEntity<List<DemandPositionResponse>> getDemandByClientAndDate(@PathVariable String clientId,
			@PathVariable String dateOfLoad) throws ParseException {

		List<DemandPositionDTO> list = service.getDemandPostionByClientIdAndDateOfDemand(clientId, dateOfLoad);

		List<DemandPositionResponse> response = new ArrayList<DemandPositionResponse>();

		// ModelMapper mapper =new ModelMapper();

		list.forEach(element -> {

			DemandPositionResponse responseElement = mapper.map(element, DemandPositionResponse.class);
			response.add(responseElement);

		});

		return new ResponseEntity<List<DemandPositionResponse>>(response, HttpStatus.OK);
	}
	
	

	@PostMapping(path = "/client/{clientId}/date/{dateOfLoad}")
	public ResponseEntity<List<DemandPositionResponse>> storeClientLoad(
			@Valid @RequestBody List<DemandRequest> listOfRequests) throws ParseException {

		List<DemandPositionDTO> dtoList = new ArrayList<>();

		for (DemandRequest request : listOfRequests) {
			
			DemandPositionDTO dto = new DemandPositionDTO();
			dto.setClientId(request.getClientId());
			dto.setSecurityId(request.getSecurityId());
			dto.setQuantity(request.getQuantity());
			dto.setDateOfDemand(request.getDateOfDemand());
			dto.setSettlementDate(request.getDateOfDemand());


			dtoList.add(dto);

		};

		List<DemandPositionDTO> storedList = service.storePositionBatch(dtoList);

		List<DemandPositionResponse> response = new ArrayList<DemandPositionResponse>();




		storedList.forEach(element -> {

			DemandPositionResponse responseElement = mapper.map(element, DemandPositionResponse.class);
			response.add(responseElement);

		});

		return new ResponseEntity<List<DemandPositionResponse>>(response, HttpStatus.OK);

	}

}
