package com.tradeai.demand.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.demand.datamodel.DemandPosition;
import com.tradeai.demand.dto.DemandPositionDTO;
import com.tradeai.demand.repo.DemandPositionRepository;

@Service
public class DemandServiceImpl implements DemandService {
	
	@Autowired
	private DemandPositionRepository repository;

	@Override
	public List<DemandPositionDTO> getPositionsForBatch(Integer batchId) {
		
		 List<DemandPositionDTO> list = new ArrayList<DemandPositionDTO>();
				
		 List<DemandPosition> positions = repository.findByBatchId(batchId);
		
		ModelMapper mapper = new ModelMapper();
		
		positions.forEach(element -> {
			
				DemandPositionDTO dto = mapper.map(element,DemandPositionDTO.class);
			
			
				list.add(dto);
			
			
		});
		

		return list;
	}

	@Override
	public List<DemandPositionDTO> storePositionBatch(List<DemandPositionDTO> postions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandPositionDTO> getDemandPostionByClientIdAndDateOfDemand(String clientId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
