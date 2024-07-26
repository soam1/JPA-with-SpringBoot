package com.akashsoam.bootJpaExample;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.akashsoam.bootJpaExample.dao.UserRepository;
import com.akashsoam.bootJpaExample.entities.User;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BootJpaExampleApplication.class, args);
		UserRepository  userRepository= context.getBean(UserRepository.class);
		User user = new User();
		user.setName("Akash");
		user.setCity("Delhi");
		user.setStatus("I am java programmer");
		
//		User user1 = userRepository.save(user);
		
//		System.out.println(user1);
		
		
		User user2 = new User();
		user2.setName("Akash");
		user2.setCity("Meerut");
		user2.setStatus("I am python programmer");
		
//		User resultUser = userRepository.save(user2);
//		System.out.println("saved the user" + resultUser);
//		System.out.println("Done");
		
		List<User> result = userRepository.saveAll(List.of(user,user2));
		result.forEach(u-> {
			System.out.println(u);
		});
		
		
		//update the user
//		userRepository.findById(1);
		Optional<User> optional = userRepository.findById(1);
		User user3 = optional.get();
		user3.setName("Akash Soam");
		userRepository.save(user3);
		System.out.println(user3);
		
		
		
		
		//how to get the data
//		findById(id); - return Optional container having your data
		userRepository.findAll().forEach(u -> {
			System.out.println(u);
		});
		
		
		//delete the user
		userRepository.deleteById(202);
		userRepository.delete(user2);
//		userRepository.deleteAll(); //delete all the data
		((ConfigurableApplicationContext) context).close();
		
		
		
	}

}
 