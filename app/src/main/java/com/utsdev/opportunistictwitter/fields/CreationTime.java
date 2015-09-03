package com.utsdev.opportunistictwitter.fields;

import tech.cocoon.Message.Field;

/**
 * Created by Rick on 02-Sep-15.
 */
public class CreationTime extends Field {

    public CreationTime(int length) {
        super(length);
    }

    @Override
    public boolean encode(Object o) {
        return false;
    }

    @Override
    public String decode() {
        return null;
    }
}
