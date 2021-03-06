package cn.vove7.filters;

import WebDB.StudentDAO;
import beans.StudentHomework;
import beans.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Vove on 2017/6/9.
 * 浏览作业过滤器
 */
public class BrowserHomeworkFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        String homeworkId = req.getParameter("homeworkId");
//        System.out.println(homeworkId);
        if (homeworkId != null) {
            Users student = (Users) session.getAttribute("user");
            StudentHomework.HomeworkStatus homeworkStatus = new StudentDAO(student).getStudentHomeworkStatus(homeworkId);
            if (homeworkStatus != null &&
                    homeworkStatus == StudentHomework.HomeworkStatus.FINISHED ||
                    homeworkStatus == StudentHomework.HomeworkStatus.CORRECTED) {//完成，放通
                chain.doFilter(req, resp);
                return;
            }
        }

        session.setAttribute("title", "禁止访问");
        String pageContent = "作业未提交,返回<a href=frontDesk/studentHomework.jsp>作业列表</a>";
        session.setAttribute("pageContent", pageContent);
        ((HttpServletResponse) resp).sendRedirect("../executeMessage.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
