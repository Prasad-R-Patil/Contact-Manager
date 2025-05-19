    package com.example.Contact_Manager.entities;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import jakarta.persistence.*;
    import lombok.*;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.stereotype.Controller;
    import java.util.Date;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Contact {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Contact_Id")
        private int c_id;
        private String firstName;
        private String lastName;
        @Column(name = "Phone")
        private String mb_no;
        @Column(name = "email")
        private String email;
        @Column(name = "Address")
        private String address;
        @Column(name = "Work")
        private String work;
        @Column(name = "Relation")
        private String relation;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Temporal(TemporalType.DATE)
        private Date dob;
        @Column(name = "More Information")
        private String description;
        @JoinColumn(name = "UserId")
        @ManyToOne
        @JsonBackReference
        private Myuser user;
		public int getC_id() {
			return c_id;
		}
		public void setC_id(int c_id) {
			this.c_id = c_id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMb_no() {
			return mb_no;
		}
		public void setMb_no(String mb_no) {
			this.mb_no = mb_no;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getWork() {
			return work;
		}
		public void setWork(String work) {
			this.work = work;
		}
		public String getRelation() {
			return relation;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Myuser getUser() {
			return user;
		}
		public void setUser(Myuser user) {
			this.user = user;
		}
        
    }
