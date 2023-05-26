package com.example.hotel.controller;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomRepository roomRepository;
    private RoomService roomService;

    @Autowired
    public RoomController(RoomRepository roomRepository, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }

    @Operation(summary =  "Get Room by Id")
    @GetMapping("/{id}")
    public Optional<RoomDto> getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

}
