package com.medportal.clinical_record_service.service.impl;

import com.medportal.clinical_record_service.entity.MedicalRecord;
import com.medportal.clinical_record_service.entity.Prescription;
import com.medportal.clinical_record_service.model.request.MedicalRecordRequestDTO;
import com.medportal.clinical_record_service.repository.MedicalRecordRepository;
import com.medportal.clinical_record_service.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository recordRepository;

    @Override
    public MedicalRecord createRecord(MedicalRecordRequestDTO requestDTO) {
        // Validations
        if (requestDTO.getPatientId() == null) {
            throw new IllegalArgumentException("Patient ID is required");
        }
        if (requestDTO.getDoctorId() == null) {
            throw new IllegalArgumentException("Doctor ID is required");
        }

        MedicalRecord record = new MedicalRecord();
        record.setPatientId(requestDTO.getPatientId());
        record.setDoctorId(requestDTO.getDoctorId());
        record.setAppointmentId(requestDTO.getAppointmentId());

        // Set record date or default to current server time
        record.setRecordDate(
                requestDTO.getRecordDate() != null ? requestDTO.getRecordDate() : LocalDateTime.now()
        );

        // Map Diagnosis Details
        if (requestDTO.getDiagnosisDetails() != null) {
            MedicalRecordRequestDTO.DiagnosisDetailsDTO diag = requestDTO.getDiagnosisDetails();
            record.setPrimaryDiagnosis(diag.getPrimaryDiagnosis());
            record.setIcdCode(diag.getIcdCode());
            record.setSeverity(diag.getSeverity());
            record.setSymptoms(diag.getSymptoms());
            record.setClinicalNotes(diag.getClinicalNotes());
        }

        // Map Prescriptions List
        if (requestDTO.getPrescriptions() != null && !requestDTO.getPrescriptions().isEmpty()) {
            List<Prescription> prescriptionEntities = requestDTO.getPrescriptions().stream()
                    .map(dto -> {
                        Prescription p = new Prescription();
                        p.setMedicineName(dto.getMedicineName());
                        p.setDosage(dto.getDosage());
                        p.setFrequency(dto.getFrequency());
                        p.setDuration(dto.getDuration());
                        p.setInstructions(dto.getInstructions());
                        return p;
                    })
                    .collect(Collectors.toList());

            record.setPrescriptions(prescriptionEntities);
        }

        return recordRepository.save(record);
    }

    @Override
    public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
        return recordRepository.findByPatientId(patientId);
    }

    @Override
    public MedicalRecord getRecordById(String id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical record not found with ID: " + id));
    }

    @Override
    public List<MedicalRecord> getAllRecords() {
        return recordRepository.findAll();
    }
}
