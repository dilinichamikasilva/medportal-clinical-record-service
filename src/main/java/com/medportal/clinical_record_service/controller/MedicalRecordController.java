package com.medportal.clinical_record_service.controller;

import com.medportal.clinical_record_service.entity.MedicalRecord;
import com.medportal.clinical_record_service.model.request.MedicalRecordRequestDTO;
import com.medportal.clinical_record_service.repository.MedicalRecordRepository;
import com.medportal.clinical_record_service.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService recordService;

    @PostMapping
    public ResponseEntity<MedicalRecord> createRecord(@RequestBody MedicalRecordRequestDTO record) {
        return new ResponseEntity<>(recordService.createRecord(record), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getRecordById(@PathVariable String id) {
        return ResponseEntity.ok(recordService.getRecordById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(recordService.getRecordsByPatientId(patientId));
    }
}
