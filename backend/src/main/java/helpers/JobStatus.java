package helpers;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public enum JobStatus
{
    IN_PROGRESS("in_progress", "Translation in progress"),
    COMPLETED("completed", "Job delivered"),
    UNDER_REVIEW("under_review", "Client reviewing translation"),
    DISPUTED("disputed", "Quality dispute opened"),
    CANCELLED("cancelled", "Job cancelled");

    private final String dbCode; // Database storage value
    private final String displayName; // UI/frontend display

    JobStatus(String dbCode, String displayName)
    {
        this.dbCode = dbCode;
        this.displayName = displayName;
    }

    // JPA Converter
    @Converter(autoApply = true)
    public static class Converter implements AttributeConverter<JobStatus, String>
    {
        @Override
        public String convertToDatabaseColumn(JobStatus status)
        {
            return status.dbCode;
        }

        @Override
        public JobStatus convertToEntityAttribute(String dbCode)
        {
            return Arrays.stream(values())
                    .filter(s -> s.dbCode.equals(dbCode))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid status: " + dbCode));
        }
    }
}