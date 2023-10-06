import com.example.java.epam.brayan.BrayanApplication;
import com.example.java.epam.brayan.controllers.requests.CreateUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BrayanApplicationTests {

	@Autowired
	private BrayanApplication app;

	@Test
	public void contextLoads() { }

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateUser() throws Exception {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("John Doe")
				.email("john.doe@example.com")
				.build();

		String jsonBody = new ObjectMapper().writeValueAsString(request);

		mockMvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonBody))
				.andExpect(status().is2xxSuccessful());
	}
}