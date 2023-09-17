package net.darkhax.archaeologybanners.content;

import net.darkhax.bookshelf.api.registry.RegistryDataProvider;

public class MinecraftPattern extends PatternProvider {

    public MinecraftPattern(RegistryDataProvider registry) {

        super(registry, "minecraft");
    }

    @Override
    public void registerPatterns() {

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
}