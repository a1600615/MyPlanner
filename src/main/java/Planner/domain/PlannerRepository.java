package Planner.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlannerRepository extends CrudRepository<Planner, Long> {

    List<Planner>findByName(String name);
    
}
