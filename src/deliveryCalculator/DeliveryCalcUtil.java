package deliveryCalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


interface DeliveryCalculator{
	public LocalDateTime calcDelivery(LocalDateTime startDateAndTime,int distance,int travelSpeed,int workingHrsPerDay);
}
public class DeliveryCalcUtil implements DeliveryCalculator{
	@Override
	public  LocalDateTime calcDelivery(LocalDateTime startDateAndTime, int distance, int travelSpeed,int workingHrsPerDay) {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		double totalSecsRequiredForDelivery=((double)distance/(double)travelSpeed)*60*60;
		while(totalSecsRequiredForDelivery>0) {
//			System.out.println(startDateAndTime.format(myFormatObj)+" "+totalSecsRequiredForDelivery/60/60);
			if(isHoliday(startDateAndTime)) {
				startDateAndTime=startDateAndTime.plus(1,ChronoUnit.DAYS);
			}else {
				if(totalSecsRequiredForDelivery>workingHrsPerDay*60*60) {
					int tempDate=startDateAndTime.getDayOfMonth();
					startDateAndTime=startDateAndTime.plus(workingHrsPerDay*60*60,ChronoUnit.SECONDS);
					if(tempDate<startDateAndTime.getDayOfMonth() && startDateAndTime.getHour()>0) {
						long extraTime=(startDateAndTime.getHour()*60*60)+(startDateAndTime.getMinute()*60)+startDateAndTime.getSecond();
						totalSecsRequiredForDelivery+=extraTime;
						startDateAndTime=startDateAndTime.withDayOfMonth(tempDate);
					}
					startDateAndTime=startDateAndTime.plus(1,ChronoUnit.DAYS).withHour(0).withMinute(0).withSecond(0);
					totalSecsRequiredForDelivery-=workingHrsPerDay*60*60;
				}else {
					int tempDate=startDateAndTime.getDayOfMonth();
					startDateAndTime=startDateAndTime.plus((long)totalSecsRequiredForDelivery,ChronoUnit.SECONDS);
					if(tempDate<startDateAndTime.getDayOfMonth() && startDateAndTime.getHour()>0) {
						long extraTime=(startDateAndTime.getHour()*60*60)+(startDateAndTime.getMinute()*60)+startDateAndTime.getSecond();
						totalSecsRequiredForDelivery-=(totalSecsRequiredForDelivery-extraTime);
						startDateAndTime=startDateAndTime.withDayOfMonth(tempDate).plus(1,ChronoUnit.DAYS).withHour(0).withMinute(0).withSecond(0);
					}else {						
						totalSecsRequiredForDelivery-=workingHrsPerDay*60*60;
					}
				}
			}
		}
		System.out.println("The product will be delivered on : "+startDateAndTime.format(myFormatObj));
		return startDateAndTime;
	}
	public boolean isHoliday(LocalDateTime date) {
		for(Holidays holidays:Holidays.values()) {
			if(holidays.getHoliday()==null && date.getDayOfWeek().toString().equalsIgnoreCase(holidays.name())) {
					return true;
			}else if(holidays.getHoliday()!=null && date.getMonth()==holidays.getHoliday().getMonth() && date.getDayOfMonth()==holidays.getHoliday().getDayOfMonth()) {
				return true;
			}
		}
		return false;
	}
	enum Holidays{
		sunday(),
		Jan1(LocalDate.now().withMonth(1).withDayOfMonth(1)),
		Jan26(LocalDate.now().withMonth(1).withDayOfMonth(26)),
		Aug15(LocalDate.now().withMonth(8).withDayOfMonth(15)),
		Oct2(LocalDate.now().withMonth(11).withDayOfMonth(2));
		private LocalDate holiday;
		Holidays(LocalDate date){
			this.holiday=date;
		}
		Holidays(){
			
		}
		public LocalDate getHoliday() {
			return this.holiday;
		}
	}
}
