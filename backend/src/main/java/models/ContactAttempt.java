package models;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "contact_attempts")
public class ContactAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Integer attemptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private ClientUploadedFile document;

    @Column(name = "occurred_at", nullable = false, updatable = false)
    private OffsetDateTime occurredAt = OffsetDateTime.now();

    // ------------------- Constructors -------------------
    public ContactAttempt() {
    }

    public ContactAttempt(User client, ClientUploadedFile document) {
        this.client = client;
        this.document = document;
    }

    // ------------------- Getters and Setters -------------------
    public Integer getAttemptId() {
        return attemptId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public ClientUploadedFile getDocument() {
        return document;
    }

    public void setDocument(ClientUploadedFile document) {
        this.document = document;
    }

    public OffsetDateTime getOccurredAt() {
        return occurredAt;
    }

    // ------------------- equals() / hashCode() -------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactAttempt that)) return false;
        return Objects.equals(attemptId, that.attemptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptId);
    }

    // ------------------- toString() -------------------
    @Override
    public String toString() {
        return "ContactAttempt{" +
                "attemptId=" + attemptId +
                ", clientId=" + (client != null ? client.getId() : null) +
                ", documentId=" + (document != null ? document.getId() : null) +
                ", occurredAt=" + occurredAt +
                '}';
    }
}