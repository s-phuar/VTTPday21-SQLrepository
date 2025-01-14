package VTTPday22.workshop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTTPday22.workshop2.model.RSVP;
import VTTPday22.workshop2.model.exception.ResourceNotFoundException;
import VTTPday22.workshop2.service.RsvpService;

@RestController
@RequestMapping("/api")
public class RsvpRESTController {

    @Autowired
    private RsvpService rsvpService;

    //localhost:8080/api/rsvps
    @GetMapping(path="/rsvps", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RSVP>> getAllRSVP(){
        
        return ResponseEntity.ok().body(rsvpService.getallRSVP());
    }
    
    //localhost:8080/api/rsvp?q=frednn
    @GetMapping(path="/rsvp", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RSVP>> getRelatedRSVP(@RequestParam(name="q") String q){

        return ResponseEntity.ok().body(rsvpService.getRelatedRsvpByName(q));
    }


    //localhost:8080/api/rsvp
    @PutMapping(path="/rsvp", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Boolean> insertRsvpByEmail(
        @RequestParam MultiValueMap<String, String> form){
        
        RSVP rsvp = new RSVP();
        rsvp.setName(form.getFirst("name"));
        rsvp.setEmail(form.getFirst("email"));
        rsvp.setPhone(form.getFirst("phone"));
        rsvp.setComments(form.getFirst("comments"));

        try{
        if(rsvpService.getRsvpByEmail(form.getFirst("email"))!=null){
            //overwrite
            boolean bool = rsvpService.updateRSVPByEmail(rsvp);
            return ResponseEntity.status(201).body(bool);
        }
        }catch(ResourceNotFoundException ex){
        //insert if diff email
        boolean bool = rsvpService.insertRsvp(rsvp);

        return ResponseEntity.status(201).body(bool);
        }


        return null;

        }


    //localhost:8080/api/rsvp/samuel@gmail.com
    //use form encode for name/phone/comments/email
    @PutMapping(path="/rsvp/{email}", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Boolean> updateRsvpByEmail(
        @PathVariable(name="email") String email,
        @RequestParam MultiValueMap<String, String> form){
        
        rsvpService.getRsvpByEmail(email); //doubles as checking whether email is in database

        RSVP rsvp2 = new RSVP();
        rsvp2.setName(form.getFirst("name"));
        rsvp2.setEmail(form.getFirst("email"));
        rsvp2.setPhone(form.getFirst("phone"));
        rsvp2.setComments(form.getFirst("comments"));


        boolean bool = rsvpService.updateRSVPByEmail(rsvp2);

        return ResponseEntity.status(201).body(bool);

    }

    //localhost:8080/api/rsvps/count
    @GetMapping(path="/rsvps/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getRsvpCount(){
        int count = rsvpService.getRsvpCount();
        return ResponseEntity.status(201).body(count);
    }


}
