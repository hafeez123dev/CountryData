package com.psoft.SpringProject1.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.psoft.SpringProject1.entity.Country;
import com.psoft.SpringProject1.entity.EmailStatus;
import com.psoft.SpringProject1.entity.Student;
import com.psoft.SpringProject1.repository.CountryRepository;
import com.psoft.SpringProject1.repository.EmailRepository;
import com.psoft.SpringProject1.repository.Repository1;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service 
public class Service1 {

    @Autowired
    private Repository1 studentRepository;
    
    @Autowired
    private EmailRepository emailRepository;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private RestTemplate restTemplate;
    
//    private static final String API_URL = "https://restcountries.com/v3.1/all";
//   
//    
//    public List<Map<String, Object>> getAllCountries() {
//        Map<String, Object>[] countriesArray = restTemplate.getForObject(API_URL, Map[].class);
//        return Arrays.asList(countriesArray);
//    }
    
    @Autowired
    private CountryRepository countryRepository; // Inject Repository

    private static final String API_URL = "https://restcountries.com/v3.1/all";

    public List<Country> getAllCountries() {
        Map<String, Object>[] countriesArray = restTemplate.getForObject(API_URL, Map[].class);

        List<Country> countryList = new ArrayList<>();
        for (Map<String, Object> countryData : countriesArray) {
            Map<String, String> nameData = (Map<String, String>) countryData.get("name"); // Extract name
            String countryName = nameData.get("common"); // Country name

            Map<String, Object> iddData = (Map<String, Object>) countryData.get("idd"); // Extract IDD (calling code)
            List<String> callingCodes = iddData != null ? (List<String>) iddData.get("suffixes") : null;
            String callingCode = (callingCodes != null && !callingCodes.isEmpty()) ? "+" + callingCodes.get(0) : "N/A"; // Get the first calling code

            String region = (String) countryData.get("region");
            if (countryName != null) {
                Country country = new Country(countryName, callingCode, region);
                countryList.add(country);
            }
        }

        // Save countries to the database
        countryRepository.saveAll(countryList);

        return countryList;
    }
    
    
    public List<Student> createStudent(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String sendMail(String email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Joining Mail");
            helper.setText("Thanks for joining Psoft");

            // Define file path
            String filePath = "C:\\Users\\Md Abdul Hafeez\\Desktop\\Spring and springboot\\Spring annotations.docx";
            File file = new File(filePath);

            if (file.exists()) {
                FileSystemResource fileResource = new FileSystemResource(file);
                helper.addAttachment(file.getName(), fileResource);
            } else {
                return "File not found: " + filePath;
            }
            mailSender.send(message);
            return "Successfully sent email to " + email;
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
    
    
    
    
    
    
    
    
    public String sendEmails(List<String> recipients) {
        for (String email : recipients) {
            if (emailRepository.existsById(email)) {
                return "already sent";
            }
            sendEmail(email);
            emailRepository.save(new EmailStatus(email, "already sent"));
        }
        return "Emails sent successfully.";
    }


    public String sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("offer letter");
        message.setText("Welcome to wipro ");
        mailSender.send(message);
        return "Emails sent .";
    }
    

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
    
    
    // countries data
     
    

    

   
}
