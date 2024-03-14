package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO)
	{
		return runner -> {
			createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		// get the instructor detail
		int theId = 3;

		System.out.println("Deleting instructor detail id : "+theId);
		 appDAO.deleteInstuctorDetailById(theId);
		System.out.println("Done..!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print instructor details
		System.out.println("tempInstructorDetail: " +tempInstructorDetail);

		//print associated instructor
		System.out.println("the associated instructor : "+ tempInstructorDetail.getInstructor());

		System.out.println("Done !!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleteing the instructor id :"+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done..!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the instructor id : "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : "+tempInstructor);

		System.out.println("the assocaited instructorDetails only :"+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor tempInstructor =
				new Instructor("vimit","moon","vimitmoon@gmail.com");
		// create the instructor details
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com/@vimitmoon5760","Singing");



			//create the instructor
			Instructor tempInstructor1 =
					new Instructor("Chad","Derby","luv2code@mail.com");
			// create the instructor details
			InstructorDetail tempInstructorDetail1 =
					new InstructorDetail("https://www.youtube.com/@chad","Coding");

			//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

		// save the instructor
		// saving the instructor will automatically save the
		// instructor details
		//
		System.out.println("saving the instructor : "+tempInstructor);
		System.out.println("saving the instructor : "+tempInstructor1);
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor1);

		System.out.println("Done!");
	}
}
