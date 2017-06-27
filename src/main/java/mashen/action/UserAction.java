package mashen.action;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

import mashen.service.UserServiceimp;
@ParentPackage("mashen")
@InterceptorRef("login2")
@Namespace("/user")
public class UserAction extends ActionSupport {
	@Resource(name = "userServiceimp")
	private UserServiceimp userServiceimp;
	
	private static final long serialVersionUID = 1L;

	@Action(value = "login", results = { @Result(name = "s", location = "/index.jsp") })
	public String login() {
		System.out.println("33");
//		int a=1/0;
//		userServiceimp.add();
		userServiceimp.find("l");
		return "s";
	}
}
