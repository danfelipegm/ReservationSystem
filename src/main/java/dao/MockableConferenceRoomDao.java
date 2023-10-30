package dao;

import model.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;

public class MockableConferenceRoomDao implements ConferenceRoomDao {

    // In a real system, these operations would interact with a database.
    // For the purpose of this exercise, we'll just use an in-memory list.

    private List<ConferenceRoom> rooms = new ArrayList<>();

    @Override
    public List<ConferenceRoom> getAllRooms() {
        return rooms;
    }

    @Override
    public ConferenceRoom getRoomById(String roomId) {
        for (ConferenceRoom room : rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public boolean updateRoom(ConferenceRoom room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId().equals(room.getId())) {
                rooms.set(i, room);
                return true;
            }
        }
        return false;
    }
}

