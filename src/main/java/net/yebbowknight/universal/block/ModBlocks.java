package net.yebbowknight.universal.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yebbowknight.universal.Crossovermod;
import net.yebbowknight.universal.block.custom.*;
import net.yebbowknight.universal.item.ModCreativeModeTab;
import net.yebbowknight.universal.item.ModItems;
import net.yebbowknight.universal.sound.ModSounds;
import net.yebbowknight.universal.world.feature.tree.CherryBlossomTreeGrower;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Crossovermod.MOD_ID);

    public static final RegistryObject<Block> GROUND_BLOCK = registerBlock("ground_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> UNDERGROUND_BLOCK = registerBlock("underground_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 4)), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);


    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB, "tooltip.block.speedy_block");



    public static final RegistryObject<Block> COBALT_STAIRS = registerBlock("cobalt_stairs",
            () -> new StairBlock(() -> ModBlocks.COBALT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)
                            .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> COBALT_SLAB = registerBlock("cobalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> COBALT_BUTTON = registerBlock("cobalt_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops().noCollission()), ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> COBALT_FENCE = registerBlock("cobalt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> COBALT_WALL = registerBlock("cobalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.CROSS_TAB);


    public static final RegistryObject<Block> COBALT_LAMP = registerBlock("cobalt_lamp",
            () -> new CobaltLampBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops().sound(ModSounds.COBALT_LAMP_SOUNDS)
                    .lightLevel((state) -> state.getValue(CobaltLampBlock.CLICKED) ? 15 : 0)),
            ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> SUN_BLOCK = registerBlock("sun_block",
            () -> new SunBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()
                    .lightLevel((state) -> state.getValue(SunBlock.CLICKED) ? 5000 : 1)),
            ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> TURNIP_CROP = BLOCKS.register("turnip_crop",
            () -> new TurnipCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)
                    .strength(2f).noCollission().noOcclusion()));

    public static final RegistryObject<Block> PINK_ROSE = registerBlock("pink_rose",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> COBALT_BLASTER = registerBlock("cobalt_blaster",
            () -> new CobaltBlasterBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()),
            ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LOG = registerBlock("cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_WOOD = registerBlock("cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_LOG = registerBlock("stripped_cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_WOOD = registerBlock("stripped_cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_PLANKS = registerBlock("cherry_blossom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LEAVES = registerBlock("cherry_blossom_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.CROSS_TAB);


    public static final RegistryObject<Block> CHERRY_BLOSSOM_SAPLING = registerBlock("cherry_blossom_sapling",
            () -> new SaplingBlock(new CherryBlossomTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> WINTER_WINDOW = registerBlock("winter_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)),
            ModCreativeModeTab.CROSS_TAB);
    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of(Material.STONE)), ModCreativeModeTab.CROSS_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_SIGN = BLOCKS.register("cherry_blossom_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));

    public static final RegistryObject<Block> CHERRY_BLOSSOM_WALL_SIGN = BLOCKS.register("cherry_blossom_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                          CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.translatable(tooltipKey));
            }
        });
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
