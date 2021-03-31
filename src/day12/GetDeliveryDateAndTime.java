package day12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.xml.crypto.Data;

import deliveryCalculator.DeliveryCalcUtil;

/*
 * Start Date and Time
Distance
Travel speed
No of hrs working per day
holiday -list will come in enum (night 12 to 12 - 24 hrs)
sunday,jan1, jan26,aug 15,oct2
Calculate the date and time of delivery
 */
public class GetDeliveryDateAndTime {
	public static void main(String[] args) {
		DeliveryCalcUtil deliveryCalc=new DeliveryCalcUtil();
		LocalDateTime startingTime=LocalDateTime.now().withHour(23).withMinute(0).withSecond(0);
		deliveryCalc.calcDelivery(startingTime, 2400, 80, 8);
//		System.out.println(startingTime);
	}
}

