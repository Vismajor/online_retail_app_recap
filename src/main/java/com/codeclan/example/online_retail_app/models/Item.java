package com.codeclan.example.online_retail_app.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "item_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )
    private List<User> users;

    public Item(String name, String type){
        this.name = name;
        this.type = type;
        this.users = new ArrayList<>();
    }

    public Item(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
