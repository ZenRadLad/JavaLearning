package Main;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SuppressWarnings("unused")
public class DateTimeAPI {

	public static void main(String[] args) {

		// Managing and combining below classes to a single object
			// LocalDateTime LocalDate (02/25/2020) + LocalTime (15:20:08.000000001)
				//plusDays, minusMonths ..
				// Can be used to compare dates : isBefore isAfter
			localDateAndTime();
			// Instant : instant point of time starting from 1/1/1970
				// Instant.EPOCH : start of instant with nanosecond precision
				// Can be used with Duration to increase/decrease s:m:days:months ..
				// Can be used to compare dates : isBefore isAfter
			instant();
			// TemporalAmounts :amount of time, such as"6 hours", "8 days" or "2 years and 3 months". 
				// Period : date based (years, months, days)
				// Duration : time based (hours, minutes, seconds, nanoseconds)
			//TemporalAdjusters :
				//first/last day of month/year, last friday of month/specific date..
			timeAdjusters();
	}
	
	private static void instant() {
		Instant instantEpoch = Instant.EPOCH;
		Instant instantNow = Instant.now();
		System.out.println("instant Epoch : " + instantEpoch);
		System.out.println("instant Now : " + instantNow);
		
		Instant instantHourAgo = Instant.now().minus(Duration.ofHours(1));
		Instant instantNextDay = Instant.now().plus(Duration.ofDays(1));
		Instant instantMinuteAgo = Instant.now().minusSeconds(60);
		System.out.println("instant an hour Ago : " + instantHourAgo);
		System.out.println("instant the next day : " + instantNextDay);
		System.out.println("instant a minute Ago : " + instantMinuteAgo);

		System.out.println("isBefore : " + instantMinuteAgo.isBefore(instantNow));
		System.out.println("isAfter : " + instantNextDay.isAfter(instantNow));		
	}
	
	private static void localDateAndTime() {
		LocalDateTime currentDateWithTime = LocalDateTime.now();
		System.out.println("Current localDateTime : " + currentDateWithTime );
		System.out.println("LocalDateTime toLocalDate() : " + currentDateWithTime.toLocalDate());
		System.out.println("LocalDateTime toLocalTime() : " + currentDateWithTime.toLocalTime());
		System.out.println("LocalDateTime before 30 days : " + currentDateWithTime.minusDays(30));
		System.out.println("LocalDateTime before 3 months : " + currentDateWithTime.minusMonths(3));
		System.out.println("LocalDateTime after 7 days using ChronoUnit : " + currentDateWithTime.plus(7, ChronoUnit.DAYS));
		System.out.println("LocalDateTime isBefore 1 year : " + currentDateWithTime.isBefore(currentDateWithTime.plusYears(1)));
		System.out.println("LocalDateTime isAfter 7 minutes : " + currentDateWithTime.isAfter(currentDateWithTime.minusMinutes(7)));
		System.out.println("LocalDateTime of 02/02/2020 : " + currentDateWithTime.withDayOfMonth(2).withDayOfMonth(2).withYear(2020));
		
	    System.out.println("LocalDate parsed from string : " + LocalDate.parse("2019-02-10"));

	    //TODO : 
	    	//Europe date format
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy").withZone(ZoneOffset.UTC);
		String text = localDate.format(format);
		LocalDate parsedDate = LocalDate.parse(text, format);

		System.out.println("Europe LocalDate format parsed using DateTimeFormatter : " + parsedDate);
	}

	private static void temporalAmounts() {
		Period period = Period.between(LocalDate.parse("2020-01-01"), LocalDate.now());
		System.out.println("Days elapsed since new years eve : " + (period.getMonths() * 30 + period.getDays()));

		Instant instant = Instant.now();
		System.out.println("Time 25 minutes from now : " + instant.plus(Duration.ofMinutes(25)) );
		System.out.println("Time 7 hours ago : " + instant.minus(Duration.ofHours(7)) );
	}
	
	private static void timeAdjusters() {
		  //TODO : Open days ? : 1st May, Christmas Day
	}
	
	
		
	
	
	
	
	
	
	
	
	
}