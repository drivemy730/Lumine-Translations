package models;

import helpers.ContactMethod;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "client_documents")
public class ClientUploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_method")
    private ContactMethod contactMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_language_id", nullable = false)
    private Language sourceLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_language_id", nullable = false)
    private Language targetLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_type_id", nullable = false)
    private UploadedFileType uploadedFileTypeId;

    @Column(name = "s3_key", nullable = false, length = 512)
    private String s3Key; // AWS S3 object path

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_type", nullable = false, length = 20)
    private String fileType; // "PDF", "DOCX", etc.

    @Column(name = "word_count", nullable = false)
    private int wordCount;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false, updatable = false)
    private LocalDateTime uploadedAt;

    @OneToMany(
            mappedBy = "document",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    private Set<Quote> quotes = new HashSet<>();

    // ------------------- Constructors -------------------
    public ClientUploadedFile() {
    }

    public ClientUploadedFile(User client, ContactMethod contactMethod, Language sourceLanguage, Language targetLanguage,
                              UploadedFileType uploadedFileTypeId, String s3Key, String fileName,
                              String fileType, int wordCount) {
        this.client = client;
        this.contactMethod = contactMethod;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.uploadedFileTypeId = uploadedFileTypeId;
        this.s3Key = s3Key;
        this.fileName = fileName;
        this.fileType = fileType;
        this.wordCount = wordCount;
    }

    // ------------------- Getters and Setters -------------------
    public UUID getId() {
        return id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public ContactMethod getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(ContactMethod contactMethod) {
        this.contactMethod = contactMethod;
    }

    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Language sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public Language getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(Language targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public UploadedFileType getUploadedFileTypeId() {
        return uploadedFileTypeId;
    }

    public void setUploadedFileTypeId(UploadedFileType uploadedFileTypeId) {
        this.uploadedFileTypeId = uploadedFileTypeId;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public Set<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(Set<Quote> quotes) {
        this.quotes = quotes;
    }

    // ------------------- equals() / hashCode() -------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientUploadedFile that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ------------------- toString() -------------------
    @Override
    public String toString() {
        return "ClientDocument{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", wordCount=" + wordCount +
                ", uploadedAt=" + uploadedAt +
                '}'; // Excludes relationships for simplicity
    }
}