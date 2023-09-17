package net.darkhax.archaeologybanners.content;

import net.darkhax.bookshelf.api.registry.RegistryDataProvider;

public class BiomeMakeoverPatterns extends PatternProvider {

    public BiomeMakeoverPatterns(RegistryDataProvider registry) {

        super(registry, "biomemakeover");
    }

    @Override
    public void registerPatterns() {

        this.createPattern("refined");
        this.createPattern("whinny", "eyes", "hooves");
        this.createPattern("worker", "handle", "spade");
    }
}