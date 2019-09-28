package com.pisl.lab2.util.tags.enums;

import java.util.Map;
import java.util.stream.Collectors;

public class SelectEnumProcessor implements EnumProcessor {
    @Override
    public String process(String name, Map<String, String> options) {
        return String.format("<select name=\"%s\">%s</select>", name,
                String.join("", options.entrySet()
                        .stream()
                        .map(e -> this.processItem(e.getKey(), e.getValue()))
                        .collect(Collectors.toList()))
        );
    }

    @Override
    public String processItem(String key, String value) {
        return String.format("<option value=\"%s\">%s</option>", value, key);
    }
}
