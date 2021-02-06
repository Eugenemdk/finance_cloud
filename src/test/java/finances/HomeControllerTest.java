package finances;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
//Web Test for HomeController class
@WebMvcTest
public class HomeControllerTest {
@Autowired
private MockMvc mockMvc;//Injects MockMvc
@Test
public void testHomePage() throws Exception {
	//Perform GET /
mockMvc.perform(get("/"))
//Expects HTTP 200
.andExpect(status().isOk())
//Expects home view
.andExpect(view().name("home"))
//Expects " Welcome to " string
.andExpect((ResultMatcher) content().string(containsString("Welcome to")));
}

}
