package com.medportal.clinical_record_service.service;

import com.medportal.clinical_record_service.entity.MedicalRecord;
import com.medportal.clinical_record_service.model.request.MedicalRecordRequestDTO;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord createRecord(MedicalRecordRequestDTO record);
    List<MedicalRecord> getRecordsByPatientId(Long patientId);
    MedicalRecord getRecordById(String id);
    List<MedicalRecord> getAllRecords();
}