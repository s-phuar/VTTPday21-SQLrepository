package VTTPday21.inclass.model;

import java.sql.Date;

public class Reservation {
    private int id;
    private Customer customer;
    private Room room;
    private Date start_date;
    private Date end_date;
    private float cost;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}

    
    public Date getStart_date() {return start_date;}
    public void setStart_date(Date start_date) {this.start_date = start_date;}
    public Date getEnd_date() {return end_date;}
    public void setEnd_date(Date end_date) {this.end_date = end_date;}
    public float getCost() {return cost;}
    public void setCost(float cost) {this.cost = cost;}

    
    

}
