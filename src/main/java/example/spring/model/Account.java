package example.spring.model;

import example.spring.model.enams.Gender;

import java.time.LocalDate;
import java.util.Objects;


public class Account {
    private String firstName;
    private String lastName;
    private String country;
    private LocalDate birthday;
    private Double balance;
    private Gender gender;
  
    public Account(String firstName, String lastName, String country, LocalDate birthday, Double balance, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthday = birthday;
        this.balance = balance;
        this.gender = gender;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return  Double.compare(balance, account.balance) == 0 &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(country, account.country) &&
                Objects.equals(birthday, account.birthday) &&
                Objects.equals(gender, account.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country, birthday, balance, gender);
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", birthday='" + birthday + '\'' +
                ", balance=" + balance +
                ", gender='" + gender + '\'' +
                '}';
    }
}

