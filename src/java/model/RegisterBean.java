/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class RegisterBean {
    
    private int id;
    private String email;
    private String name;
    private String subject;
    private String message;
    private String entryDate;

    public RegisterBean() {
    }

    public RegisterBean(int id, String email, String name, String subject, String message, String entryDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.entryDate = entryDate;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "RegisterBean{" + "id=" + id + ", email=" + email + ", name=" + name + ", subject=" + subject + ", message=" + message + ", entryDate=" + entryDate + '}';
    }
    
    
}
