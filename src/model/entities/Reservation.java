package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();	
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}
	
	public String updateDates (Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (now.after(checkIn) || now.after(checkOut)) {
			return "Operação inválida. Data de check-out e data de check-in devem ser após a presente data.";
		}
		else if (checkIn.after(checkOut)) {
			return "Operação inválida. Data de check-out deve ser maior que a data de check-in";
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + dmy.format(checkIn) + ", check-out: " +
		dmy.format(checkOut) + ", " + duration() + " noites";
	}
	

}
