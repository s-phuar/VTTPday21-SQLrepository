package VTTPday21.inclass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import VTTPday21.inclass.model.Room;
import VTTPday21.inclass.utils.sql;

@Repository
public class RoomRepository {
    @Autowired
    private JdbcTemplate template;

    //PAF day 1 slide 27
    public List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getAllRooms);

        while(sqlRowSet.next() ){
            Room rm = new Room(sqlRowSet.getInt("id"), sqlRowSet.getString("roomtype"), sqlRowSet.getFloat("price"));

            rooms.add(rm);
        }
        return rooms;
    }

    // public List<Room> getRoomsOffsetLimit(int limit, int offset){

    //     List<Room> rm = new ArrayList<>();

    //     SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getRooms_LimitOffSet, limit, offset);

    // }


}
