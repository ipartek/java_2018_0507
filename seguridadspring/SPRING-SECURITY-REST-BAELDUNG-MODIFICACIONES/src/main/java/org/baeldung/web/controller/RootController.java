package org.baeldung.web.controller;

import java.util.List;

import com.google.common.collect.Lists;

import org.baeldung.persistence.model.Foo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    public RootController() {
        super();
    }

    // API

    @RequestMapping(value = "/admin/x", method = RequestMethod.GET)
    @ResponseBody
    public List<Foo> sampleAdminPage() {
        return Lists.newArrayList(new Foo("ADMINISTRADOR"));
    }


    @RequestMapping(value = "/my-error-page", method = RequestMethod.GET)
    @ResponseBody
    public String sampleErrorPage() {
        return "{ \"respuesta\": \"Ha habido un error\"} ";
    }

}
