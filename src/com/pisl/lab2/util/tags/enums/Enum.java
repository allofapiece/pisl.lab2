package com.pisl.lab2.util.tags.enums;

import com.pisl.lab2.util.ConvertUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;
import java.util.Map;

public class Enum extends TagSupport {
    private String src;
    private String name;
    private String type;

    private Map<String, EnumProcessor> enumProcessors = new HashMap<>();

    public Enum() {
        enumProcessors.put("select", new SelectEnumProcessor());
        enumProcessors.put("radio", new RadioButtonEnumProcessor());
        enumProcessors.put("check", new CheckboxEnumProcessor());
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            if (!enumProcessors.containsKey(this.type)) {
                throw new Exception("Undefined type");
            }

            out.print(enumProcessors.get(this.type).process(
                    this.name,
                    ConvertUtils.enumToOptions(Class.forName(this.src))
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
