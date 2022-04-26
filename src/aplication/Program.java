package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int numberRoom = sc.nextInt();
			System.out.print("Data de check-in(dd/MM/yyyy): ");
			Date checkIn = dmy.parse(sc.next());
			System.out.print("Data de check-out(dd/MM/yyyy): ");
			Date checkOut = dmy.parse(sc.next());
	
			Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reserva:" + reservation);
	
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data de check-in(dd/MM/yyyy): ");
			checkIn = dmy.parse(sc.next());
			System.out.print("Data de check-out(dd/MM/yyyy): ");
			checkOut = dmy.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva:" + reservation);
		}
		
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage()); // No caso, getMessage é a mensagem escrita ao instanciar a exceção na outra classe.
		}
		catch (RuntimeException e ) {
			System.out.println("Digite apenas números.");
		}
		
		
		
		
		
		sc.close();
	}
}
