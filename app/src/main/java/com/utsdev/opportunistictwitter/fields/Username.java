package com.utsdev.opportunistictwitter.fields;

import tech.cocoon.Message.Field;

public class Username extends Field {

    public Username(int length) {
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
