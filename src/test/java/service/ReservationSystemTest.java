package service;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;
    private ConferenceRoomDao conferenceRoomMock;

    @BeforeEach
    public void setUp() {
        conferenceRoomMock = mock(ConferenceRoomDao.class);
        system = new ReservationSystem(conferenceRoomMock);
    }

    @Test
    public void testReserveRoomWhenIsFalse() {
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(null);
        assertEquals(false, system.reserveRoom("A1"));
        
    }
    
    @Test
    public void testReserveRoomWhenIsTrue() {
        ConferenceRoom conferenceRoomBeta = new ConferenceRoom("A1", 5);
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(conferenceRoomBeta);
        assertEquals(true, system.reserveRoom("A1"));
        
    }

    @Test
    public void testCancelReservationWhenIsFalse() {
        when(conferenceRoomMock.getRoomById("A2")).thenReturn(null);
        assertEquals(false,system.cancelReservation("A2"));
    }
    
    @Test
    public void testCancelReservationWhenIsTrue() {
        ConferenceRoom conferenceRoomAlpha = new ConferenceRoom("A2", 5);
        conferenceRoomAlpha.setReserved(true);
        when(conferenceRoomMock.getRoomById("A2")).thenReturn(conferenceRoomAlpha);
        assertEquals(true,system.cancelReservation("A2"));
    }

    // Puedes añadir más pruebas según lo consideres necesario
}
