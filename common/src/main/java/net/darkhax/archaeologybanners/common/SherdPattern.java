package net.darkhax.archaeologybanners.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public enum SherdPattern {

    ANGLER("angler", "bobber", "hook", "line", "rod"),
    ARCHER("archer", "arrow", "bow"),
    ARMS_UP("arms_up"),
    BLADE("blade", "hilt", "blade"),
    BREWER("brewer", "bottle", "fluid"),
    BURN("burn"),
    DANGER("danger"),
    EXPLORER("explorer", "blank", "x"),
    FRIEND("friend"),
    HEART("heart"),
    HEARTBREAK("heartbreak", "left", "right"),
    HOWL("howl"),
    MINER("miner", "handle", "pick"),
    MOURNER("mourner"),
    PLENTY("plenty", "bottom", "lid"),
    PRIZE("prize", "inverted"),
    SHEAF("sheaf"),
    SHELTER("shelter"),
    SKULL("skull"),
    SNOUT("snort", "body", "nose", "shell"),
    FLOW("flow"),
    GUSTER("guster", "head", "eyes", "top", "middle", "bottom", "base");

    private final String main;
    private final String[] variants;
    private final TagKey<BannerPattern> bannerTag;

    SherdPattern(String main, String... variants) {
        this.main = main;
        this.variants = variants;
        this.bannerTag = TagKey.create(Registries.BANNER_PATTERN, ArchaeologyBanners.id("pattern_item/" + main));
    }

    public String main() {
        return this.main;
    }

    public String[] variants() {
        return this.variants;
    }

    public TagKey<BannerPattern> bannerTag() {
        return this.bannerTag;
    }
}