package com.psoft.SpringProject1.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "student")
public class Student {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //@Column(name = "id", nullable = false, updatable = false)
    //@Column(name="id")
    private Integer id;
   // @Column(name="name")
   // @Column(name = "name", nullable = false)
    private String name;
    
    //@Column(name="branch")
   // @Column(name = "branch", nullable = false)
    private String stream;
    private String email;
    private String status;
    
    //private String address;
    //private String course;
    
    

//    public String getCourse() {
//		return course;
//	}
//
//	public void setCourse(String course) {
//		this.course = course;
//	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Getters and Setters
    public Integer getId() {
        return id;
    }

//    public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}

