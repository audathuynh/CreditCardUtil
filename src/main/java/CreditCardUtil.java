
public class CreditCardUtil {
	public static final String AMEX = "AMEX";
	public static final String VISA = "VISA";
	public static final String MASTERCARD = "MasterCard";
	public static final String DISCOVER = "Discover";
	public static final String UNKNOWN = "Unknown";
	
	/**
	 * Check if a credit card number is valid.
	 * Spaces or tabs can be in the card number.
	 * @param cardNumber Credit card number.
	 * @return true if the card is valid, false otherwise.
	 */
	public static boolean luhnCheck(String cardNumber) {
		cardNumber = cardNumber.replaceAll("\\p{Blank}", "");

		int sum = 0;
		boolean flag = false; //false: untouch a digit; true: double a digit.

		for (int i=cardNumber.length()-1; i >= 0; i--){
			int digit = 0;
			try {
				digit = Integer.parseInt(""+cardNumber.charAt(i));
			} catch (NumberFormatException ex){
				return false;
			}
			if (flag) {
				digit *= 2;
				if (digit > 9) {
					digit = (digit % 10) + 1;
				}
			}
			sum += digit;
			flag = !flag; // toggle the flag to double or untouch a digit.
		}
		return sum % 10 == 0;
	}

	/**
	 * Get the type of a credit card number.
	 * Spaces or tabs can be in the card number.
	 * +============+=============+===============+
	 * | Card Type  | Begins With | Number Length |
	 * +============+=============+===============+
	 * | AMEX       | 34 or 37    | 15            |
	 * +------------+-------------+---------------+
	 * | VISA       | 4           | 13 or 16      |
	 * +------------+-------------+---------------+
	 * | MasterCard | 51-55       | 16            |
	 * +------------+-------------+---------------+
	 * | Discover   | 6011        | 16            |
	 * +------------+-------------+---------------+
	 * @param cardNumber Credit card number
	 * @return Type of credit card
	 */
	public static String getCardType(String cardNumber) {
		cardNumber = cardNumber.replaceAll("\\p{Blank}", "");

		int len = cardNumber.length();
		// cards with the prefix '3'
		if (cardNumber.charAt(0) == '3' && len == 15) {
			char c = cardNumber.charAt(1);
			if (c == '4' || c == '7'){
				return AMEX;
			}
			return UNKNOWN;
		}
		// cards with the prefix '4'
		if (cardNumber.charAt(0) == '4') {
			if (len == 13 || len == 16) {
				return VISA;
			}
			return UNKNOWN;
		}
		// cards with the prefix '5'
		if (cardNumber.charAt(0) == '5' && len == 16) {
			char c = cardNumber.charAt(1);
			if ('1' <= c && c <= '5') {
				return MASTERCARD;
			}
			return UNKNOWN;
		}
		// cards with the prefix '6'
		if (len == 16 && cardNumber.substring(0, 4).equals("6011")) {
			return DISCOVER;
		}		
		return UNKNOWN;
	}
}
