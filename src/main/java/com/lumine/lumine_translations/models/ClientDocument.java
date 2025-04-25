package com.lumine.lumine_translations.models;

import com.lumine.lumine_translations.helpers.DocumentType;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "documents")

public class ClientDocument
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private UUID  documentId;


    @Column(name = "client_id", nullable = false)
    private Integer clientId; // ( FK to user (userId))


    @Column(name = "quote_id")
    private Integer  quoteId; //  ( FK to quote (quoteId) )


    @Column(name = "document_type_id")
    private Integer documentTypeId; // ( FK to  documentType (documentTypeId) )


    @Column(name = "source_language_id")
    private Integer sourceLanguageId; // ( FK to Language (languageSourceId) )


    @Column(name = "target_language_id")
    private Integer targetLanguageId; // ( FK to Language (languageTargetId) )


    @Column(name = "s3_key")
    private  String fileS3Key;


    @Column(name = "file_name")
    private String fileName;


    @Enumerated(EnumType.STRING)
    @Column(name = "document_type_enum", nullable = false)
    private DocumentType documentType;


    @Column(name = "word_count")
    private Integer wordCount;


    @Column(name = "uploaded_at")
    private Timestamp uploadedAt;

    // constructors

    public ClientDocument() {
    }

    public ClientDocument(UUID documentId, Integer clientId, Integer quoteId, Integer documentTypeId, Integer sourceLanguageId, Integer targetLanguageId, String fileS3Key, String fileName, DocumentType documentType, Integer wordCount, Timestamp uploadedAt) {
        this.documentId = documentId;
        this.clientId = clientId;
        this.quoteId = quoteId;
        this.documentTypeId = documentTypeId;
        this.sourceLanguageId = sourceLanguageId;
        this.targetLanguageId = targetLanguageId;
        this.fileS3Key = fileS3Key;
        this.fileName = fileName;
        this.documentType = documentType;
        this.wordCount = wordCount;
        this.uploadedAt = uploadedAt;
    }



    // getters and setters

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public Integer getSourceLanguageId() {
        return sourceLanguageId;
    }

    public void setSourceLanguageId(Integer sourceLanguageId) {
        this.sourceLanguageId = sourceLanguageId;
    }

    public Integer getTargetLanguageId() {
        return targetLanguageId;
    }

    public void setTargetLanguageId(Integer targetLanguageId) {
        this.targetLanguageId = targetLanguageId;
    }

    public String getFileS3Key() {
        return fileS3Key;
    }

    public void setFileS3Key(String fileS3Key) {
        this.fileS3Key = fileS3Key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Timestamp getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Timestamp uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}