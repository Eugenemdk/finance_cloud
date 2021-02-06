package finances;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import finances.Investment.TypeInvestment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/investment")
public class InvestmentController {
@GetMapping
public String showInvestmentForm(Model model) {
	List<Investment>investments=Arrays.asList(
			new Investment("CRPT", "Corporate", TypeInvestment.BONDS),
			new Investment("HLFR", "Half-retirement", TypeInvestment.RETIREMENT),
			new Investment("MNMT", "Money market", TypeInvestment.INVESTMENT_FUNDS),
			new Investment("FXDI", "Fixed income", TypeInvestment.INVESTMENT_FUNDS),
			new Investment("INDX", "Index", TypeInvestment.INVESTMENT_FUNDS),
			new Investment("COMN", "Common", TypeInvestment.STOCKS),
			new Investment("FXIN", "Fixed-indexed", TypeInvestment.ANNUITIES),
			new Investment("PRFD", "Preffered", TypeInvestment.STOCKS),
			new Investment("HGHI", "High-yield", TypeInvestment.BONDS),
			new Investment("DBTC", "Debit card", TypeInvestment.BANK_PRODUCTS),
			new Investment("MNCP", "Municipal", TypeInvestment.BONDS),
			new Investment("FLRT", "Full-retirement", TypeInvestment.RETIREMENT),
			new Investment("CRCD", "Credit card", TypeInvestment.BANK_PRODUCTS),
			new Investment("IMDT", "Immediate ", TypeInvestment.ANNUITIES)
			);
		
		TypeInvestment[] typesInvestments=Investment.TypeInvestment.values();
		for (TypeInvestment type:typesInvestments) {
			model.addAttribute(type.toString().toLowerCase(),filterByType(investments, type));
		}
  model.addAttribute("investment", new Action());
  
  return "investment";
}
private List<Investment> filterByType(
	      List<Investment> investments, TypeInvestment type) {
	    return investments
	              .stream()
	              .filter(x -> x.getTypeInvestment().equals(type))
	              .collect(Collectors.toList());
	  }
@PostMapping
public String processInvestment(@ Valid Investment investment,Errors errors) {
	if(errors.hasErrors()) {
		return "investment";
	}
	//Save the investment data
	log.info("Processing required data for investment"+investment);
	return "redirect:/orders/current";
}


}
