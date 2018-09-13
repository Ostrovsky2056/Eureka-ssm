package com.ostrovsky.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: eurekassm
 * @description: MyFilter
 * @author: Ostrovsky
 * @create: 2018-09-13 17:20:05
 */
@Component
public class MyFilter extends ZuulFilter {
    //日志slf4j
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
     *   pre：可以在请求被路由之前调用；
     *   routing：在路由请求时候被调用；
     *   post： 在route和error过滤器之后被调用；
     *   error：处理请求时发生错误时被调用；
     * @return 过滤器的类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *   过滤的优先级，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤
     *   true：说明需要过滤；
     *   false：说明不要过滤；
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *   可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token is enpty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) { }
            return null;
        }
        log.info("ok");
        return null;
    }

}
