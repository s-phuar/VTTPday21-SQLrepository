package VTTPday21.inclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday21.inclass.model.Room;
import VTTPday21.inclass.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.getRooms();
    }
    

}
