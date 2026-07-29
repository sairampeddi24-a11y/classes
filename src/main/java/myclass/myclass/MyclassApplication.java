package myclass.myclass;


import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyclassApplication {
	
	public static org.slf4j.Logger log = LoggerFactory.getLogger(MyclassApplication.class);

	public static void main(String[] args) {
		System.out.println("hello world");
		log.info("building jenkins");
		SpringApplication.run(MyclassApplication.class, args);
	
	}

}
