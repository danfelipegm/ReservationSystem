package model;

public class ConferenceRoom {
    private String id;
    private int capacity;
    private boolean isReserved;

    public ConferenceRoom(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.isReserved = false;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

}