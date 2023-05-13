package net.darkhax.archaeologybanners;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    @SerializedName("wandering_trader")
    public Map<String, WanderingTrade> wanderingTrades = defaultWanderingTrades();
    
    public static Config load(File configFile) {

        Config config = new Config();

        // Attempt to load existing config file
        if (configFile.exists()) {

            try (FileReader reader = new FileReader(configFile)) {

                config = GSON.fromJson(reader, Config.class);
                Constants.LOG.info("Loaded config file.");
            }

            catch (Exception e) {

                Constants.LOG.error("Could not read config file {}. Defaults will be used.", configFile.getAbsolutePath());
                Constants.LOG.error("Could not read config.", e);
            }
        }

        else {

            Constants.LOG.info("Creating a new config file at {}.", configFile.getAbsolutePath());
            configFile.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(configFile)) {

            GSON.toJson(config, writer);
            Constants.LOG.info("Saved config file.");
        }

        catch (Exception e) {

            Constants.LOG.error("Could not write config file '{}'!", configFile.getAbsolutePath());
            Constants.LOG.error("Could not write config.", e);
        }

        return config;
    }

    public static class WanderingTrade {

        @Expose
        @SerializedName("trade_enabled")
        public boolean enabled = true;

        @Expose
        @SerializedName("base_emerald_cost")
        public int cost = 24;

        @Expose
        @SerializedName("max_uses")
        public int maxUses = 4;

        @Expose
        @SerializedName("villager_profession_exp")
        public int villagerXp = 1;

        @Expose
        @SerializedName("price_multiplier")
        public float priceMultiplier = 0.5f;
    }
    
    private static Map<String, WanderingTrade> defaultWanderingTrades() {

        final Map<String, WanderingTrade> trades = new HashMap<>();
        trades.put("angler", new WanderingTrade());
        trades.put("archer", new WanderingTrade());
        trades.put("arms_up", new WanderingTrade());
        trades.put("blade", new WanderingTrade());
        trades.put("brewer", new WanderingTrade());
        trades.put("burn", new WanderingTrade());
        trades.put("danger", new WanderingTrade());
        trades.put("explorer", new WanderingTrade());
        trades.put("friend", new WanderingTrade());
        trades.put("heart", new WanderingTrade());
        trades.put("heartbreak", new WanderingTrade());
        trades.put("howl", new WanderingTrade());
        trades.put("miner", new WanderingTrade());
        trades.put("mourner", new WanderingTrade());
        trades.put("plenty", new WanderingTrade());
        trades.put("prize", new WanderingTrade());
        trades.put("sheaf", new WanderingTrade());
        trades.put("skull", new WanderingTrade());
        trades.put("snout", new WanderingTrade());
        return trades;
    }
}