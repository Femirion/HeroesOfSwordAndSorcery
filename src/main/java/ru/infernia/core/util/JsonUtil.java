package ru.infernia.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.experimental.UtilityClass;
import ru.infernia.core.engine.image.TextureInfo;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@UtilityClass
public class JsonUtil {
    private static final String TEXTURE_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/textures.json";
    private static final ObjectMapper objectMapper = createMapper();

    private static ObjectMapper createMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
        javaTimeModule.addDeserializer(ZonedDateTime.class, InstantDeserializer.ZONED_DATE_TIME);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);
        return mapper;
    }

    public static List<TextureInfo> loadTexture(String path) {
        try {
            // TODO fix me!
            return objectMapper.readValue(new File(TEXTURE_PATH),  new TypeReference<List<TextureInfo>>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read 'players.json', cause=" + ex.getMessage());
        }
    }
}
