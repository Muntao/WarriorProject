/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Muntao
 */
@Named(value = "httpURLConnection")
@RequestScoped
public class HttpURLConnection {

    /**
     * Creates a new instance of HttpURLConnection
     */
    public HttpURLConnection() {
    }
    
}
