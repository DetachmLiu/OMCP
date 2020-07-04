package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import impl.GetSongInfos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author axtb
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetSongInfos infos = new GetSongInfos();
        String str = req.getParameter("search");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        // 获取搜索结果
        List<String[]> res = infos.getSearchResult(str);
        // 初始化搜索结果 Json 数组
        JSONArray arr = new JSONArray();
        // 遍历生成 Json 数组
        for (String[] song : res) {
            JSONObject obj = new JSONObject();
            obj.put("name", song[0]);
            obj.put("singers", song[1]);
            obj.put("songId", song[2]);
            arr.add(obj);
        }

        req.getSession().setAttribute("searchResult", JSON.toJSONString(arr));
//        resp.sendRedirect("jsp/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
