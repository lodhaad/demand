package com.tradeai.demand.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradeai.demand.dto.DemandPositionDTO;
import com.tradeai.demand.output.DemandPositionResponse;
import com.tradeai.demand.service.DemandService;

@RestController
@RequestMapping ("/demand")
public class DemandPositionController {
	
	@Autowired
	private DemandService service;
	
	@GetMapping(path="/{batchId}")
	public ResponseEntity<List<DemandPositionResponse>> getDemandByBatchId(@PathVariable String batchId) {
		
		Integer batchIdInt = Integer.parseInt(batchId);
		
		List<DemandPositionDTO> list = service.getPositionsForBatch(batchIdInt);
		
		List<DemandPositionResponse>  response = new ArrayList<DemandPositionResponse>();
		
		ModelMapper mapper =new ModelMapper();
		
		list.forEach(element -> {
			
			DemandPositionResponse responseElement = mapper.map(element,DemandPositionResponse.class);
			response.add(responseElement);
			
		});
		
		
		
		
		return new ResponseEntity<List<DemandPositionResponse>>(response, HttpStatus.OK);
	}
	
	@GetMapping (path = "/health")
	
	public String health() {
		return "running ";
	}

}
