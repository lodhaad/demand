package com.tradeai.demand.service;




import java.util.Date;
import java.util.List;

import com.tradeai.demand.dto.DemandPositionDTO;

public interface DemandService {
	
	public  List<DemandPositionDTO> getPositionsForBatch(Integer batchId);
	
	public List<DemandPositionDTO> storePositionBatch(List<DemandPositionDTO> postions );
	
	public List<DemandPositionDTO> getDemandPostionByClientIdAndDateOfDemand(String clientId, String dateOfLoad);

}
