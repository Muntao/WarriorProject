/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import controllers.SessionController;
import controllers.KontoController;
import entities.Konto;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class sessionFilter implements Filter {

    @Inject
    private SessionController sessionController;
    @Inject
    private KontoController kontoController;

    public sessionFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Wylaczam sprawdzania logowania na czas pracy
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI().replace(httpRequest.getServletContext().getContextPath(), "");
        if (uri.contains("resource")) {
            chain.doFilter(request, response);
            return;
        }
        /*
        1. Jezeli nie zalogowany to przenoś na strone logowania
        2. Jeżeli zalogowany to i chce sie zalogować to na index
        3. Jeżeli zalogowany i chce się wylogować to wyloguj i na index
         */
        if (sessionController == null || !sessionController.isLogged()) { // Jezeli nie zalogowany to przenoś na strone logowania
            if (!uri.contains("/session/zaloguj") && !uri.contains("/session/rejestracja") && !uri.contains("/index") && !uri.equals("/")) {
                httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + "/faces/session/zaloguj.xhtml");
            } 
        } else if (uri.contains("/session/zaloguj") || uri.contains("/session/rejestracja")) { 
            // Jeżeli zalogowany i chce sie zalogować lub zarejestrować to na index
            httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + "/faces/index.xhtml");
        } else if (uri.contains("/session/wyloguj")) {
            // Jeżeli zalogowany i chce się wylogować to wyloguj i na index
            sessionController.logout();
        } else if (uri.contains("/admin/") && !sessionController.getKonto().getKontoUprawnienia().equals(Konto.ADMIN)) {
            // Jeżeli zalogowany i niema administratorskich uprawnien to 403
            httpResponse.sendError(403);
        }
        if (!uri.contains("/admin/")) {
            // Jeżeli zalogowany i przeglada panel uzytkownika to zmien w kontrolerze na zalogowanego
            kontoController.setKonto(sessionController.getKonto());  
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
