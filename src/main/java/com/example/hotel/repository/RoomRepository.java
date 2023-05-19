package com.example.hotel.repository;

import com.example.hotel.model.Room;
import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
