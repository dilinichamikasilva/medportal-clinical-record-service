package com.medportal.clinical_record_service.model;

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
    private String id;
    private Long patientId;
    private Long doctorId;
    private String diagnosis;
    private List<String> prescriptions;
    private LocalDateTime recordDate;
}
