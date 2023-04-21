package edu.eci.cvds.servlet.servlets;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.servlets.Todo.Todo;


@WebServlet(
        urlPatterns = "/GivemeSomething"
)
public class SecondServlet extends HttpServlet {
    static final long serialVersionUID = 35L;
    static Todo todo;
    ArrayList<Todo> todoList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            int number = Integer.parseInt(req.getParameter("id"));
            todoList = new ArrayList<Todo>();
            while (number > 0) {
                todoList.add(Service.getTodo(number));
                number--;
            }
            String a = Service.todosToHTMLTable(todoList);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(a);
            resp.setContentType("text/html");

        }catch(Exception e){
            e.printStackTrace();
            if(e instanceof MalformedURLException){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Ingrese un valor diferente");
            }
        }
        //String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        //resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        try {
            int number = Integer.parseInt(req.getParameter("id"));
            todoList = new ArrayList<Todo>();
            while (number > 0) {
                todoList.add(Service.getTodo(number));
                number--;
            }
            String a = Service.todosToHTMLTable(todoList);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(a);
            resp.setContentType("text/html");

        }catch(Exception e){
            e.printStackTrace();
            if(e instanceof MalformedURLException){
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Ingrese un valor diferente");
            }
        }
    }
}
