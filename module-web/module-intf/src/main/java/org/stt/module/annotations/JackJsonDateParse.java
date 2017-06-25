package org.stt.module.annotations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * DateParse for jackson<br>
 * used in field annotations
 * @author wangchao
 *
 */
public class JackJsonDateParse extends JsonDeserializer<Date> {

    private static final Logger logger = LoggerFactory.getLogger(JackJsonDateParse.class);

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = jp.getText();
        if (date == null || date.trim().length() == 0) {
            return null;
        }
        try {
            return format.parse(date);
        } catch (Exception e) {
            logger.error("jackson date parse error", e);
        }
        return null;

    }
}
