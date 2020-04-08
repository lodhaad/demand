package com.tradeai.demand.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
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

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<DemandPositionDTO> getPositionsForBatch(Integer batchId) {

		List<DemandPositionDTO> list = new ArrayList<DemandPositionDTO>();

		List<DemandPosition> positions = repository.findByBatchId(batchId);

		// ModelMapper mapper = new ModelMapper();

		positions.forEach(element -> {

			DemandPositionDTO dto = mapper.map(element, DemandPositionDTO.class);

			list.add(dto);

		});

		return list;
	}

	@Override
	public List<DemandPositionDTO> storePositionBatch(List<DemandPositionDTO> postions) {

		List<DemandPosition> toSave = new ArrayList<>();

		Integer batchId = repository.getDemandBatchId();

		if (batchId != null) {
			batchId = batchId + 1;
		}

		else {
			batchId = 1;
		}

		Integer postionId = 0;

		for (DemandPositionDTO postionFromDTO : postions) {

			postionId = postionId + 1;

			postionFromDTO.setBatchId(batchId);
			postionFromDTO.setPostionId(postionId);
			DemandPosition postion = mapper.map(postionFromDTO, DemandPosition.class);
			toSave.add(postion);

		}

		Iterable<DemandPosition> response = repository.saveAll(toSave);

		return postions;
	}

	@Override
	public List<DemandPositionDTO> getDemandPostionByClientIdAndDateOfDemand(String clientId, String date) {

		// Date dateOfDemand=Date.valueOf(date);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("America/New_York"));

		Date date1 = null;
		try {
			date1 = format.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		if (date1 == null) {
			return null;
		}

		java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

		List<DemandPositionDTO> demandPostionsDTO = new ArrayList<>();

		List<DemandPosition> clientPositions = repository.findByClientIdAndDateOfDemand(clientId, date1);

		// ModelMapper map = new ModelMapper();

		clientPositions.forEach(element -> {

			DemandPositionDTO dto = mapper.map(element, DemandPositionDTO.class);
			demandPostionsDTO.add(dto);

		});

		return demandPostionsDTO;
	}

}
