package serverAttori;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import com.app.MainClass;
import com.app.attore.Attore;
import com.app.attore.AttoreDAO;
import com.app.attore.AttoreService;
import com.app.controller.MainController;

import org.springframework.beans.factory.annotation.Autowired;
/*class MyTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		Attore a =new Attore();   
		a.setCodAttore(1L);
		a.setAnnoNascita(1980L);
		a.setNazionalita("ITA");
		a.setNome("Pippo");
		System.out.println(a.toString());
		assertEquals(1, a.getCodAttore().longValue());
		assertNotNull(a);
		AttoreDAO ad = new AttoreDAO();
		ad.modAttore(a);
	}

}
*/


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainClass.class)
public class MyTest {

	@Autowired
	//private AttoreDAO attoreDAO; 
	private AttoreService attoreService; 

	@Autowired
	//private UserRepository repository;
    
	@Test
	public void testExample() throws Exception {
	/*	this.entityManager.persist(new User("sboot", "1234"));
		User user = this.repository.findByUsername("sboot");
		
		assertThat(user.getUsername()).isEqualTo("sboot");
		assertThat(user.getVin()).isEqualTo("1234");*/
		
//		assertThat(attoreDAO).isNotNull();
//		attoreDAO.modAttore(new Attore	(1L,"ciao",1999L,"bo"));
		assertThat(attoreService).isNotNull();
		attoreService.modAttore(new Attore	(1L,"ci1ao",1999L,"bo"));
	}
}
