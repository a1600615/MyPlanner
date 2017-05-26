package Plannerpackage.Planner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Planner.domain.Planner;
import Planner.domain.PlannerRepository;
import Planner.domain.User;
import Planner.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {
	
	@Autowired
	private PlannerRepository prepository;
	@Autowired
	private UserRepository urepository;
	

	//UserRepository tests. Search
	@Test
	public void findByUsernameShouldReturnUsername() {
		User thisuser = urepository.findByUsername("user");
		assertThat(thisuser.getId()).isNotNull();
		}
		
	//UserRepository tests. Create
	@Test
	public void createNewUser(){
		User user = new User("abcd","abcdefg","user");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getPasswordHash()).isNotNull();
		assertThat(user.getRole()).isNotNull();
		}
		
	//UserRepository tests. Delete
	@Test
	public void deleteUser(){
		User user = urepository.findByUsername("admin");
		assertThat(user.getId()).isNotNull();
		urepository.delete(user);
		}
	}

