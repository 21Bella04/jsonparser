package com.example.jsonparser.util;

import java.math.BigInteger;

public class ParseUtil {
    public static Long parseTo36(String value) {
        return Long.parseLong(new BigInteger(value, 36).toString());
    }
}
