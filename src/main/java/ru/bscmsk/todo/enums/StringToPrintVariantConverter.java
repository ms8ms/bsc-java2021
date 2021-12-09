package ru.bscmsk.todo.enums;

import org.springframework.core.convert.converter.Converter;

public class StringToPrintVariantConverter implements Converter<String, PrintVariant> {
    @Override
    public PrintVariant convert(String source) {
        if (source == null) return null;
        return PrintVariant.valueOf(source.toUpperCase());
    }
}
