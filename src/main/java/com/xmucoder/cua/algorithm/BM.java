package com.xmucoder.cua.algorithm;

import java.util.Objects;

/**
 * Boyer-Moore algorithms
 *
 * explained in Algorithms, 4th - Robert Sedgewick
 */
public class BM {

    private final String pattern;

    private int[] right;

    public BM(String pattern) {
        if (pattern == null || pattern.isEmpty()) throw new IllegalArgumentException("pattern is null or empty");

        this.pattern = pattern;
        init(this.pattern);
    }

    public int search(String text) {
        if (text == null || text.isEmpty()) throw new IllegalArgumentException("text is null or empty");

        int N = text.length(), M = pattern.length();

        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;

            for (int j = M - 1; j >= 0; --j) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }

            if (skip == 0) return i;
        }

        return N;
    }

    private void init(String pattern) {
        int R = 256;
        right = new int[R];
        for (int i = 0; i < R; ++i) right[i] = -1;

        for (int i = 0; i < pattern.length(); ++i) {
            right[pattern.charAt(i)] = i;
        }
    }
}
