package Plannerpackage.Planner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Planner.Web.PlannerController;
import Planner.Web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlannerApplicationTests {
	
	@Autowired
	private PlannerController pcontroller;
	@Autowired
	private UserController ucontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(pcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}
}
