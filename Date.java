
/**
 * By Arvin 
 */

public class Date{
	private int year; // [1000, 9999]
	private int month; // [1, 12]
	private int day; // [1, 31]

	public Date(int year, int month, int day){
		setDate(year, month, day);
	}
	public Date(){
		this.month = 1;
		this.day = 1;
		this.year = 1000;
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int year){
		if (year < 1000 || year > 9999){
			throw new IllegalArgumentException("Year cannot exceed 9999 or be less than 1000");
		}
		this.year = year;
	}

	public void setMonth(int month){
		if (month > 12 || month < 1){
			throw new IllegalArgumentException("Month cannot exceed 12 or be less than 1");
		}
		this.month = month;
	}

	public void setDay(int day){
		if (((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) || day > 31 || ((month == 2) && day > 29) || day < 1){
			throw new IllegalArgumentException("Month cannot exceed 30 days or 29 days if month is Febuary");
		} 		
		if (!((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) && day > 28 && month == 2){
			throw new IllegalArgumentException("It is not a leap year! so day cannot exceed 29");
		}
		this.day = day;
	}

	public String toString(){
		return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
	}

	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
}