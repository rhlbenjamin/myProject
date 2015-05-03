/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.mavenproject1.Home;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 *
 * @author Rahul
 */
public class HomeApplication extends WebApplication {

    public HomeApplication() {
    }

    @Override
    public Class getHomePage() {
        return Home.class;
    }

    @Override
    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }
}
