package VTTPday22.workshop2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RSVP {
    private String name;
    private String email;
    private String phone;
    private Date confirmation_date;
    private String comments;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Date getConfirmation_date() {return confirmation_date;}
    public void setConfirmation_date(Date confirmation_date) {this.confirmation_date = confirmation_date;}
    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    
    public static Date strToDate(String date) throws ParseException{
        Date convertedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        // Date convertedDate = new SimpleDateFormat("EEE, MM/dd/yyyy").parse(date);    
        return convertedDate;
    }

    
}
