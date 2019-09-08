package apim.github.tutorial;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestCode {

	public Employee findEmployeeById(int id) {
		return new RestTemplate().getForObject("http://localhost:8080/spring-rest/services/emp/" + id, Employee.class);
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		TestCode service = (TestCode) ctx.getBean("testCode");
		Employee emp = service.findEmployeeById(2);
		System.out.println(emp.getEid() + ", " + emp.getEname() + ", " + emp.getEsal());
		ctx.close();
	}

}
