package ru.perevozchikov.supervision.util;

import ru.perevozchikov.supervision.exception.BasicNotFoundException;

public class Utils {
    public static <T> T requireNonNull(T object) {
        if (object == null)
            throw new BasicNotFoundException();
        return object;
    }
}
