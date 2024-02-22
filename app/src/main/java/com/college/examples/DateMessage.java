package com.college.examples;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class DateMessage {
    private final String mStr;

    DateMessage() {
        SimpleDateFormat sFormat = new SimpleDateFormat("hh:mm:ss", Locale.CANADA);
        mStr = sFormat.format (  new Date()  );
    }

    @NonNull
    @Override
    public String toString() {
        return mStr;
    }

}