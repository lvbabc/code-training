package com.lvb.time;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class J8TimePratice {

	final Clock clock = Clock.systemUTC();
	public static void main(String args[]) {
		J8TimePratice timePratice = new J8TimePratice();
		//		timePratice.clockPractice();
		timePratice.localPractice();
		timePratice.durationPractice();
	}

	/**
	 * 第一个是Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
	 * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
	 */
	private void clockPractice() {
		// Get the system clock as UTC offset
		System.out.println(clock.instant());
		System.out.println(clock.millis());
	}

	/**
	 * 需要关注的其他类是LocaleDate与LocalTime
	 * LocaleDate只持有ISO-8601格式且无时区信息的日期部分
	 * 相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间部分
	 * LocaleDate与LocalTime都可以从Clock中得到
	 * LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间
	 * ZonedDateTime持有ISO-8601格式具有时区信息的日期与时间
	 */
	private void localPractice() {
		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now(clock);

		System.out.println(date);
		System.out.println(dateFromClock);

		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now(clock);

		System.out.println(time);
		System.out.println(timeFromClock);

		// Get the local date/time
		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);

		System.out.println(datetime.toString());
		System.out.println(datetimeFromClock);
	}

	/**
	 * ZonedDateTime持有ISO-8601格式具有时区信息的日期与时间
	 */
	private void zoneDatePractice() {
		// Get the zoned date/time
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

		System.out.println(zonedDatetime);
		System.out.println(zonedDatetimeFromClock);
		System.out.println(zonedDatetimeFromZone);
	}

	/**
	 * 在秒与纳秒级别上的一段时间。Duration使计算两个日期间的不同变的十分简单。
	 */
	private void durationPractice() {
		// Get duration between two dates
		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

		final Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println("Duration in hours: " + duration.toHours());
	}

}
