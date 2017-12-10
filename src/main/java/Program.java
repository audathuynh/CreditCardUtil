
public class Program {

	public static void main(String[] args) {
		
		String cardNumbers[] = new String[] {
				"4408 0412 3456 7893", 
				"4111111111111111",
				"4111111111111",
				"4012888888881881",
				"378282246310005",
				"6011111111111117",
				"5105 1051 0510 5100",
				"5105 1051 0510 5106",
				"9111111111111111"
		};
		
		for (String cardNumber : cardNumbers){
			String cardType = CreditCardUtil.getCardType(cardNumber);
			boolean valid = CreditCardUtil.luhnCheck(cardNumber);

			String result = cardType + ": " + cardNumber + " " + (valid ? "(valid)" : "(invalid)");
			System.out.println(result);
		}
	}
}