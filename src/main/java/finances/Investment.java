package finances;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
public class Investment {
	private final String id;
	private final String name;
	private final TypeInvestment typeInvestment;

	

public static enum TypeInvestment{
	STOCKS,BONDS,INVESTMENT_FUNDS,BANK_PRODUCTS,ANNUITIES,RETIREMENT
}



}
