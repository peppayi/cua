package com.xmucoder.cua.utils;

import com.xmucoder.cua.algorithm.BM;

public final class StringUtils {

    public static int indexOf(String text, String pattern) {
        return new BM(pattern).search(text);
    }

    public static boolean contains(String text, String pattern) {
        return indexOf(text, pattern) < text.length();
    }
}
