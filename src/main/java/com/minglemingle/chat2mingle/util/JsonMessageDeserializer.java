package com.minglemingle.chat2mingle.util;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Date;

public class JsonMessageDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            try {
                long timestamp = json.getAsLong();
                return Date.from(Instant.ofEpochMilli(timestamp));
            } catch (NumberFormatException e) {
                throw new JsonParseException("Invalid timestamp value: " + json.getAsString(), e);
            }
    }
}
