package com.tradeai.demand.repo;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tradeai.demand.datamodel.DemandPosition;
import com.tradeai.demand.datamodel.DemandPositionId;

public interface DemandPositionRepository extends CrudRepository<DemandPosition, DemandPositionId> {
	
	@Query(" select max(batchId )  from DemandPosition")
	public Integer getDemandBatchId(); 
	
	public List<DemandPosition> findByBatchId(Integer batchId);
	
	public List<DemandPosition> findByClientIdAndDateOfDemand(String clientId, Date dateOfDemand);

}
