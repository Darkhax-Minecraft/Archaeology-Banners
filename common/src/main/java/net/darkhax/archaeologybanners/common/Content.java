package net.darkhax.archaeologybanners.common;

import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.impl.registry.adapter.CreativeModeTabAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.ItemRegistryAdapter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Rarity;

public final class Content implements ContentProvider {

    @Override
    public String namespace() {
        return ArchaeologyBanners.MOD_ID;
    }

    @Override
    public void defineItems(ItemRegistryAdapter registry) {
        for (SherdPattern pattern : SherdPattern.values()) {
            registry.addSimple(pattern.main() + "_banner_pattern", p -> p.stacksTo(1).rarity(Rarity.UNCOMMON).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, ctx -> ctx.getOrThrow(pattern.bannerTag())));
        }
    }

    @Override
    public void defineCreativeTabs(CreativeModeTabAdapter registry) {
        registry.add("tab", () -> BuiltInRegistries.ITEM.getValue(ArchaeologyBanners.id("snort_banner_pattern")).getDefaultInstance(), (params, builder) -> {
            for (SherdPattern pattern : SherdPattern.values()) {
                builder.accept(BuiltInRegistries.ITEM.getValue(ArchaeologyBanners.id(pattern.main() + "_banner_pattern")));
            }
        });
    }
}