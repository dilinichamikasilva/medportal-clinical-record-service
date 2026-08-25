package com.medportal.clinical_record_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "medical_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {

    @Id
    private String id; // MongoDB uses String (ObjectId) for Auto-ID

    private Long patientId;
    private Long doctorId;
    private Long appointmentId;

    private String primaryDiagnosis;
    private String icdCode;
    private String severity;

    private List<String> symptoms;
    private String clinicalNotes;
    private LocalDateTime recordDate;

    private List<Prescription> prescriptions; // Embedded inner document list
}