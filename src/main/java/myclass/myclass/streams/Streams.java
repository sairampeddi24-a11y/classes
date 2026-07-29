package myclass.myclass.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {
	
	public static void main (String [] args) {
		
		
		// Duplicates in a list
		List<Integer> list = Arrays.asList(1,2,3,2,4,5,1,6,4);
		Set<Integer> hst = new HashSet<Integer>();
		List<Integer> dup = list.stream()
                .filter(n -> !hst.add(n))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("duplicates "+dup);	
        
        
        // Remove Duplicates In A Stream
        
        List<Integer> unique = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("unique numbers"+unique);	
        
        
        // Find First Duplicate In A Stream
        List<Integer> fristdup = list.stream()
                .filter(n -> !hst.add(n))
                .distinct().limit(1)
                .collect(Collectors.toList());

        System.out.println("frist -duplicates "+fristdup);	
        
        
        //Count Occurance Of Each Element
        List<String> fruits = Arrays.asList(
                "Apple",
                "Banana",
                "Apple",
                "Orange",
                "Banana",
                "Apple"
        );
         
//        Map<String,Integer> fuit = new HashMap<K, V>();
//        Map<String,Integer> occurance = fruits.stream().filter( n -> fuit.containsKey(n).map.g)
        
        
        class Student {

            private int id;
            private String name;
            private String department;
            private String gender;
            private int age;
            private double marks;
            private List<String> skills;

            public Student(int id, String name, String department,
                           String gender, int age,
                           double marks, List<String> skills) {
                this.id = id;
                this.name = name;
                this.department = department;
                this.gender = gender;
                this.age = age;
                this.marks = marks;
                this.skills = skills;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getDepartment() {
                return department;
            }

            public String getGender() {
                return gender;
            }

            public int getAge() {
                return age;
            }

            public double getMarks() {
                return marks;
            }

            public List<String> getSkills() {
                return skills;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", department='" + department + '\'' +
                        ", marks=" + marks +
                        '}';
            }
        }
        
        List<Student> students = Arrays.asList(

        	    new Student(101, "Rahul", "CSE", "Male", 21, 87.5,
        	            Arrays.asList("Java", "Spring", "SQL")),

        	    new Student(102, "Sneha", "ECE", "Female", 20, 91.2,
        	            Arrays.asList("Python", "Machine Learning")),

        	    new Student(103, "Arjun", "CSE", "Male", 22, 76.8,
        	            Arrays.asList("Java", "Docker")),

        	    new Student(104, "Priya", "EEE", "Female", 21, 82.6,
        	            Arrays.asList("C", "Embedded")),

        	    new Student(105, "Kiran", "CSE", "Male", 23, 95.4,
        	            Arrays.asList("Java", "Spring Boot", "AWS")),

        	    new Student(106, "Anjali", "ECE", "Female", 20, 68.5,
        	            Arrays.asList("Python", "SQL")),

        	    new Student(107, "Rohit", "Mechanical", "Male", 22, 73.9,
        	            Arrays.asList("AutoCAD", "SolidWorks")),

        	    new Student(108, "Divya", "CSE", "Female", 21, 89.8,
        	            Arrays.asList("Java", "React")),

        	    new Student(109, "Vijay", "EEE", "Male", 22, 78.1,
        	            Arrays.asList("Embedded", "IoT")),

        	    new Student(110, "Neha", "CSE", "Female", 20, 93.5,
        	            Arrays.asList("Java", "Spring", "Docker"))
        	);
        
       List<String> names =  students.stream().filter(s -> s.getAge() > 21).map( Student :: getName).limit(2).collect(Collectors.toList());
               System.out.println("names :::"+names);
               
               //Grouping  Students by Department
              Map<String, List<Student>> namess =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment));
               System.out.println("grouping by names :::"+namess);
               
               
               // //count of  Students by Department 
               Map<String, Long> count =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.counting()));
               System.out.println("count of studennt grouping by dept :::"+count);
               
               // total marks by department wise
               Map<String, Double> totalmarks =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.summingDouble(Student :: getMarks)));
               System.out.println("totalmarks of studennt grouping by dept :::"+totalmarks);
               
               // Average Marks Department wise 
               
               Map<String, Double> avgMarks =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.averagingDouble(Student :: getMarks)));
               System.out.println("Average Marks of studennt grouping by dept :::"+avgMarks);
               
               // find maximum marks students in each department
               
               Map<String, Optional<Student>> maxMarks =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.maxBy(Comparator.comparingDouble(Student :: getMarks))));
               System.out.println("Max Marks of studennt grouping by dept :::"+maxMarks);
               
              // find maximum marks students in each department name only
               
               Map<String,String> maxMarksStudnetName =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student :: getMarks)),opt -> opt.map(Student::getName).orElse("No Student               Map<String,String> maxMarksStudnetName =  students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student :: getMarks)),opt -> opt.map(Student::getName))));\n"
               		+ ""))));
               System.out.println("Max Marks of studennt grouping by dept :::"+maxMarksStudnetName);
               
               
               // Student names by department wise
               Map<String,List<String>> studentName = students.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.mapping(Student :: getName,Collectors.toList())));
               System.out.println("studnet name :::"+studentName);
               
               
               // Get student IDs department-wise.
               Map<String,List<Integer>> studentids= students.stream().collect(Collectors.groupingBy(Student :: getDepartment, Collectors.mapping(Student :: getId,Collectors.toList())));
               System.out.println("Studnet Ids ::"+studentids);
               
               //Group students by department and sort each group by marks.
               Map<String,List<Double>> studnetSort= students.stream().
            		                                          collect(Collectors.groupingBy
            		                                        		  (Student :: getDepartment, Collectors.collectingAndThen
            		                                        				  (Collectors.toList(), lists -> 
                                                                                                   lists.stream().
                                                                                                   map(Student:: getMarks).
                                                                                                   sorted(Comparator.reverseOrder()).collect(Collectors.toList()))));
               
               System.out.println("Studnet Ids ::"+studnetSort);
               
             //Group students by department and sort each group by marks higest one only.
               Map<String,Optional<Student>> higestmarksineachdept= students.stream().
            		                                          collect(Collectors.groupingBy
            		                                        		  (Student :: getDepartment,Collectors.maxBy(Comparator.comparingDouble(Student :: getMarks))));
               System.out.println("higestmarksineachdept  ::"+higestmarksineachdept);
               
               // second higest marks in each department
               Map<String, Object> secondeHigestMarks = students.stream().collect(Collectors.groupingBy(Student :: getDepartment,
            		                                                                       Collectors.collectingAndThen(Collectors.toList(), listss -> 
            		                                                                    	   listss.stream().
               		                                                                    	   sorted(Comparator.comparingDouble(Student :: getMarks).reversed()).
               		                                                                    	   skip(1).
               		                                                                    	   limit(1).collect(Collectors.toList())
            		                                                                       )));
              
               System.out.println("second higest marks in each department :"+secondeHigestMarks);
               
	}


}
