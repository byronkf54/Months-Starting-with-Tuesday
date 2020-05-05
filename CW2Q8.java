public class CW2Q8 {
	int year = 1901;
	int tuesday_count = 0;

	// Array of days in each month
	int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


	int array_length(int[] months) {
		int len = 0;
		for (int month: months) {
			len++;
		}
		return len;
	}

	int modulus(int a, int b) {
		return a - (b * (a/b));
	}

	// procedure to check if the current year is a leap year
	// if so then an extra day is added to february
	void check_leap() {
		// 2000 is divisible by 4 so don't need to check century within this range
		if (modulus(year, 4) == 0) {
			months[1] = 29;
		}
		else {
			months[1] = 28;
		}
	}

	// function to go through each month of a specific year
	int get_first_days(int first_day_of_month) {
		int month = 0;
		while (month < array_length(months)) {
			if (modulus(first_day_of_month, 7) == 2) {
				tuesday_count++;
			}
			first_day_of_month = (first_day_of_month + modulus(modulus(months[month], 7), 7));
			month++;
		}
		year++;
		return first_day_of_month;
	}

	public static void main(String[] args) {
		// Instantiate class
		CW2Q8 ob = new CW2Q8();

		// First day of January 1901 is a Tuesday
		// Index of Tuesday is 1
		int first_day_of_month = 1;

		// Difference between the years
		int n = 0;
		while (n < 2000-1901) {
			ob.check_leap();
			first_day_of_month = ob.get_first_days(first_day_of_month);
			n++;
		}
		System.out.println("Tuesday count: " + ob.tuesday_count);

	}
}
