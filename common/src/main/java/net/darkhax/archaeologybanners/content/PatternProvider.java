package net.darkhax.archaeologybanners.content;

import net.darkhax.archaeologybanners.Constants;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.entity.BannerPattern;

public abstract class PatternProvider {

    protected final RegistryDataProvider registry;
    private final String sourceId;

    public PatternProvider(RegistryDataProvider registry, String sourceId) {

        this.registry = registry;
        this.sourceId = sourceId;
    }

    public abstract void registerPatterns();

    public void createPattern(String name, String... subvariants) {

        final String registryName = this.isBuiltIn() ? name : this.getSourceId() + "/" + name;

        this.registry.bannerPatterns.add(() -> new BannerPattern(registryName), registryName);

        for (String variantName : subvariants) {
            this.registry.bannerPatterns.add(() -> new BannerPattern(registryName + "_" + variantName), registryName + "_" + variantName);
        }

        if (this.isBuiltIn() || Services.PLATFORM.isModLoaded(this.getSourceId())) {

            final TagKey<BannerPattern> patternsTag = TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(Constants.MOD_ID, "pattern_item/" + this.getSourceId() + "/" + name));
            registry.items.add(() -> new BannerPatternItem(patternsTag, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)), registryName + "_banner_pattern");
        }
    }

    public String getSourceId() {

        return this.sourceId;
    }

    public final boolean isBuiltIn() {

        return "minecraft".equalsIgnoreCase(this.getSourceId());
    }
}