/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entity.Details;
import javax.persistence.Entity;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author Rahul
 */
public class Home extends WebPage {

    private static Logger LOG = Logger.getLogger(Home.class);

    
    public Home() {
        Details details=new Details();
        setDefaultModel(new CompoundPropertyModel(details));
        Form form = new Form("form") {
            @Override
            protected void onSubmit() {
                LOG.debug("Form Submited");
            }
        };
        LOG.debug("Start");
        add(form);
        form.add(new Label("msg", "Hello"));
        form.add(new TextField("Name"));
        form.add(new TextField("tel"));
        
        LOG.debug("End");

    }
}
