package com.example.hotel.service;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.mapper.RoomMapper;
import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomService() {
    }

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public RoomMapper getRoomMapper() {
        return roomMapper;
    }

    public Optional<RoomDto> getRoom(Long id) {
        final Optional<Room> roomFromRepository = roomRepository.findById(id);
        if (roomFromRepository.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(roomMapper.toDto(roomFromRepository.get()));
    }
}
