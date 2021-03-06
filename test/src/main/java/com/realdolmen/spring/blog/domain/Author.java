package com.realdolmen.spring.blog.domain;

import com.realdolmen.spring.blog.validator.AuthorConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Entity
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Column(length = 100)
    @Size(max = 100)
    private String firstName;
    @Column(length = 100)
    @Size(max = 100)
    private String lastName;
    @Column(length = 255, nullable = false)
    @NotBlank
    @Size(min = 1, max = 255)
    @AuthorConstraint
    private String email;
    @Column(length = 50, nullable = false)
    @NotBlank
    @Size(min = 1, max = 50)
    private String userName;
    @Column(length = 50, nullable = false)
    @NotBlank
    @Size(min = 1, max = 50)
    private String password;

    public Author() {
    }

    public Author(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(version, author.version) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(email, author.email) &&
                Objects.equals(userName, author.userName) &&
                Objects.equals(password, author.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, firstName, lastName, email, userName, password);
    }
}
