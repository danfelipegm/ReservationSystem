package service;

import model.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    private List<ConferenceRoom> availableRooms = new ArrayList<ConferenceRoom>();

    public ReservationSystem() {
        availableRooms.add(new ConferenceRoom("A1", 10));
        availableRooms.add(new ConferenceRoom("A2", 20));
    }

    public boolean reserveRoom(String roomId) {
        for (ConferenceRoom room : availableRooms) {
            if (room.getId().equals(roomId) && !room.isReserved()) {
                room.setReserved(true);
                return true;
            }
        }
        return false;
    }

    public boolean cancelReservation(String roomId) {
        for (ConferenceRoom room : availableRooms) {
            if (room.getId().equals(roomId) && room.isReserved()) {
                room.setReserved(false);
                return true;
            }
        }
        return false;
    }

    public List<ConferenceRoom> getAvailableRooms() {
        List<ConferenceRoom> result = new ArrayList<ConferenceRoom>();
        for (ConferenceRoom room : availableRooms) {
            if (!room.isReserved()) {
                result.add(room);
            }
        }
        return result;
    }
}
