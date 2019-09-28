package com.pisl.lab2.util.tags.enums;

import java.util.Map;

public interface EnumProcessor {
    String process(String name, Map<String, String> options);

    String processItem(String key, String value);
}
