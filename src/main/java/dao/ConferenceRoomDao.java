/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.ConferenceRoom;

/**
 *
 * @author docente
 */
public interface ConferenceRoomDao {
    List<ConferenceRoom> getAllRooms();
    ConferenceRoom getRoomById(String roomId);
    boolean updateRoom(ConferenceRoom room);
}
