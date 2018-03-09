package lanway.common.util;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 *拦截器防止表单重复提交
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if(annotation !=null){

                boolean needSaveSession = annotation.save();
                if(needSaveSession){
                    request.getSession(true).setAttribute("token", UUID.randomUUID().toString());
                }

                boolean needRemoveSession = annotation.remove();
                if(needRemoveSession){
                    if(isRepeatSubmit(request)){
                        return false;
                    }
                    request.getSession(true).removeAttribute("token");
                }
            }
            return true;
        }else{
            return super.preHandle(request, response, handler);

        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request){
        String serverToken = (String)request.getSession(true).getAttribute("token");
        if (serverToken == null){
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken ==null){
            return true;
        }
        if(!serverToken.equals(clinetToken)){
            return true;
        }
        return false;
    }

}
