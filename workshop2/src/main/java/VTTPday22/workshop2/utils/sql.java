package VTTPday22.workshop2.utils;

public class sql {
 
    
    public static final String sql_getAllRSVPs = "select * from rsvp";
    public static final String sql_getRelatedRSVPByName= "select * from rsvp where name like ?";
    public static final String sql_getRsvpByEmail = "select * from rsvp where email = ?";
    public static final String sqsl_updateRsvpByEmail = "update rsvp set name = ?, phone = ?, comments = ? where email = ?";//removed confirmation_date
    public static final String sql_insertRsvp = "insert into rsvp (name, email, phone, comments) values (?, ?, ?, ?)";
    public static final String sql_getRsvpCount = "select count(*) from rsvp";

}
