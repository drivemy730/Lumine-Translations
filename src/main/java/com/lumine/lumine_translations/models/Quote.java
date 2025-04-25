package com.lumine.lumine_translations.models;

import com.lumine.lumine_translations.helpers.QuoteStatus;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "quote")

public class Quote
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private Integer quoteId;

    @Column(name = "client_id")
    private Integer clientId;  // FK to user (userId)

    @Enumerated(EnumType.STRING)
    @Column(name = "quote_status_enum", nullable = false)
    private QuoteStatus status;

    @Column(name = "quote_created_at", nullable = false, updatable = false, insertable = false )
    private Timestamp createdAt;

    @Column(name = "quote_last_login" )
    private Timestamp expiresAt;



    //constructors

    public Quote()
    {
    }

    public Quote(Integer quoteId, Integer clientId, QuoteStatus status, Timestamp createdAt, Timestamp expiresAt) {
        this.quoteId = quoteId;
        this.clientId = clientId;
        this.status = status;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }




    //getters and setters


    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public QuoteStatus getStatus() {
        return status;
    }

    public void setStatus(QuoteStatus status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }
}