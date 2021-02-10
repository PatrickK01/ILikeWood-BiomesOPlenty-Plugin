package yamahari.ilikewood.plugin.biomesoplenty;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelProvider;
import yamahari.ilikewood.plugin.util.Constants;
import yamahari.ilikewood.plugin.util.Util;
import yamahari.ilikewood.plugin.util.resources.WoodenLogResource;
import yamahari.ilikewood.plugin.util.resources.WoodenPlanksResource;
import yamahari.ilikewood.plugin.util.resources.WoodenSlabResource;
import yamahari.ilikewood.plugin.util.resources.WoodenStrippedLogResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenLogResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenPlanksResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenSlabResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenStrippedLogResource;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class BiomesOPlentyWoodenResources {
    public static final Map<IWoodType, IWoodenPlanksResource> PLANKS;
    public static final Map<IWoodType, IWoodenLogResource> LOGS;
    public static final Map<IWoodType, IWoodenStrippedLogResource> STRIPPED_LOGS;
    public static final Map<IWoodType, IWoodenSlabResource> SLABS;

    private static final Map<IWoodType, AbstractBlock.Properties> PLANKS_PROPERTIES =
        new ImmutableMap.Builder<IWoodType, AbstractBlock.Properties>()
            .put(BiomesOPlentyWoodTypes.CHERRY,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.RED)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.DEAD,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.STONE)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.FIR,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.HELLBARK,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.GRAY_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.JACARANDA,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.MAGIC,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.BLUE)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.MAHOGANY,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.PINK_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.PALM,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.YELLOW_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.REDWOOD,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.UMBRAN,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .put(BiomesOPlentyWoodTypes.WILLOW,
                AbstractBlock.Properties
                    .create(Material.WOOD, MaterialColor.LIME_TERRACOTTA)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD))
            .build();

    static {
        final Map<IWoodType, IWoodenPlanksResource> planks = new HashMap<>();
        final Map<IWoodType, IWoodenLogResource> logs = new HashMap<>();
        final Map<IWoodType, IWoodenStrippedLogResource> strippedLogs = new HashMap<>();
        final Map<IWoodType, IWoodenSlabResource> slabs = new HashMap<>();

        BiomesOPlentyWoodTypes.get().forEach(woodType -> {
            final ResourceLocation planksResource =
                new ResourceLocation(Constants.BOP_MOD_ID, Util.toRegistryName(woodType.getName(), "planks"));
            final ResourceLocation logResource =
                new ResourceLocation(Constants.BOP_MOD_ID, Util.toRegistryName(woodType.getName(), "log"));
            final ResourceLocation strippedLogResource =
                new ResourceLocation(Constants.BOP_MOD_ID, Util.toRegistryName("stripped", woodType.getName(), "log"));
            final ResourceLocation slabResource =
                new ResourceLocation(Constants.BOP_MOD_ID, Util.toRegistryName(woodType.getName(), "slab"));

            final ResourceLocation planksTexture = new ResourceLocation(planksResource.getNamespace(),
                Util.toPath(ModelProvider.BLOCK_FOLDER, planksResource.getPath()));

            planks.put(woodType,
                new WoodenPlanksResource(planksTexture, planksResource, PLANKS_PROPERTIES.get(woodType)));

            logs.put(woodType,
                new WoodenLogResource(new ResourceLocation(logResource.getNamespace(),
                    Util.toPath(ModelProvider.BLOCK_FOLDER, Util.toRegistryName(logResource.getPath(), "top"))),
                    new ResourceLocation(logResource.getNamespace(),
                        Util.toPath(ModelProvider.BLOCK_FOLDER, logResource.getPath())),
                    logResource));

            strippedLogs.put(woodType,
                new WoodenStrippedLogResource(new ResourceLocation(strippedLogResource.getNamespace(),
                    Util.toPath(ModelProvider.BLOCK_FOLDER, Util.toRegistryName(strippedLogResource.getPath(), "top"))),
                    new ResourceLocation(strippedLogResource.getNamespace(),
                        Util.toPath(ModelProvider.BLOCK_FOLDER, strippedLogResource.getPath())),
                    strippedLogResource));

            slabs.put(woodType, new WoodenSlabResource(planksTexture, planksTexture, planksTexture, slabResource));
        });

        PLANKS = Collections.unmodifiableMap(planks);
        LOGS = Collections.unmodifiableMap(logs);
        STRIPPED_LOGS = Collections.unmodifiableMap(strippedLogs);
        SLABS = Collections.unmodifiableMap(slabs);
    }

    private BiomesOPlentyWoodenResources() {
    }
}
