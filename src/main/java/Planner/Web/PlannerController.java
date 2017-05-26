package Planner.Web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import Planner.domain.Planner;
import Planner.domain.PlannerRepository;




@Controller
public class PlannerController {
	@Autowired
	private PlannerRepository repository; 


	
	// Show all planners
	 @RequestMapping(value="/")
	    public String login() {	
	        return "login";
	    }	
	 
	 @RequestMapping(value="/login")
	    public String login1() {	
	        return "login";
	    }	
	// Show all planners
	 @RequestMapping(value="/plannerlist")
	    public String displayPlannerRecord(Model model) {
	        model.addAttribute("planner", repository.findAll());
	        return "plannerlist";
	 }


	 // Add new plans
	    // @PreAuthorize("hasAuthority('ADMIN')")
	 	@RequestMapping (value = "/add")
	 	public String addPlanner(Model model){
	 		model.addAttribute("planner", new Planner());
	 		
	 		return "addplanner";
	 	}
	 	
	 	@RequestMapping (value = "/save", method=RequestMethod.POST)
		public String Saveplanner(Planner planner){
			repository.save(planner);
			return "redirect:plannerlist";
		}
	 	
	 	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deletePlanner(@PathVariable("id") Long plannerid, Model model ){
			repository.delete(plannerid);
			return "redirect:../plannerlist";
		}
	 	
		  // RESTful service to get all plans   ,  it will show all planners in JSON form
		  @RequestMapping(value="/plannersrestful", method = RequestMethod.GET)
		  public @ResponseBody List<Planner> plannerListRest() {	
		        return (List<Planner>) repository.findAll();	
		  }

		// RESTful service to get plans by id
		    @RequestMapping(value="/plannersrestful/{id}", method = RequestMethod.GET)
		    public @ResponseBody Planner findPlannerRest(@PathVariable("id") Long plannerId) {	
		    	return repository.findOne(plannerId);	
		    }
}

	


