package com.cf.tank.cor;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-31 06:06:31
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Filter htmlFilter = new HtmlFilter();
        Filter sensitiveFilter = new SensitiveFilter();
        FilterChain chain = new FilterChain();
        chain.add(htmlFilter);
        chain.add(sensitiveFilter);
        chain.doFilter(new Request(), new Response(), chain);
    }
}
interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = "HtmlFilter request ====";
        System.out.println(request.str);
        chain.doFilter(request, response, chain);
        response.str = "HtmlFilter response ====";
        System.out.println(response.str);
        return true;
    }
}
class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = "SensitiveFilter request ====";
        System.out.println(request.str);
        chain.doFilter(request, response, chain);
        response.str = "SensitiveFilter response ====";
        System.out.println(response.str);
        return true;
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response, FilterChain chain) {
        if(index == filters.size()) {
            return;
        }
        Filter f = filters.get(index++);

        f.doFilter(request, response, chain);
    }
}

class Request {
    public String str;
}
class Response {
    public String str;
}
