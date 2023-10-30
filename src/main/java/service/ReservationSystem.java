
package service;

import model.ConferenceRoom;
import dao.ConferenceRoomDao;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationSystem {

    private ConferenceRoomDao roomDao;

    public ReservationSystem(ConferenceRoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public boolean reserveRoom(String roomId) {
        ConferenceRoom room = roomDao.getRoomById(roomId);
        if (room != null && !room.isReserved()) {
            room.setReserved(true);
            roomDao.updateRoom(room);
            return true;
        }
        return false;
    }

    public boolean cancelReservation(String roomId) {
        ConferenceRoom room = roomDao.getRoomById(roomId);
        if (room != null && room.isReserved()) {
            room.setReserved(false);
            roomDao.updateRoom(room);
            return true;
        }
        return false;
    }

    public List<ConferenceRoom> getAvailableRooms() {
        return roomDao.getAllRooms().stream()
                .filter(room -> !room.isReserved())
                .collect(Collectors.toList());
    }

    // You can add other methods as necessary
}

