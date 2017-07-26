package cn.yjxxclub.bgApi.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-17
 * Time: 下午4:32
 * Describe: Response工具类
 */
public class ResponseUtil {
    /**
     * response
     * @param response
     * @param o
     * @throws Exception
     */
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
