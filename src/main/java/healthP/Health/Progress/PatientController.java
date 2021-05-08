package healthP.Health.Progress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import healthP.Health.Progress.model.patient;
import healthP.Health.Progress.service.PatientService;

@RestController
@RequestMapping()
public class PatientController {
    @Autowired 
    private final PatientService paserv;

    public PatientController(PatientService paserv) {
        this.paserv = paserv;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<patient>> getAllPatients(){
        List<patient> pa = paserv.findAllPatients();
        return new ResponseEntity<>(pa, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<patient> getPatientsById(@PathVariable("id") Long id){
        patient pa = paserv.findPatientById(id);
        return new ResponseEntity<>(pa, HttpStatus.OK);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<patient> addPatient(@RequestBody patient pa) throws Exception{
        String tempEmail = pa.getEmail();
        patient objpa = null ;
        if((tempEmail != null) && (!"".equals(tempEmail))){
           objpa = paserv.findPatientByEmail(tempEmail);
            if(objpa != null){
                throw new Exception("user with "+tempEmail+" is already exists ");
            }
        }
        patient newpa = paserv.addPatient(pa);
        return new ResponseEntity<>(newpa, HttpStatus.CREATED);
    }
 /*   @PostMapping("/autheticate")
    public String generateToken(@RequestBody AuthRequest authRequest)throws Exception {
        try{
            authenticationManager.authenticate(
                new UsernamePasswordAuthentication
            )
        }
    }*/
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public void loginUser(@RequestBody patient pa) throws Exception{
        String tempEmail = pa.getEmail();
        String tempPass = pa.getPassword();
        patient objpa = null ;
        if(tempEmail != null && tempPass != null){
            objpa = paserv.findPatientByEmailAndPassword(tempEmail, tempPass);
            if(objpa == null){
                throw new Exception(" Bad credentials ");
            }
        }
    }
    @PutMapping("/update")
    public ResponseEntity<patient> updatePatient(@RequestBody patient pa){
        patient newpa = paserv.updatePatient(pa);
        return new ResponseEntity<>(newpa, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<patient> DeletePatient(@PathVariable("id") Long id){
        paserv.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
