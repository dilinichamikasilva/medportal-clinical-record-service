package com.medportal.clinical_record_service.controller;

import com.medportal.clinical_record_service.model.MedicalRecord;
import com.medportal.clinical_record_service.repository.MedicalRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
public class MedicalRecordController {

    private final MedicalRecordRepository recordRepository;

    public MedicalRecordController(MedicalRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @PostMapping
    public MedicalRecord createRecord(@RequestBody MedicalRecord record) {
        record.setRecordDate(LocalDateTime.now());
        return recordRepository.save(record);
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getRecordsByPatient(@PathVariable Long patientId) {
        return recordRepository.findByPatientId(patientId);
    }
}
