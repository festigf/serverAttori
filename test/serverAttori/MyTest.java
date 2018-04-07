package serverAttori;

import static org.junit.jupiter.api.Assertions.*;
import com.app.attore.*;
import org.junit.jupiter.api.Test;

class MyTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		Attore a =new Attore();   
		a.setCodAttore(1L);
		System.out.println(a.toString());
		assertEquals(2, a.getCodAttore().longValue());
	}

}
