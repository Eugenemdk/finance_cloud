package finances;
import java.sql.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;
@Data
public class Order {
	@NotBlank(message="Name is required")
private String name;
	@NotBlank(message="Address is required")
private String address;
	@NotBlank(message="City is required")
private String city;
	@NotBlank(message="Email is required")
private String email;
	@NotBlank(message="State is required")
private String state;
	@NotBlank(message="Zipcode is required")
private String zip;
	@CreditCardNumber(message="Not a valid credit card number")
private String number;
	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message = "must be formatted MM/YY")
private String expiration;
	@Digits(integer=3,fraction = 0,message = "Invalid CVV")
private String cvv;
private Long id;
private Date placedAt;
}
