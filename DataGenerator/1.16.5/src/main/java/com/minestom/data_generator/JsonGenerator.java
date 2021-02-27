package com.minestom.data_generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public final class JsonGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonGenerator.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final File OUTPUT_FOLDER = new File("./output/");

    static {
        // Create output folder
        if (!OUTPUT_FOLDER.exists() && !OUTPUT_FOLDER.mkdirs()) {
            throw new ExceptionInInitializerError("Failed to create work folder.");
        }
    }

    private JsonGenerator() {

    }

    public static void outputBlocks(List<GeneratedBlock> generatedBlocks) {
        try {
            Writer writer = new FileWriter(new File(OUTPUT_FOLDER, "blocks.json"), false);
            GSON.toJson(generatedBlocks, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Something went wrong while writing data to blocks.json.", e);
        }
    }

    public static void outputEntities(List<GeneratedEntity> generatedEntities) {
        try {
            Writer writer = new FileWriter(new File(OUTPUT_FOLDER, "entities.json"), false);
            GSON.toJson(generatedEntities, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Something went wrong while writing data to entities.json.", e);
        }
    }

    public static void outputBlockEntites(List<GeneratedBlockEntity> generatedBlockEntities) {
        try {
            Writer writer = new FileWriter(new File(OUTPUT_FOLDER, "block_entities.json"), false);
            GSON.toJson(generatedBlockEntities, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Something went wrong while writing data to block_entities.json.", e);
        }
    }

    public static void outputItems(List<GeneratedItem> generatedItems) {
        try {
            Writer writer = new FileWriter(new File(OUTPUT_FOLDER, "items.json"), false);
            GSON.toJson(generatedItems, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Something went wrong while writing data to items.json.", e);
        }
    }

    public static void outputMapColors(List<GeneratedMapColor> generatedMapColors) {
        try {
            Writer writer = new FileWriter(new File(OUTPUT_FOLDER, "map_colors.json"), false);
            GSON.toJson(generatedMapColors, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Something went wrong while writing data to map_colors.json.", e);
        }
    }
}