package net.yebbowknight.universal.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.yebbowknight.universal.Crossovermod;
import net.yebbowknight.universal.item.custom.CobaltArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CobaltArmorModel extends AnimatedGeoModel<CobaltArmorItem> {
    @Override
    public ResourceLocation getModelResource(CobaltArmorItem object) {
        return new ResourceLocation(Crossovermod.MOD_ID, "geo/cobalt_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CobaltArmorItem object) {
        return new ResourceLocation(Crossovermod.MOD_ID, "textures/models/armor/cobalt_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CobaltArmorItem animatable) {
        return new ResourceLocation(Crossovermod.MOD_ID, "animations/armor_animation.json");
    }
}