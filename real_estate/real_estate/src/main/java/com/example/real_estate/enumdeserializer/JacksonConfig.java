package com.example.real_estate.enumdeserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.real_estate.entities.Property.ListingType;
import com.example.real_estate.entities.Property.PropertyType;
import com.example.real_estate.entities.Property.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PropertyType.class, new CustomEnumDeserializer<>(PropertyType.class));
        module.addDeserializer(ListingType.class, new CustomEnumDeserializer<>(ListingType.class));
        module.addDeserializer(Status.class, new CustomEnumDeserializer<>(Status.class));
        mapper.registerModule(module);
        return mapper;
    }
}
