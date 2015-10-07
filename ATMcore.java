public class ATMcore { 
	public static void main(String[] args) {
		while (true) {
			CardReader srv = new CardReader();
			int[] cardInfo = srv.run();

			System.out.println("Acct Number: "+cardInfo[0]+" Acct Type: "+cardInfo[1]);
			System.out.println("Verifying card number with pin and type.");
			
			// Magic DB lookup using the accountNumber and type as a composite pkey.... and wallah
			accountData acct = new accountData();
			
			if (acct.get_accountNumber() == cardInfo[0]) {
				System.out.println("Incredible the account number matches!");
			} else {
				System.out.println("Got a card that does not belong to an account we can access! HELP!");
				continue;
			}
			if (acct.get_type() == cardInfo[1]) {
				System.out.println("Card is of right type!");
			} else {
				System.out.println("Got a card of the wrong type! HELP!");
				continue;
			}
			
			if (!ATMcore.verifyPin(acct.get_pin(),acct)) {
				// If this failed we would keep the card.
				// In this example we will just wait for another card
				// especially as the spec does not say retaining the card!
				// Good job really as the card reader is a one shot pass
				continue;
			}
		}
  	}
	private static boolean verifyPin(int vPin,accountData acct) {
		int pinAttempts = 3;
		
		while (pinAttempts-- > 0) {
			if (Utils.getInt("Please enter your PIN.") == acct.get_pin()) {
				System.out.println("RIGHT PIN! :D");
				return true;
			} else {
				System.out.println("Wrong PIN :|");
			}
		}
		return false;
	}
}
