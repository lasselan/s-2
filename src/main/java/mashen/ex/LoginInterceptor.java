package mashen.ex;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("销毁");
	}

	public void init() {
		System.out.println("初始化");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("权限");
		try {
			String s = arg0.invoke();
		} catch (Exception e) {
			HttpServletRequest req= (HttpServletRequest) arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			req.setAttribute("msg", "网络繁忙！");
			System.out.println("日志");
			return "error";
		}

		return null;
	}

}
