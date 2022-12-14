/*package net.yebbowknight.universal.event.loot;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class TurnipSeedsFromGrassAdditionModifier extends LootModifier {
    private final Item addition;

    protected TurnipSeedsFromGrassAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // generatedLoot is the loot that would be dropped, if we wouldn't add or replace
        // anything!
        generatedLoot.add(new ItemStack(addition, 1));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return null;
    }

    public static class Serializer extends GlobalLootModifierSerializer<TurnipSeedsFromGrassAdditionModifier> {

        @Override
        public TurnipSeedsFromGrassAdditionModifier read(ResourceLocation name, JsonObject object,
                                                         LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new TurnipSeedsFromGrassAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(TurnipSeedsFromGrassAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }

        private JsonObject makeConditions(LootItemCondition[] conditions) {
        }
    }
}*/