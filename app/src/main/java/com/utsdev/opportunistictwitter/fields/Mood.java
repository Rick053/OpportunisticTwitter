package com.utsdev.opportunistictwitter.fields;

import tech.cocoon.Message.Field;

/**
 * Created by Rick on 02-Sep-15.
 */
public class Mood extends Field {

    public Mood(int length) {
        super(length);
    }

    @Override
    public String decode() {
        return null;
    }

    @Override
    public boolean encode(Object o) {
        return false;
    }
}
