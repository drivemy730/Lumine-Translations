package models;

import helpers.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import java.util.Collections;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", indexes =
        {
        @Index(name = "idx_users_email", columnList = "email"),
        @Index(name = "idx_users_role", columnList = "role")
        })

public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Email
    @NotNull
    @Size(min = 5, max = 255)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 60, max = 60) // BCrypt hash length
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "role", nullable = false, length = 20)
    private UserRole role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    // ---------------- Relationships ----------------

    @OneToMany
            (
            mappedBy = "client",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.LAZY
            )

    private Set<ClientUploadedFile> clientUploadedFiles = new HashSet<>();

    @OneToMany
            (
            mappedBy = "client",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
            )
    private Set<Quote> clientQuotes = new HashSet<>();

    @OneToMany
            (
            mappedBy = "translator",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
            )
    private Set<Quote> translatorQuotes = new HashSet<>();

    @OneToMany
            (
            mappedBy = "sender",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
            )
    private Set<Message> sentMessages = new HashSet<>();

    @OneToMany
            (
            mappedBy = "receiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
            )
    private Set<Message> receivedMessages = new HashSet<>();

    // ---------------- Constructors ----------------

    public User()
    {
    }

    public User(String email, String passwordHash, UserRole role)
    {
        this.email = email;
        this.passwordHash = passwordHash != null ? passwordHash : "";
        this.role = role;
    }

    // ---------------- Getters and Setters ----------------

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash != null ? passwordHash : "";
    }

    public UserRole getRole()
    {
        return role;
    }

    public void setRole(UserRole role)
    {
        this.role = role;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public LocalDateTime getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    // ---------------- Relationship Accessors ----------------

    public Set<ClientUploadedFile> getClientDocuments()
    {
        return Collections.unmodifiableSet(clientUploadedFiles);
    }

    public void addClientDocument(ClientUploadedFile document)
    {
        clientUploadedFiles.add(document);
        document.setClient(this);
    }

    public void removeClientDocument(ClientUploadedFile document) {
        clientUploadedFiles.remove(document);
        document.setClient(null);
    }

    // (Similar add/remove methods for other relationships)

    // ---------------- equals, hashCode, toString ----------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(email, user.email); // Natural ID comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}'; // Excluded passwordHash and lastLogin
    }
}