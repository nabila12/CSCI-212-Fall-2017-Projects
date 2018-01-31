public class Date212 implements Comparable<Date212> {
	 // private instance variables. 
		private int month;
		private int day;
		private int year;
		private int date;
		
		public Date212(String date) throws IllegalArgumentException { // constructor that takes a String representing the date in yyyymmdd format. 
			//The constructor uses the substring method of class String to pull out the month, day and year, parse them as integers and puts them in the instance variables. 
			// check if date is valid
			if (isValid(date)) {// if so, breaks up the string into y,m,d
				
				this.date= Integer.parseInt(date);
				year = Integer.parseInt(date.substring(0, 4));
				month = Integer.parseInt(date.substring(4, 6));
				day = Integer.parseInt(date.substring(6,8));
			} else {
				throw new Data212Exception ("Invalid date: " + date);
			}
		}

		public Date212(int m, int d, int y) {
			String counterString = ""+year + "" + month + ""+ day;
			this.date= Integer.parseInt(counterString);//converts string into a  integers
			month = m;
			day = d;
			year = y;
		}
		
		private boolean isValid(String date) {
			int [] Day= { 31,28,31,30,31,30,31,31,30,31,30,31};
			
			// first check if it is 8 digits
			if (date.length() != 8)
				return false;
			// make sure they are all digits in the string
			for (int i = 0; i < date.length(); i++) {
				if (!Character.isDigit(date.charAt(i))) // If there is a character it will return false.
					//return false;
					throw new Data212Exception("Date can't have any characters" + date);
			}
			int y = Integer.parseInt(date.substring(0, 4)); // the first 4 numbers in the string is year and in a substring the last number is exclusive. Therefore, it is 0-4. 
			int m = Integer.parseInt(date.substring(4, 6)); //the the next 2 numbers in the string is month
			int d = Integer.parseInt(date.substring(6,8)); //the last 2 numbers in the string is day
			if (y < 0 || y > 9999 ) // to check if it is a valid year
				throw new Data212Exception("Invalid Year " + y);
			if (m > 12 || m < 1) // to check if it is a valid month
				throw new Data212Exception("Invalid Month " + m);
			if (d < 1 || d > Day[m -1]) {
				// to check if the date is valid 
				throw new Data212Exception("It is not a valid day for the month" + d);
			}
			return true; 
		}//end of isValid function
		
//		The Date212 class should have the usual set and get methods, and equals, compareTo and
//		toString methods. The toString method should print the date in "mm dd, yyyy" format (for example,
//		20171002 would be returned as 'October 2, 2017'.

			public void setMonth(int m) {
				if (m > 12 || m < 1) //to check if it is a valid month and if it is invalid it will throw a Date212Exception
					throw new Data212Exception ("Invalid month " );
				month = m;
			}
			
			public void setDay(int d) {
				if (d > 31 || d < 1) //to check if it is a valid day and if it is invalid it will throw a Date212Exception
					throw new Data212Exception("Invalid day " );
				day = d;
			}
			
			public void setYear(int y) {
				if (y> 0 || y < 2090) //to check if it is a valid year and if it is invalid it will throw a Date212Exception
					throw new Data212Exception("Invalid year " );	
				year = y;
			}
		
			public int getMonth() {
				return month;
			}
			
			public int getDay() {
				return day;
				
			}
			
			public int getYear() {
				return year;
			}
			
			public int getDate() {
				return date;
			}
			
			/*
			* Steps: 1) Test if other is null 2) Test if other is of type date 3)
			 * If the above tests pass, then cast other into type date 4) Compare
			 * month, day and year in both. If equal return true, otherwise return
			 * false
			 */
			 
		public boolean equals(Object other) {
			if(this==other)
				return true;
			if(other != null && this.getClass().equals(other.getClass())) { //checks if other is null and checks id other is of type Date.
				return this.compareTo((Date212) other) == 0;
			}
			return false;
		}

		public String toString() {//to store the month in an array and returns the full date (Month name, day, year)
			String monthName[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
			return monthName[month-1] + " " + day + ", " + year;
			
		}
		
		public int compareTo(Date212 other) { //compareTo function compares if they are not different it will return their difference and if they are equal it will check to see if the month is the as well and if the month are equal then it will compare the day.
			if(this.year != other.year) { 
				return this.year - other.year;
			}
				else if (this.month != other.year) {
					return this.month-other.month;
				}
					else {
						return this.day -other.day;
					}
			// works the same as the top.
//			if(other.getDate()< this.date) { //other date less than current date, it will return 1
//				return 1;
//			}
//				else if(other.getDate()>this.date) { //if other date greater than current date, it will return -1
//				return -1;
//				}
//					else{ // if they are equal it will return 0
//					return 0;
//					}
		}
}