# Spring Sessions

---

##  Session 1: Java & Spring Core Foundations

### Topics:
- Java SE Recap
- Installations:
  - [Java](https://www.codejava.net/java-se/download-and-install-java-11-openjdk-and-oracle-jdk)  
  - [Maven](https://phoenixnap.com/kb/install-maven-windows)
  - [IDE (IntelliJ)](https://www.jetbrains.com/idea/download/?section=linux)
- [What is the meaning of a web application?](https://aws.amazon.com/what-is/web-application/)
- [What is Maven?](https://www.marcobehler.com/guides/mvn-clean-install-a-short-guide-to-maven)
- Generate a Runnable JAR file
- [WAR vs JAR](https://www.baeldung.com/java-jar-war-packaging)
- What is Spring? Benefits of Spring Framework
- **Spring Core:**
  - IOC (Inversion of Control)
  - Dependency Injection
  - XML Configuration
  - Java-based Configuration
  - Annotations:
    - `@Component`, `@ComponentScan`, `@Configuration`, `@Bean`, `@Autowired`
  - Bean Scopes
  - `@Primary`, `@Qualifier`
  - Dynamic Bean Switching

### 📝 Task:
- Make a simple Java app and generate a runnable JAR file.
- What is a Web Service?
- REST vs SOAP

---

##  Session 2: Web Services & Spring Web

### Topics:
- Servlet
- Embedded Tomcat
- Making a Servlet Ex
- What is a Web Service?
- REST Methods (GET, POST, PUT, DELETE)
- Spring Web Starter
- DispatcherServlet
- Consume REST APIs
- Annotations:
  - `@Controller`, `@ResponseBody`, `@RestController`
  - `@RequestMethod`, `@PathVariable`, `@RequestParam`
  - `@GetMapping`, `@PostMapping`
- DTOs (Data Transfer Objects)

###  Task:
- Use **Jackson Library** to map JSON to an object using `ObjectMapper` instead of traditional setters/getters.

---

##  Session 3: Database Integration

### Topics:
- What is a Database?
- JDBC
- What is ORM?
- Introduction to Hibernate & JPA
- JPA Annotations:
  - `@Entity`, `@Table`, `@Id`, `@Column`
- Introduction to ERD (Entity Relationship Diagram)

---

##  Session 4: Spring Data JPA

### Topics:
- CRUD Operations with Spring Data JPA
- ID Generation Strategies:
  - `@GeneratedValue`, `@SequenceGenerator`, `@TableGenerator`
- Column Constraints:
  - `@Pattern`, `@NotNull`, `@Transient`
- JPA Repository:
  - `@Repository`, `@Query`
- Understanding Spring Project Folder Structure and Layers

---

##  Session 5: Advanced JPA & Relationships

### Topics:
- Entity Relationships:
  - `@OneToMany`, `@ManyToOne`
- Java Bean Validation:
  - `@NotNull`, `@Size`, `@Email`
- Jackson Bidirectional Serialization Issues
- JPA Cascading Operations
- Using `ResponseEntity`

---

##  Session 6: Caching with Redis

### Topics:
- Install and Configure Redis
- Caching in Spring Boot using Redis
- Spring Cache Annotations:
  - `@EnableCaching`
  - `@Cacheable`
  - `@CacheEvict`
 
- Global Exception Handling:
  - `@ControllerAdvice`, `@ExceptionHandler`
 
- Task self study
  Spring AOP
  - AOP Annotations:
  - `@EnableAspectJAutoProxy`
  - `@Aspect`, `@Order`
  - `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`
  - `@Pointcut`

---

##  Session 7: Spring Security Basics

### Topics:
- Spring Security Overview
- How Security Filters Work
- In-Memory User Setup
- Role-based Route Protection

---

##  Session 8 (Optional/If Time Permits): Dockerizing Spring Boot App

### Topics:
- What is Docker?
- Create Dockerfile
- Build and Run Spring Boot App in Docker Container

---

