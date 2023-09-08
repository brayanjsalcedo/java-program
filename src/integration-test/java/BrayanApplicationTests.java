import com.example.java.epam.brayan.BrayanApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BrayanApplicationTests {

	@Autowired
	private BrayanApplication app;

	@Test
	public void contextLoads() { }
}