package VTTPday22.workshop2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday22.workshop2.model.RSVP;
import VTTPday22.workshop2.repository.RsvpRepository;

@Service
public class RsvpService {
    @Autowired
    private RsvpRepository rsvpRepository;

    public List<RSVP> getallRSVP (){
        return rsvpRepository.getallRSVP();
    }

    public List<RSVP> getRelatedRsvpByName(String name){
        return rsvpRepository.getRelatedRsvpByName(name);
    }

    public RSVP getRsvpByEmail(String email){
        return rsvpRepository.getRsvpByEmail(email);
    }

    public boolean updateRSVPByEmail(RSVP rsvp){
        return rsvpRepository.updateRSVPByEmail(rsvp);
    }

    public boolean insertRsvp(RSVP rsvp){
        return rsvpRepository.insertRsvp(rsvp);
    }

    public int getRsvpCount(){
        return rsvpRepository.getRsvpCount();
    }


}
