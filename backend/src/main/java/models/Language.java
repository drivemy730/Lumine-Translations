package models;

import helpers.LanguageFamily;
import helpers.LanguageIsoCode;
import helpers.LanguageName;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "iso_code", unique = true, nullable = false, length = 10)
    private LanguageIsoCode isoCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, length = 50)
    private LanguageName name;

    @Enumerated(EnumType.STRING)
    @Column(name = "family", length = 30)
    private LanguageFamily family;

    @Column(name = "is_rare", nullable = false)
    private boolean isRare = false;

    @OneToMany(mappedBy = "sourceLanguage", fetch = FetchType.LAZY)
    private Set<ClientUploadedFile> documentsAsSource = new HashSet<>();

    @OneToMany(mappedBy = "targetLanguage", fetch = FetchType.LAZY)
    private Set<ClientUploadedFile> documentsAsTarget = new HashSet<>();

    public Language() {
    }

    public Language(Integer id, LanguageIsoCode isoCode, LanguageName name,
                    LanguageFamily family, boolean isRare) {
        this.id = id;
        this.isoCode = isoCode;
        this.name = name;
        this.family = family;
        this.isRare = isRare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LanguageIsoCode getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(LanguageIsoCode isoCode) {
        this.isoCode = isoCode;
    }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
    }

    public LanguageFamily getFamily() {
        return family;
    }

    public void setFamily(LanguageFamily family) {
        this.family = family;
    }

    public boolean isRare() {
        return isRare;
    }

    public void setRare(boolean rare) {
        isRare = rare;
    }

    public Set<ClientUploadedFile> getDocumentsAsSource() {
        return documentsAsSource;
    }

    public void setDocumentsAsSource(Set<ClientUploadedFile> documentsAsSource) {
        this.documentsAsSource = documentsAsSource;
    }

    public Set<ClientUploadedFile> getDocumentsAsTarget() {
        return documentsAsTarget;
    }

    public void setDocumentsAsTarget(Set<ClientUploadedFile> documentsAsTarget) {
        this.documentsAsTarget = documentsAsTarget;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Language language)) return false;
        return Objects.equals(isoCode, language.isoCode);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(isoCode);
    }

    @Override
    public String toString()
    {
        return "Language{" +
                "id=" + id +
                ", isoCode=" + isoCode +
                ", name=" + name +
                ", isRare=" + isRare +
                '}';
    }
}