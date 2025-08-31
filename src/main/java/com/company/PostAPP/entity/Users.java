package com.company.PostAPP.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", schema = "crud_db")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    @Column(length = 9000)
    private String post;

    public byte[] getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(byte[] displayPicture) {
        this.displayPicture = displayPicture;
    }
@Lob
@Basic(fetch = FetchType.LAZY)
    private byte[] displayPicture;
}

