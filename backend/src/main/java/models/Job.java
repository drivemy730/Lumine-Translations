package models;

import helpers.JobStatus;
import java.time.OffsetDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "job")
public class Job
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "quote_id", nullable = false, unique = true)
    private Integer quoteId; // FK to Quote (quoteId)

    @Column(name = "client_id", nullable = false)
    private Integer clientId; // FK to User

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private JobStatus status;

    @Column(name = "final_s3_key", length = 512)
    private String s3Key;

    @Column(name = "completed_at")
    private OffsetDateTime completedAt;

    // constructors

    public Job() {
    }

    public Job(Integer jobId, Integer clientId, Integer quoteId, JobStatus status, String s3Key) {
        this.jobId = jobId;
        this.clientId = clientId;
        this.quoteId = quoteId;
        this.status = status;
        this.s3Key = s3Key;
    }

    // getters and setters


    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

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

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }
}
