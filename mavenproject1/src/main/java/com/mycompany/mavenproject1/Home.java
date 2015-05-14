/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entity.Details;
import com.mycompany.query.EntityQueries;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 *
 * @author Rahul
 */
public class Home extends WebPage {

    private static Logger LOG = Logger.getLogger(Home.class);
    private static final long serialVersionUID = 1L;
    private Details details;

    public Home() {
        details = new Details();
        setDefaultModel(new CompoundPropertyModel(details));
        final TextField<String> uname = new TextField<String>("Name");
        final TextField<Integer> telNo = new TextField<Integer>("tel");
        Form<Details> form = new Form<Details>("form", new CompoundPropertyModel<Details>(details)) {
            @Override
            protected void onSubmit() {
                LOG.debug("On Submit Method");
                String uNameValue = uname.getModelObject();
                int telNoValue = telNo.getModelObject();
                details.setName(uNameValue);
                details.setTel(telNoValue);
                LOG.debug("Name:" + details.getName() + " TelNo:" + details.getTel());
                EntityQueries entity=new EntityQueries();
                
                
            }
        };
        LOG.debug("Start");
        add(form);
        form.add(new Label("msg", "Hello"));
        form.add(uname);
        form.add(telNo);
        LOG.debug("End");


    }
}
