package com.psoft.SpringProject1.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psoft.SpringProject1.entity.Student;
import com.psoft.SpringProject1.entity.Country;
import com.psoft.SpringProject1.entity.EmailStatus;
import com.psoft.SpringProject1.service.Service1;

@RestController
@RequestMapping("/students")
public class Controller {

    @Autowired
    private Service1 studentService;

    @PostMapping("/ADD")
     public List<Student> createStudent(@RequestBody List<Student> students) {
        return studentService.createStudent(students);
    }
    @PostMapping("/post")
    public Student createStudent(@RequestBody Student students) {
        return studentService.createStudent(students);
    }


    @GetMapping("/GET")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student ) {
    	student.setId(id);    
        return studentService.updateStudent(student);
    }
    @PostMapping("/sendMail")
    public String sendEmail(@RequestParam String email)
    {
    return studentService.sendEmail(email);
    
}
    @PostMapping("/sendMultiple")
    public String sendEmails(@RequestBody List<String> recipients) {
        return studentService.sendEmails(recipients);
    }
   
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
         studentService.deleteStudent(id);
    }
    
//    @GetMapping("/countries")
//    public List<Map<String, Object>> getCountries() {
//        return studentService.getAllCountries();
//    }
    
    @GetMapping("/countries")
    public  List<Country> getCountries() {
        return studentService.getAllCountries();
        // Fetch and store countries
    }
    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "This is a secured endpoint. You must be authenticated.";
    }
}

