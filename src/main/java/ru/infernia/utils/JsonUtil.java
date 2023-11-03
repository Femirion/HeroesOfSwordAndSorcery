package ru.infernia.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.experimental.UtilityClass;
import ru.infernia.core.engine.wrapper.AnimationInfo;
import ru.infernia.core.engine.wrapper.ImageInfo;
import ru.infernia.core.engine.wrapper.TextureInfo;
import ru.infernia.entity.map.MapInfo;
import ru.infernia.entity.map.RegionInfo;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@UtilityClass
public class JsonUtil {
    private static final String TEXTURES_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/textures/textures.json";
    private static final String IMAGES_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/textures/images.json";
    private static final String ANIMATION_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/textures/animations.json";
    private static final String MAP_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/map.json";
    private static final String REGION_PATH = "/home/aleksandr/project/HeroesOfSwordAndSorcery/src/main/resources/json/region/%s.json";
    private static final ObjectMapper objectMapper = createMapper();

    private static ObjectMapper createMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
        javaTimeModule.addDeserializer(ZonedDateTime.class, InstantDeserializer.ZONED_DATE_TIME);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);
        return mapper;
    }

    public static RegionInfo loadRegion(int id) {
        try {
            return objectMapper.readValue(new File(String.format(REGION_PATH, id)),  new TypeReference<RegionInfo>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read region '" + id + ".json'", ex);
        }
    }

    public static MapInfo loadMap() {
        try {
            return objectMapper.readValue(new File(MAP_PATH),  new TypeReference<MapInfo>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read 'map.json'", ex);
        }
    }

    public static List<AnimationInfo> loadAnimation() {
        try {
            // TODO fix me!
            return objectMapper.readValue(new File(ANIMATION_PATH),  new TypeReference<List<AnimationInfo>>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read 'animations.json'", ex);
        }
    }

    public static List<ImageInfo> loadImages() {
        try {
            // TODO fix me!
            return objectMapper.readValue(new File(IMAGES_PATH),  new TypeReference<List<ImageInfo>>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read 'images.json'", ex);
        }
    }

    public static List<TextureInfo> loadTexture(String path) {
        try {
            // TODO fix me!
            return objectMapper.readValue(new File(TEXTURES_PATH),  new TypeReference<List<TextureInfo>>() {});
        } catch (Exception ex) {
            throw new RuntimeException("can not read 'textures.json'", ex);
        }
    }
}
