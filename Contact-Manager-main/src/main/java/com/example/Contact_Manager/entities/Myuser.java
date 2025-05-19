    package com.example.Contact_Manager.entities;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.hibernate.validator.constraints.UniqueElements;

    import java.util.Date;
    import java.util.List;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Myuser{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "UserId")
        private long Id;

        @Column(name = "FirstName")
        private String firstName;

        @Column(name="LastName")
        private String lastName;


        @Column(name = "Email",unique = true)
        private String email;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @Temporal(TemporalType.DATE)
        @Column(name="DOB")
        private Date dob;

        @Column(name = "Gender")
        private String gender;

        @Column(name = "Address")
        private String address;

        @Column(name = "About")
        private String about;

        @Column(name = "Password")
        @NotNull
        private String password;

        @NotNull
        @Column(name = "Repassword")
        private String repassword;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Contact> contacts;

		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRepassword() {
			return repassword;
		}

		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}

		public List<Contact> getContacts() {
			return contacts;
		}

		public void setContacts(List<Contact> contacts) {
			this.contacts = contacts;
		}
        
        

    }
