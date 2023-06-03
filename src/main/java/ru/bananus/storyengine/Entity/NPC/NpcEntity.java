package ru.bananus.storyengine.Entity.NPC;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.command.impl.data.EntityDataAccessor;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Objects;


public class NpcEntity extends AnimalEntity implements IAnimatable {

    private static final DataParameter<Boolean> SLEEP =
            EntityDataManager.defineId(NpcEntity.class, DataSerializers.BOOLEAN);

    private static final DataParameter<String> ANIMATION =
            EntityDataManager.defineId(NpcEntity.class, DataSerializers.STRING);

    private static final DataParameter<String> EMOTION =
            EntityDataManager.defineId(NpcEntity.class, DataSerializers.STRING);
    private static final DataParameter<Boolean> MOVE =
            EntityDataManager.defineId(NpcEntity.class, DataSerializers.BOOLEAN);
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public NpcEntity(EntityType<? extends AnimalEntity> p_27557_, World world) {
        super(p_27557_, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        super.registerGoals();
    }

    public static AttributeModifierMap setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    @Override
    public NpcEntity getBreedOffspring(ServerWorld p_146743_, AgeableEntity p_146744_) {
        return null;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("story.npc.walk"));
            return PlayState.CONTINUE;

        }

        /*
        if (!this.getAnimation().equals("")) {
            event.getController().setAnimation((new AnimationBuilder()).addAnimation(this.getAnimation()));
            return PlayState.CONTINUE;
        }
         */

        event.getController().setAnimation(new AnimationBuilder().addAnimation("story.npc.idle"));
        return PlayState.CONTINUE;
    }

    /*
    private <E extends IAnimatable> PlayState emote(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder()
                .addAnimation(this.getEmote()));
        return PlayState.CONTINUE;
    }
    */


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        /*data.addAnimationController(new AnimationController(this, "controllerEmote",
                0, this::emote));*/
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    /*
    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        setAnimation(tag.getString("animation"));
        setAnimation(tag.getString("emote"));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        tag.putString("animation", this.getAnimation());
        tag.putString("emote", this.getEmote());
    }
     */


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.PLAYER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANIMATION, "");
        this.entityData.define(EMOTION, "");
    }

    public void setSleep(boolean sitting) {
        this.entityData.set(SLEEP, sitting);
    }


    public void setMove(boolean sitting) {
        this.entityData.set(MOVE, sitting);
    }

    /*
    public void setAnimation(String animations) {
        this.entityData.set(ANIMATION, animations);
    }

    public String getAnimation() {
        return this.entityData.get(ANIMATION);
    }

    public void setEmote(String emote) {
        this.entityData.set(EMOTION, emote);
    }

    public String getEmote() {
        return this.entityData.get(ANIMATION);
    }
*/
    public boolean isMove() {
        return this.entityData.get(SLEEP);
    }


    @Override
    public boolean removeWhenFarAway(double p_213397_1_) {
        return false;
    }
}