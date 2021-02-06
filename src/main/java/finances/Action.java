package finances;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Action {
	
	private Long id;
	private Date createdAt;
	@NotNull
	@Size(min = 5, message = "Name of investment must be at least 5 characters long")
	private String name;
	@Size(min=1,message="You must choose at least 1 investment option")
	private List<Investment> investments;
}
