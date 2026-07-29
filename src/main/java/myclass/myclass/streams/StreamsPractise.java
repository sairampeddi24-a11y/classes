package myclass.myclass.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractise {

	static List<Employee> emps = new ArrayList<>(
			Arrays.asList(new Employee("John", "IT", 101, 50000d), new Employee("Alice", "HR", 102, 45000d),
					new Employee("Bob", "Finance", 103, 70000d), new Employee("David", "Sales", 104, 55000d),
					new Employee("Emma", "Marketing", 105, 60000d), new Employee("Frank", "IT", 106, 80000d),
					new Employee("Grace", "HR", 107, 52000d), new Employee("Henry", "Finance", 108, 90000d),
					new Employee("Ivy", "Sales", 109, 48000d), new Employee("Jack", "Marketing", 110, 75000d),
					new Employee("Kevin", "Operations", 111, 68000d), new Employee("Linda", "Support", 112, 43000d),
					new Employee("Mike", "IT", 113, 95000d), new Employee("Nancy", "Operations", 114, 62000d),
					new Employee("Oliver", "Support", 115, 57000d), new Employee("Peter", "Finance", 116, 88000d),
					new Employee("Queen", "Sales", 117, 53000d), new Employee("Robert", "Marketing", 118, 66000d),
					new Employee("Sophia", "HR", 119, 72000d), new Employee("Thomas", "IT", 120, 100000d)));

	List<Student> students = Arrays.asList(new Student(101, "John", "CSE", Arrays.asList("Java", "Spring Boot", "SQL")),
			new Student(102, "Alice", "ECE", Arrays.asList("Python", "Machine Learning", "SQL")),
			new Student(103, "Bob", "CSE", Arrays.asList("Java", "Docker", "Kubernetes")),
			new Student(104, "David", "MECH", Arrays.asList("AutoCAD", "SolidWorks")),
			new Student(105, "Emma", "CIVIL", Arrays.asList("AutoCAD", "STAAD Pro")),
			new Student(106, "Frank", "CSE", Arrays.asList("Java", "Spring Boot", "Microservices")),
			new Student(107, "Grace", "ECE", Arrays.asList("Python", "Embedded C", "Linux")),
			new Student(108, "Henry", "IT", Arrays.asList("Java", "AWS", "Docker")),
			new Student(109, "Ivy", "IT", Arrays.asList("React", "JavaScript", "HTML", "CSS")),
			new Student(110, "Jack", "CSE", Arrays.asList("Java", "Spring Boot", "Kafka")),
			new Student(111, "Kevin", "IT", Arrays.asList("Python", "AWS", "Terraform")),
			new Student(112, "Linda", "ECE", Arrays.asList("C++", "Embedded C", "Linux")),
			new Student(113, "Mike", "CSE", Arrays.asList("Java", "Redis", "Microservices")),
			new Student(114, "Nancy", "IT", Arrays.asList("Angular", "TypeScript", "HTML")),
			new Student(115, "Oliver", "MECH", Arrays.asList("SolidWorks", "ANSYS")),
			new Student(116, "Peter", "CSE", Arrays.asList("Java", "Kafka", "Docker")),
			new Student(117, "Queen", "CIVIL", Arrays.asList("Revit", "AutoCAD")),
			new Student(118, "Robert", "IT", Arrays.asList("Java", "Spring Boot", "AWS")),
			new Student(119, "Sophia", "ECE", Arrays.asList("Python", "IoT", "Linux")),
			new Student(120, "Thomas", "CSE", Arrays.asList("Java", "Spring Boot", "Kubernetes", "Docker")));

	public void getMapOfEmpByDepartAndCount() {
		Map<String, Long> count = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("count :::" + count.toString());
	}

	public void top2HigestPaidEmpInEachDept(int c) {
		Map<String, Object> top = emps.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list ->

				list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(1)
						.collect(Collectors.toList()))));
		System.out.println("count :::" + top.toString());

	}

	public void higest2ndSalaryinEachDepartment(int skipcount) {
		Map<String, Object> sal = emps.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(),
								emp -> emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
										.skip(skipcount).limit(1).collect(Collectors.toList()))));
		System.out.println("Sale " + sal.toString());

		Map<String, List<String>> sals = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.collectingAndThen(Collectors.toList(),
						emp -> emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
								.skip(skipcount).limit(1).filter(e -> e.getName() != null || !e.getName().isEmpty())
								.map(e -> e.getName()).collect(Collectors.toList()))));
		System.out.println("Sale " + sals.toString());

	}

	public void printEmployeeIdAsKeyAndValueAsEmployee() {
		Map<Integer, Employee> emp = emps.stream().collect(
				Collectors.toMap(Employee::getId, e -> e, (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2));
		System.out.println("emps " + emp.toString());
	}
	public void listOfUniqueSkills() {
		Set<String> unique = students.stream().flatMap(s -> s.getSkills().stream()).distinct().collect(Collectors.toSet());
		System.out.println("unique :"+unique.toString());
		
	}
	public void partitionBy() {
		List<Integer> nums = List.of(1,2,3,4,5,6);
		Map<Boolean,List<Integer>> num = nums.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
		System.out.println("num ::"+num.toString());
	}

	public void emp() {
		List<Employee> emm = emps.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println("emm " + emm);

	}
	public void removeduplicates() {
		String name = "peddiSairam";
		String n = name.chars().mapToObj(c -> Character.toString((char)c)).distinct().collect(Collectors.joining());
		name.chars().mapToObj(c -> (char)c).distinct().forEach(c -> System.out.print(c));
	//	System.out.println("n :"+n);
		
	}
	public void printDuplicates() {
		String name = "peddiSairam";
		Set<Character> dup = new HashSet<Character>();
	//	name.chars().mapToObj( c -> (char)c).filter( c -> !dup.add(c)).forEach(System.out :: println);
		name.chars().mapToObj( c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter( e -> e.getValue() > 1).forEach(System.out :: println);
		
	}

	public static void main(String[] args) {
		StreamsPractise sp = new StreamsPractise();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter count of limit");
//		int c = sc.nextInt();
//		System.out.println("Enter skip count");
//		int cc = sc.nextInt();
//		sp.getMapOfEmpByDepartAndCount();
//		sp.top2HigestPaidEmpInEachDept(c);
//		sp.higest2ndSalaryinEachDepartment(cc);
//		sp.printEmployeeIdAsKeyAndValueAsEmployee();
//		sp.listOfUniqueSkills();
//		sp.partitionBy();
	//	sp.emp();
	//	sp.removeduplicates();
	//	sp.printDuplicates();
		
	//	emps.stream().filter(e -> e.getSalary() > 50000).limit(1).forEach(System.out:: print);
//		Optional<Employee> emp = emps.stream().sorted(Comparator.comparing(Employee :: getSalary).reversed()).skip(1).findFirst();
//		System.out.println(emp);
	//	emps.stream().sorted(Comparator.comparing(Employee :: getSalary).thenComparing(Employee :: getName)).forEach(System.out :: println);
		
		
//		Map<String, Long> map = emps.stream()
//		        .collect(Collectors.groupingBy(
//		                Employee::getDepartment,
//		                Collectors.counting()
//		        ));
		
//		Map<String,Double> m =emps.stream().collect(Collectors.groupingBy(Employee :: getDepartment,Collectors.summingDouble(Employee :: getSalary)));
		
//		Map<String,Double> m =emps.stream().collect(Collectors.groupingBy(Employee :: getDepartment,Collectors.averagingDouble(Employee :: getSalary)));
//		System.out.println("m  "+m);
		
		Map<String,Object> mm = emps.stream().collect(Collectors.groupingBy(Employee :: getDepartment,Collectors.collectingAndThen(Collectors.toList(), e -> e.stream().
				sorted(Comparator.comparingDouble(
						                          Employee :: getSalary).reversed()).
				findFirst())));
		System.out.println(mm.toString());
		
		
		
		
	}

}

class Employee {
	String name;
	int id;
	String department;
	Double salary;

	public Employee(String name, String dept, int id, Double sal) {
		this.name = name;
		this.department = dept;
		this.id = id;
		this.salary = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", department=" + department + ", salary=" + salary + "]";
	}

}

class Student {

	private int id;
	private String name;
	private String department;
	private List<String> skills;

	public Student(int id, String name, String department, List<String> skills) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", skills=" + skills + "]";
	}

}
