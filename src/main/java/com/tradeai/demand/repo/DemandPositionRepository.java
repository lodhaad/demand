package com.tradeai.demand.repo;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tradeai.demand.datamodel.DemandPosition;


public interface DemandPositionRepository extends CrudRepository<DemandPosition, Integer> {
	
	@Query(" select max( batchId )  from DemandPosition")
	public Integer getDemandBatchId(); 
	
	public List<DemandPosition> findByBatchId(Integer batchId);
	
	public List<DemandPosition> findByClientIdAndDateOfDemand(String clientId, Date dateOfDemand);

	@Query(" select max( demandId )  from DemandPosition")
	public Integer getDemandId();

}
