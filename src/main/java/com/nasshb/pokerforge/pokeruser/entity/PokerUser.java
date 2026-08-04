package com.nasshb.pokerforge.pokeruser.entity;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class PokerUser {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<PokerSession> sessions;

    public PokerUser(){}

    public PokerUser(String firstName, String lastName, String password, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public long getId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PokerSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<PokerSession> sessions) {
        this.sessions = sessions;
    }
}
