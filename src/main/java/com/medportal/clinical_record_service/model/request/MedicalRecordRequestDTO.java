package com.medportal.clinical_record_service.model.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MedicalRecordRequestDTO {
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
    private LocalDateTime recordDate;
    private DiagnosisDetailsDTO diagnosisDetails;
    private List<PrescriptionDTO> prescriptions;

    @Data
    public static class PrescriptionDTO {
        private String medicineName;
        private String dosage;
        private String frequency;
        private String duration;
        private String instructions;
    }

    @Data
    public static class DiagnosisDetailsDTO {
        private String primaryDiagnosis;
        private String icdCode;
        private String severity;
        private List<String> symptoms;
        private String clinicalNotes;
    }
}
