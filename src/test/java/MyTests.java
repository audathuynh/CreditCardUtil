import static org.junit.Assert.*;

import org.junit.Test;

public class MyTests {

	@Test
	public void checkCreditCards(){
		String cardNumber;
		// should sort the card numbers by the first digit.
		cardNumber = "378282246310005";
		assertEquals("Valid AMEX card", true, CreditCardUtil.luhnCheck(cardNumber));

		cardNumber = "4408 0412 3456 7893";
		assertEquals("Valid VISA card", true, CreditCardUtil.luhnCheck(cardNumber));
		
		cardNumber = "4111111111111111";
		assertEquals("Valid VISA card", true, CreditCardUtil.luhnCheck(cardNumber));
		
		cardNumber = "4111111111111";
		assertEquals("Invalid VISA card", false, CreditCardUtil.luhnCheck(cardNumber));
		
		cardNumber = "4012888888881881";
		assertEquals("Valid VISA card", true, CreditCardUtil.luhnCheck(cardNumber));
				
		cardNumber = "5105 1051 0510 5100";
		assertEquals("Valid MasterCard card", true, CreditCardUtil.luhnCheck(cardNumber));
		
		cardNumber = "5105 1051 0510 5106";
		assertEquals("Invalid MasterCard card", false, CreditCardUtil.luhnCheck(cardNumber));
		
		cardNumber = "6011111111111117";
		assertEquals("Valid Discover card", true, CreditCardUtil.luhnCheck(cardNumber));

		cardNumber = "9111111111111111";
		assertEquals("Invalid Unknown card", false, CreditCardUtil.luhnCheck(cardNumber));
	}
	
	@Test
	public void testCardTypes(){
		String cardNumber;
		// should sort the card numbers by the first digit.
		cardNumber = "378282246310005";
		assertEquals("Valid AMEX card", CreditCardUtil.AMEX, CreditCardUtil.getCardType(cardNumber));

		cardNumber = "4408 0412 3456 7893";
		assertEquals("Valid VISA card", CreditCardUtil.VISA, CreditCardUtil.getCardType(cardNumber));
		
		cardNumber = "4111111111111111";
		assertEquals("Valid VISA card", CreditCardUtil.VISA, CreditCardUtil.getCardType(cardNumber));
		
		cardNumber = "4111111111111";
		assertEquals("Invalid VISA card", CreditCardUtil.VISA, CreditCardUtil.getCardType(cardNumber));
		
		cardNumber = "4012888888881881";
		assertEquals("Valid VISA card", CreditCardUtil.VISA, CreditCardUtil.getCardType(cardNumber));
				
		cardNumber = "5105 1051 0510 5100";
		assertEquals("Valid MasterCard card", CreditCardUtil.MASTERCARD, CreditCardUtil.getCardType(cardNumber));
		
		cardNumber = "5105 1051 0510 5106";
		assertEquals("Invalid MasterCard card", CreditCardUtil.MASTERCARD, CreditCardUtil.getCardType(cardNumber));
		
		cardNumber = "6011111111111117";
		assertEquals("Valid Discover card", CreditCardUtil.DISCOVER, CreditCardUtil.getCardType(cardNumber));

		cardNumber = "9111111111111111";
		assertEquals("Invalid Unknown card", CreditCardUtil.UNKNOWN, CreditCardUtil.getCardType(cardNumber));
	}
}
