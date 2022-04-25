package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int numberRoom = sc.nextInt();

		System.out.print("Data de check-in(dd/MM/yyyy): ");
		Date checkIn = dmy.parse(sc.next());

		System.out.print("Data de check-out(dd/MM/yyyy): ");
		Date checkOut = dmy.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Operação inválida. Data de check-out deve ser maior que a data de check-in");
		}

		else {
			Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reserva:" + reservation);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");

			System.out.print("Data de check-in(dd/MM/yyyy): ");
			checkIn = dmy.parse(sc.next());

			System.out.print("Data de check-out(dd/MM/yyyy): ");
			checkOut = dmy.parse(sc.next());

			Date now = new Date();
			if (now.after(checkIn) || now.after(checkOut)) {
				System.out.println(
						"Operação inválida. Data de check-out e data de check-in devem ser após a presente data.");
			}
			else if (checkIn.after(checkOut)) {
				System.out.println("Operação inválida. Data de check-out deve ser maior que a data de check-in");
			} 
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva:" + reservation);
			}
		}

		sc.close();

	}

}
