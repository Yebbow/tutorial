package net.yebbowknight.universal.entity.client;

import net.yebbowknight.universal.Crossovermod;
import net.yebbowknight.universal.entity.custom.RaccoonEntity;
import net.yebbowknight.universal.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerModel extends AnimatedGeoModel<TigerEntity> {
    @Override
    public ResourceLocation getModelLocation(TigerEntity entity)	{
        return new ResourceLocation(Crossovermod.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TigerEntity entity) {
        return new ResourceLocation(Crossovermod.MOD_ID, "textures/entity/tiger/tiger.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TigerEntity entity)	{
        return new ResourceLocation(Crossovermod.MOD_ID, "animations/tiger.animation.json");
    }
}