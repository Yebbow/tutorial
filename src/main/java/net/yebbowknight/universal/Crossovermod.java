package net.yebbowknight.universal;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yebbowknight.universal.block.ModBlocks;
import net.yebbowknight.universal.block.ModWoodTypes;
import net.yebbowknight.universal.block.entity.ModBlockEntities;
import net.yebbowknight.universal.config.CrossoverClientConfigs;
import net.yebbowknight.universal.config.CrossoverCommonConfigs;
import net.yebbowknight.universal.effect.ModEffects;
import net.yebbowknight.universal.enchantment.ModEnchantments;
import net.yebbowknight.universal.entity.ModEntityTypes;
import net.yebbowknight.universal.item.ModItems;
import net.yebbowknight.universal.painting.ModPaintings;
import net.yebbowknight.universal.potion.ModPotions;
import net.yebbowknight.universal.recipe.ModRecipes;
import net.yebbowknight.universal.sound.ModSounds;
import net.yebbowknight.universal.util.BetterBrewingRecipe;
import net.yebbowknight.universal.villager.ModVillagers;
import net.yebbowknight.universal.world.feature.ModPlacedFeatures;
import net.yebbowknight.universal.world.structure.ModStructures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Crossovermod.MOD_ID)
public class Crossovermod
{
    public static final String MOD_ID = "crossover";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // very important Comment
    public Crossovermod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEnchantments.register(eventBus);
        ModSounds.register(eventBus);
        ModPaintings.register(eventBus);
        //ModFluids.register(eventBus);

        ModBlockEntities.register(eventBus);
      //  ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);
        ModEffects.register(eventBus);

        ModPotions.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModStructures.register(eventBus);
        ModVillagers.register(eventBus);

        ModPlacedFeatures.register(eventBus);

        GeckoLib.initialize();

        eventBus.addListener(this::setup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CrossoverClientConfigs.SPEC, "crossover-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CrossoverCommonConfigs.SPEC, "crossover-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP_SEEDS.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP.get(),5f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

            BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
            Sheets.addWoodType(ModWoodTypes.CHERRY_BLOSSOM);

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.COBALT_INGOT.get(), ModPotions.FREEZE_POTION.get()));

            ModVillagers.registerPOIs();

        });
    }
}
