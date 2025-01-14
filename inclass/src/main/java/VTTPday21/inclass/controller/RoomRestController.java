package VTTPday21.inclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTTPday21.inclass.model.Room;
import VTTPday21.inclass.service.RoomService;

@RestController
@RequestMapping
public class RoomRestController {
    @Autowired
    RoomService roomService;

    @GetMapping("/api/rooms")
    public ResponseEntity<List<Room>> getAllRoom(){
        List<Room> rooms = roomService.getAllRooms();

        return ResponseEntity.ok().body(rooms);
    }


}
