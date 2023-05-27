package in.rakesh;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.rakesh.comp.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	static
	{
		System.out.println("BootProj01DependencyInjectionApplication.class is loading..");
	}
	
	public BootProj01DependencyInjectionApplication() {
		System.out.println("BootProj01DependencyInjectionApplication :: zero parm constructor...");
	}
	
	@Bean
	public LocalDateTime createLocalDateTineObj()
	{
		System.out.println("BootProj01DependencyInjectionApplication.createLocalDateTineObj()");
		
		LocalDateTime ldt=LocalDateTime.now();
		return ldt;
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		
		System.out.println("Implementation class id ::"+context.getClass().getName());
		
		WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		String msg = wmg.generateWishMessage("Rakesh");
		System.out.println(msg);
	
		((ConfigurableApplicationContext) context).close();
	}

}
