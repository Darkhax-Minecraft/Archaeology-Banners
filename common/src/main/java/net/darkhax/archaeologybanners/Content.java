package net.darkhax.archaeologybanners;

import net.darkhax.archaeologybanners.content.BiomeMakeoverPatterns;
import net.darkhax.archaeologybanners.content.MinecraftPattern;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.world.item.Items;

public final class Content extends RegistryDataProvider {

    public static void init() {

        Services.REGISTRIES.loadContent(new Content());
    }

    private Content() {

        super(Constants.MOD_ID);
        this.withItemTab(Items.CREEPER_BANNER_PATTERN::getDefaultInstance);

        new MinecraftPattern(this).registerPatterns();
        new BiomeMakeoverPatterns(this).registerPatterns();
    }
}