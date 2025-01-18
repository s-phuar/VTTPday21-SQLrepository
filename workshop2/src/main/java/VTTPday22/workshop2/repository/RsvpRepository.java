package VTTPday22.workshop2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import VTTPday22.workshop2.model.RSVP;
import VTTPday22.workshop2.model.exception.ResourceNotFoundException;
import VTTPday22.workshop2.utils.sql;

@Repository
public class RsvpRepository {
    @Autowired
    private JdbcTemplate template;


    public List<RSVP> getallRSVP(){
        List<RSVP> rsvpList = new ArrayList<>();

        rsvpList = template.query(sql.sql_getAllRSVPs, BeanPropertyRowMapper.newInstance(RSVP.class));

        return rsvpList;
    }
    
    public List<RSVP> getRelatedRsvpByName(String name){
        List<RSVP> rsvpList = new ArrayList<>();
        String wildcard = "%" + name + "%";


        rsvpList = template.query(sql.sql_getRelatedRSVPByName,BeanPropertyRowMapper.newInstance(RSVP.class), wildcard);
        if(rsvpList.isEmpty()){
            throw new ResourceNotFoundException("query: " + name + " does not match any RSVP record");
        }

        return rsvpList;
    }

    public RSVP getRsvpByEmail(String email){
        RSVP rsvp = null;

        try{
            rsvp = template.queryForObject(sql.sql_getRsvpByEmail,BeanPropertyRowMapper.newInstance(RSVP.class), email);
        }catch(DataAccessException ex){
            throw new ResourceNotFoundException("RSVP with email: " + email + " is not found");
        }
        return rsvp;
    }

    public boolean updateRSVPByEmail(RSVP rsvp){
        int rsvpUpdated = template.update(sql.sqsl_updateRsvpByEmail, rsvp.getName(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments(), rsvp.getEmail());

        if(rsvpUpdated > 0){
            return true;
        }
        return false;

    }

    public boolean insertRsvp(RSVP rsvp){
        int rsvpUpdated = template.update(sql.sql_insertRsvp, rsvp.getName(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments());

        if(rsvpUpdated > 0){
            return true;
        }
        return false;   
    }


    public int getRsvpCount(){
        Integer count = template.queryForObject(sql.sql_getRsvpCount, Integer.class);
        return count;
    }



}
