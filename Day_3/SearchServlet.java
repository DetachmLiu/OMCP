package com.cr.servlet;

import com.cr.util.GetSongInfos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetSongInfos infos = new GetSongInfos();
        String str = req.getParameter("search");
        List<String[]> res = infos.getSearchResult(str);
//        req.setAttribute("songsList", res);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        for (String[] song : res) {
            writer.println(String.format("<h3>%s %s %s</h3>", song[0], song[1], song[2]));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
