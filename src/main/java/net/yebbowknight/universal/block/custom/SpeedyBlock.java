package net.yebbowknight.universal.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SpeedyBlock extends Block {
    public SpeedyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
        float chance = 0.35f;

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide()) {
            if(pEntity instanceof LivingEntity) {
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}