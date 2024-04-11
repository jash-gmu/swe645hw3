package edu.gmu.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_survey", nullable = false)
    private java.sql.Date dateOfSurvey;

    @Column(name = "likes", nullable = false)
    private String likes;

    @Column(name = "interest_source", nullable = false)
    private String interestSource;

    @Column(name = "recommendation_likelihood", nullable = false)
    private String recommendationLikelihood;

    // Constructors, getters, setters, toString, hashCode, and equals methods follow

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(java.sql.Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getRecommendationLikelihood() {
        return recommendationLikelihood;
    }

    public void setRecommendationLikelihood(String recommendationLikelihood) {
        this.recommendationLikelihood = recommendationLikelihood;
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state +
                ", zip=" + zip + ", telephone=" + telephone + ", email=" + email +
                ", dateOfSurvey=" + dateOfSurvey + ", likes=" + likes +
                ", interestSource=" + interestSource + ", recommendationLikelihood=" + recommendationLikelihood + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, streetAddress, city, state, zip, telephone, email, dateOfSurvey, likes, interestSource, recommendationLikelihood);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(streetAddress, other.streetAddress) &&
                Objects.equals(city, other.city) &&
                Objects.equals(state, other.state) &&
                Objects.equals(zip, other.zip) &&
                Objects.equals(telephone, other.telephone) &&
                Objects.equals(email, other.email) &&
                Objects.equals(dateOfSurvey, other.dateOfSurvey) &&
                Objects.equals(likes, other.likes) &&
                Objects.equals(interestSource, other.interestSource) &&
                Objects.equals(recommendationLikelihood, other.recommendationLikelihood);
    }
}
