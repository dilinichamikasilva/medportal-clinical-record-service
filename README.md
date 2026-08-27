# Clinical Record Service - MedPortal

## Student Information
* **Student Name:** Dilini Chamika Silva
* **Student Number:** 241711097
* **GCP Project ID:** project-905bd1ab-9262-4481-a92

## Project Description
The **Clinical Record Service** is a core microservice of the MedPortal Enterprise Cloud Architecture system. It manages patient medical history and clinical notes, utilizing a non-relational database (MongoDB). It communicates with the centralized Config Server and registers with the Eureka Discovery Server.

## Technology Stack
* **Language:** Java 25
* **Framework:** Spring Boot, Spring Cloud
* **Database:** Non-Relational Database (MongoDB)
* **Process Management:** PM2

## API Endpoints (`/api/v1/records`)
* **POST `/api/v1/records`** - Create a new medical record
* **GET `/api/v1/records`** - Get all medical records
* **GET `/api/v1/records/{id}`** - Get medical record by ID
* **GET `/api/v1/records/patient/{patientId}`** - Get medical records by patient ID

## Setup & Getting Started Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/dilinichamikasilva/medportal-clinical-record-service.git
   ```

2. Navigate to the project directory:
   ```bash
   cd medportal-clinical-record-service
   ```

3. Grant execution permission to Maven wrapper:
   ```bash
   chmod +x mvnw
   ```

4. Build the project:
   ```bash
   ./mvnw clean package -DskipTests
   ```

5. Run the service using PM2 or Java:
   ```bash
   pm2 start java --name "clinical-record-service" -- -jar target/*.jar
   ```