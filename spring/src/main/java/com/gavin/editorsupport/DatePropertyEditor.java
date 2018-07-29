package com.gavin.editorsupport;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
   /* private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }*/

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            Date date = sf.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
