public class accountData {
	int dPin = 1234;
	int dType = 2;
	int accountNumber = 20394931;
	double dBalance = 102.32;
	
	protected int get_pin() { 
		return dPin;
	}
	protected void set_pin(int pin) { 
		dPin = pin;
	}
	protected double get_balance() { 
		return dBalance;
	}
	protected void set_balance(double balance) {
		dBalance = balance;
	}
	protected double get_type() {
		return dType;
	}
	protected int get_accountNumber() {
		return accountNumber;
	}
}
