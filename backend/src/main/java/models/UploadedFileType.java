package models;

import helpers.ClientFileTypeCategory;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "document_types")  // Plural table name convention
public class UploadedFileType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_type_id")
    private Integer id;  // Simplified field name

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private ClientFileTypeCategory name;

    @Column(name = "base_price_multiplier", nullable = false, precision = 3, scale = 2)
    private BigDecimal basePriceMultiplier = BigDecimal.ONE;  // Default 1.00

    @Column(name = "difficulty_level", nullable = false)
    private Integer difficultyLevel = 1;  // 1-5 scale


    @OneToMany(mappedBy = "uploadedFileTypeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ClientUploadedFile> uploadedFiles = new HashSet<>();


    // ------------------- Constructors -------------------
    public UploadedFileType() {
    }

    public UploadedFileType(ClientFileTypeCategory name, BigDecimal basePriceMultiplier, Integer difficultyLevel) {
        this.name = name;
        this.basePriceMultiplier = basePriceMultiplier;
        this.difficultyLevel = difficultyLevel;
    }

    // ------------------- Getters and Setters -------------------
    public Integer getId() {
        return id;
    }

    public ClientFileTypeCategory getName() {
        return name;
    }

    public void setName(ClientFileTypeCategory name) {
        this.name = name;
    }

    public BigDecimal getBasePriceMultiplier() {
        return basePriceMultiplier;
    }

    public void setBasePriceMultiplier(BigDecimal basePriceMultiplier) {
        this.basePriceMultiplier = basePriceMultiplier;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Set<ClientUploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(Set<ClientUploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }


    // ------------------- equals() / hashCode() -------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadedFileType that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // ------------------- toString() -------------------
    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}