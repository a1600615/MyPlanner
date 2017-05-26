package Planner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Planner.domain.Planner;
import Planner.domain.PlannerRepository;
import Planner.domain.User;
import Planner.domain.UserRepository;


@SpringBootApplication
public class PlannerApplication {
	private static final Logger log = LoggerFactory.getLogger(PlannerApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(PlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner plannerDemo(PlannerRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("save some plans");
	
			repository.save(new Planner("Bank","09,10,2017", "10:00","Dont forget your Id"));
			repository.save(new Planner("coffee","12,05,2017", "10:00","Dont forget cash"));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all plans");
			for (Planner planner : repository.findAll()) {
				log.info(planner.toString());
			}

		};
	}
}
