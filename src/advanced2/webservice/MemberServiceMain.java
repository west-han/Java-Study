package advanced2.webservice;

import advanced2.io.member.MemberRepository;
import advanced2.io.member.impl.FileMemberRepository;
import advanced2.was.httpserver.HttpServer;
import advanced2.was.httpserver.ServletManager;
import advanced2.was.httpserver.servlet.DiscardServlet;
import advanced2.was.httpserver.servlet.annotation.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        MemberRepository memberRepository = new FileMemberRepository();
        MemberController memberController = new MemberController(memberRepository);
        AnnotationServletV3 servlet = new AnnotationServletV3(List.of(memberController));
        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
