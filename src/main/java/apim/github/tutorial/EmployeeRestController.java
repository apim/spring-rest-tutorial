package apim.github.tutorial;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmployeeRestController {

	private static HashMap<Integer, Employee> empMap;

	static {
		empMap = new HashMap<>();
		Employee emp1 = new Employee();
		emp1.setEid(1);
		emp1.setEname("John");
		emp1.setEsal(125.50);
		Employee emp2 = new Employee();
		emp2.setEid(2);
		emp2.setEname("Cathy");
		emp2.setEsal(75.75);
		Employee emp3 = new Employee();
		emp3.setEid(3);
		emp3.setEname("Peter");
		emp3.setEsal(100);
		empMap.put(1, emp1);
		empMap.put(2, emp2);
		empMap.put(3, emp3);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{eid}")
	public @ResponseBody Employee findEmployee(@PathVariable("eid") int id) {
		System.out.println("Request received for id: " + id);
		return empMap.get(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save", headers = "Accept=application/json")
	public @ResponseBody String saveEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getEid() + ", " + emp.getEname() + ", " + emp.getEsal());
		return "Employee saved";
	}

}
