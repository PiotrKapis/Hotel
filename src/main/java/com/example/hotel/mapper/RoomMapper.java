package com.example.hotel.mapper;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomDto toDto(Room room) {
        return new RoomDto(
                room.getRoomId(),
                room.getNumberOfBeds(),
                room.getPrice(),
                room.getStandard(),
                room.getRoomNumber()
        );
    }
}
