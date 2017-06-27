package mashen.uitl;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mashen.service.UserServiceimp;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class Tset {
	@Resource(name="userServiceimp")
    private UserServiceimp us; 
    @Test   
    public void testServie2(){  
    	us.addTwoUser(1);
    }
}
