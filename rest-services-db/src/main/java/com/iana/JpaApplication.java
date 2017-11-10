package com.iana;

/**
 * Created by Vrajesh Jayswal on 11/2/2017.
 */
import com.iana.sdata.domain.*;
import com.iana.sdata.repository.*;
import com.iana.sdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private IntchgRequestsRepository intchgRequestsRepository;

    @Autowired
    EntityManager em;

    @Autowired
    EmployeeAddressRepository empAddress;

    @Autowired
    EmployeeRepository emp;

    @Autowired
    EmployeeService empService;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        //testNativeQuery();
        //testOneToOne();
        //testOneToMany();
        //testManyToMany();
        //test1();
        //test5Call();
        //testUpdateChildTable();
        testCustomPojo();

    }

    private void testUpdateChild() {

    }

    private void testOneToMany() {
        IntchgRequests intchgRequests = new IntchgRequests();

        Workflow workflow = new Workflow();
        workflow.setAction("no action");
        workflow.setReqType("req type");
        Set set =  new HashSet<Workflow>();
        set.add(workflow);

        intchgRequests.setEpCompanyName("APLU");
        intchgRequests.setIntchgType("email");
        intchgRequests.setWorkflow(set);

        intchgRequestsRepository.save(intchgRequests);
    }

    private void testOneToOne() {
        Profile profile = new Profile();
        profile.setCompanyName("my company1");
        profile.setUiiaUserType("EP");

        Config config = new Config();
        config.setSenderId("sender id1");
        config.setTranType("Email");
        config.setProfile(profile);

        configRepository.save(config);
    }

    private void testManyToMany() {
        // save a couple of books
        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        Publisher publisherC = new Publisher("Publisher C");

        bookRepository.save(new HashSet<Book>(){{
            add(new Book("Book A", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherB);
            }}));

            add(new Book("Book B", new HashSet<Publisher>(){{
                add(publisherA);
                add(publisherC);
            }}));
        }});

        // fetch all books
        for(Book book : bookRepository.findAll()) {
            System.out.println("book = " + book);
        }

        // save a couple of publishers
        Book bookA = new Book("Book A");
        Book bookB = new Book("Book B");

        publisherRepository.save(new HashSet<Publisher>() {{
            add(new Publisher("Publisher A", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));

            add(new Publisher("Publisher B", new HashSet<Book>() {{
                add(bookA);
                add(bookB);
            }}));
        }});

        // fetch all publishers
        for(Publisher publisher : publisherRepository.findAll()) {
            System.out.println("publisher = " + publisher);

        }
    }

    private void testNativeQuery() {
        String sql = "SELECT USER.* FROM USER AS USER WHERE ID = ?";
        Query query = em.createNativeQuery(sql, User.class);
        query.setParameter(1, 1);
        User user = (User) query.getSingleResult();
        System.out.println("user = " + user);
        
    }

    private void testCustomPojo() {
        Query query = em.createNativeQuery(
                "SELECT p.first_name AS fName, p.last_name AS lName FROM Person p",
                "PersonDTOMapping");
        List<PersonDTO> result = query.getResultList();
        System.out.println("result = " + result);

    }

    /*private void testCustomPojo() {
        Query query = em.createNativeQuery(
                "SELECT p.first_name AS fName, p.last_name AS lName FROM Person p",
                "PersonDTOMapping");
        List<PersonDTO> result = query.getResultList();
        System.out.println("result = " + result);

    }*/

    public void test1(){
        Employee e = new Employee();
        e.setEmpName("TestName410");

        Employee_Address ea = new Employee_Address();

        ea.setCity("city410");
        ea.setStreet("street410");
        ea.setEmployee(e);

        Set<Employee_Address> eaList = new HashSet<>();
        eaList.add(ea);

        e.setEmployeeAddress(eaList);

        emp.save(e);
    }

    public void test2(){
        Employee e = new Employee();
        e.setEmpName("vipul");

        Employee_Address ea1 = new Employee_Address();

        ea1.setCity("vipulcity");
        ea1.setStreet("padra");
        ea1.setEmployee(e);

        empAddress.save(ea1);
    }

    public void test3(){
        Employee e = new Employee();
        e.setEmpName("vipul");

        emp.save(e);

    }

    public void test4(){
        Employee e = emp.findOne(1L);

        Employee_Address ea1 = new Employee_Address();

        ea1.setCity("vipulcity");
        ea1.setStreet("padra");
        ea1.setEmployee(e);

        Set<Employee_Address> eaList = new HashSet<>();
        eaList.add(ea1);

        e.setEmployeeAddress(eaList);
        emp.save(e);


    }

    public void test5(){
        //  entityManager.getTransaction().begin();

/*
        Employee e = emp.findOne(31L);
        System.out.println("e = " + e);
*/

        test5Call();

        //  entityManager.getTransaction().commit();

        /*Employee_Address ea1 = new Employee_Address();

        ea1.setCity("fdfd,,");
        ea1.setStreet("padra");
        ea1.setEmployee(e);

        Set<Employee_Address> eaList = e.getEmployeeAddress();
        eaList.add(ea1);

        e.setEmployeeAddress(eaList);
        emp.save(e);

        */


    }

    public void test5Call(){
        try {
            Employee e = empService.findOne(1L);
            System.out.println("e = " + e);
            Employee_Address ea1 = new Employee_Address();

            ea1.setCity("vadodara");
            ea1.setStreet("manjalpur");
            ea1.setEmployee(e);

            Set<Employee_Address> eaList = e.getEmployeeAddress();
            eaList.add(ea1);

            e.setEmployeeAddress(eaList);
            emp.save(e);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void testUpdateChildTable(){
        try {

            Employee_Address employeeAddress = empAddress.getOne(1L);

            employeeAddress.setCity("vadodara");
            employeeAddress.setStreet("manjalpur");

            empAddress.save(employeeAddress);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
