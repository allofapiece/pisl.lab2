package com.pisl.lab2.util.tags.enums;

import java.util.Map;
import java.util.stream.Collectors;

public class CheckboxEnumProcessor implements EnumProcessor {
    @Override
    public String process(String name, Map<String, String> options) {
        return String.format("<div>%s</div>",
                String.join("", options.entrySet()
                        .stream()
                        .map(e -> String.format(this.processItem(e.getKey(), e.getValue()), name))
                        .collect(Collectors.toList()))
        );
    }

    @Override
    public String processItem(String key, String value) {
        return String.format("<div><input type=\"checkbox\" name=\"%s\" value=\"%s\">" +
                "<label for=\"%s\">%s</label></div>", "%s", value, value, key);
    }
}
