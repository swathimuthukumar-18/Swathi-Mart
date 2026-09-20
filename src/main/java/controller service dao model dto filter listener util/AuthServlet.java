package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("register".equals(action)) {
            register(request, response);

        } else if ("login".equals(action)) {
            login(request, response);

        } else {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Invalid action"
            );
        }
    }

    private void register(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        boolean success = userService.register(
            name, email, password, role
        );

        if (success) {
            response.getWriter().println(
                "Registration successful!"
            );
        } else {
            response.getWriter().println(
                "Registration failed!"
            );
        }
    }

    private void login(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.login(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Login successful → go to Home page
            response.sendRedirect("home.html");

        } else {

            response.getWriter().println(
                "Invalid email or password!"
            );
        }
    }
}