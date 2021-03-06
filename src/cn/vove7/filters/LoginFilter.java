package cn.vove7.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Users;

import static beans.Users.UserType.TEACHER;

/**
 * Created by Vove on 2017/4/13.
 * <p>
 * 登陆过滤器
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = ((HttpServletRequest) req).getSession();
        String contextPath = request.getContextPath();//工程
        String uri = request.getRequestURI();//当前uri
        System.out.println("Login Filter:" + uri);
        Users user = (Users) session.getAttribute("user");

        boolean isFilter = false;
        String[] filterPage = new String[]{//前台需要过滤未登录页面，学生
                "/frontDesk/studentHomework.jsp",
                "/frontDesk/evaluate.jsp",
                "/frontDesk/doHomework.jsp",
                "/frontDesk/topicDetail.jsp",
                "/frontDesk/createTopic.jsp",
                "/frontDesk/myInfo.jsp",
                "/frontDesk/browserHomework.jsp",
                "/frontDesk/commitHomework.servlet"
        };
//        String[] filterStudentPage = new String[]{//后台过滤页面,限制教师访问
//                "/backDesk",
//                "/backDesk/",
//                "/backDesk/homeworkManager.jsp",
//                "/backDesk/studentsHomeworkList.jsp",
//                "/backDesk/publishHomework.jsp",
//                "/backDesk/Re-editHomework.jsp",
//                "/backDesk/correctHomework.jsp",
//                "/backDesk/editDeletedHomework.jsp"
//              /*  "/backDesk/theCoursewareManagement.jsp",
//                "/backDesk/thePracticeTeachingManagement.jsp",
//                "/backDesk/theResourceManagement.jsp"*/
//        };

        for (String page : filterPage) {
            if (uri.equals(contextPath + page)) {
                isFilter = true;
                break;
            }
        }
        if (!isFilter && uri.contains("backDesk")) {//判断后台页面登陆
            isFilter = true;
        }
        if (!isFilter) {
            chain.doFilter(req, resp);
            return;
        }
        //判断过滤
        if (user == null) {
            System.out.println("登陆过滤");
            response.sendRedirect(contextPath + "/login.jsp");
            return;
        }
        //已登录

        boolean isTeaFilter = false;
        if (uri.contains("backDesk")) {
            isTeaFilter = true;
        }

        if (!isTeaFilter) {
            chain.doFilter(req, resp);
            return;
        }

        switch (user.getUserType()) {
            case STUDENT:
                System.out.println("教师过滤");
                response.sendRedirect(contextPath + "/frontDesk/index.jsp");//学生主页
                break;
            case TEACHER:
                chain.doFilter(req, resp);//进入访问页面
                break;
            default:
                break;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
