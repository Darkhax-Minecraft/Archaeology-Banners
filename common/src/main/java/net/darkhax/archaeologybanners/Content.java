package net.darkhax.archaeologybanners;

import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.entity.merchant.trade.VillagerSells;
import net.darkhax.bookshelf.api.registry.IRegistryObject;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.entity.BannerPattern;

public final class Content extends RegistryDataProvider {


    public static void init() {

        Services.REGISTRIES.loadContent(new Content());
    }

    private final Config config;

    private Content() {

        super(Constants.MOD_ID);
        this.config = Config.load(Services.PLATFORM.getConfigPath().resolve(Constants.MOD_ID + ".json").toFile());
        this.withItemTab(Items.CREEPER_BANNER_PATTERN::getDefaultInstance);

        this.createPattern("angler", "bobber", "hook", "line", "rod");
        this.createPattern("archer", "arrow", "bow");
        this.createPattern("arms_up");
        this.createPattern("blade", "hilt", "blade");
        this.createPattern("brewer", "bottle", "fluid");
        this.createPattern("burn");
        this.createPattern("danger");
        this.createPattern("explorer", "blank", "x");
        this.createPattern("friend");
        this.createPattern("heart");
        this.createPattern("heartbreak", "left", "right");
        this.createPattern("howl");
        this.createPattern("miner", "handle", "pick");
        this.createPattern("mourner");
        this.createPattern("plenty", "bottom", "lid");
        this.createPattern("prize", "inverted");
        this.createPattern("sheaf");
        this.createPattern("skull");
        this.createPattern("snout", "body", "nose", "shell");
    }

    private void createPattern(String name, String... subvariants) {

        final TagKey<BannerPattern> bannerTag = Services.TAGS.bannerPatternTag(new ResourceLocation(Constants.MOD_ID, "pattern_item/" + name));
        final IRegistryObject<BannerPatternItem> stencilItem = this.items.add(() -> new BannerPatternItem(bannerTag, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)), name + "_banner_pattern");

        final Config.WanderingTrade tradeConfig = config.wanderingTrades.getOrDefault(name, new Config.WanderingTrade());

        if (tradeConfig.enabled) {
            this.trades.addRareWanderingTrade(VillagerSells.create(stencilItem, tradeConfig.cost, tradeConfig.maxUses, tradeConfig.villagerXp, tradeConfig.priceMultiplier));
        }

        this.bannerPatterns.add(() -> new BannerPattern(name), name);

        for (String variantName : subvariants) {
            final String patternId = name + "_" + variantName;
            this.bannerPatterns.add(() -> new BannerPattern(patternId), patternId);
        }
    }
}