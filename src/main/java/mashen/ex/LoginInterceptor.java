package mashen.ex;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("����");
	}

	public void init() {
		System.out.println("��ʼ��");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("Ȩ��");
		try {
			String s = arg0.invoke();
		} catch (Exception e) {
			HttpServletRequest req= (HttpServletRequest) arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			req.setAttribute("msg", "���緱æ��");
			System.out.println("��־");
			return "error";
		}

		return null;
	}

}
