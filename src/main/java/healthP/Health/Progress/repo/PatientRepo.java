package healthP.Health.Progress.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import healthP.Health.Progress.model.patient;

public interface PatientRepo extends JpaRepository<patient, Long> {
 void deletePatientById(Long id)   ;
 patient findByEmail(String email);
 patient findByEmailAndPassword(String email,String pass);
 patient findPatientById(Long id);
}
