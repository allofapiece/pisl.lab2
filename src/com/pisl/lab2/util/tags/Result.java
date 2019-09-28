package com.pisl.lab2.util.tags;

import com.pisl.lab2.entity.Computer;
import com.pisl.lab2.util.ConvertUtils;
import com.pisl.lab2.util.tags.enums.CheckboxEnumProcessor;
import com.pisl.lab2.util.tags.enums.EnumProcessor;
import com.pisl.lab2.util.tags.enums.RadioButtonEnumProcessor;
import com.pisl.lab2.util.tags.enums.SelectEnumProcessor;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;
import java.util.Map;

public class Result extends TagSupport {

    public Result() {
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Computer computer = (Computer) pageContext.getSession().getAttribute("computer");
        computer.setSomethingElse(pageContext.getRequest().getParameter("something"));

        try {
            out.print(String.format("<ul>%s</ul>", String.join("",
                    new String[]{
                            li("Computer", computer.getName().toString()),
                            li("RAM", computer.getRAMAmount() != null ? computer.getRAMAmount().toString() : ""),
                            li("Additional", computer.getAdditional() != null ? computer.getAdditional().toString() : ""),
                            li("Garnitur", computer.getGarnitur() != null ? computer.getGarnitur().toString() : ""),
                            li("Something else", computer.getSomethingElse()),
                    }
            )));
            out.print(String.format("<img width=\"300\" src=\"%s\" alt=\"computer\"/>", computer.getName().getImg()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    private String li(String name, String value) {
        return name != null && value != null ? String.format("<li><b>%s: </b>%s</li>", name, value) : "";
    }
}
