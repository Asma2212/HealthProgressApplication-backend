package healthP.Health.Progress.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.UserNotFoundException;
import healthP.Health.Progress.model.patient;
import healthP.Health.Progress.repo.PatientRepo;

@Service
public class PatientService {
    private final PatientRepo paRepo ;

    @Autowired
    public PatientService(PatientRepo paRepo) {
        this.paRepo = paRepo;
    }
    
    public patient addPatient(patient pa)
    {
    pa.setCodePatient(UUID.randomUUID().toString());
    return paRepo.save(pa);
    }
    public List<patient> findAllPatients(){
        return paRepo.findAll();
    }
    public patient updatePatient(patient pa){
        return paRepo.save(pa);
    }
    public patient findPatientById(Long id){
        return paRepo.findPatientById(id);
                //.orElseThrow(() -> new UserNotFoundException("user by id"+ id +"was not found"));
    }
    public void deletePatient(Long id){
        paRepo.deletePatientById(id);
    }
    public patient findPatientByEmail(String email){
        return paRepo.findByEmail(email);
    }
    public patient findPatientByEmailAndPassword(String email,String pass){
        return paRepo.findByEmailAndPassword(email,pass);
    }


}
