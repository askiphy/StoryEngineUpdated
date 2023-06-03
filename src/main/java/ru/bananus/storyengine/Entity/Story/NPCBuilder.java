package ru.bananus.storyengine.Entity.Story;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import ru.bananus.storyengine.Entity.NPC.NpcEntity;
import ru.bananus.storyengine.Utils.StoryUtils;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.core.builder.Animation;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.Objects;
import java.util.Set;

public class NPCBuilder {
    public static MobEntity entity;
    public static String name = null;

    public NPCBuilder(MobEntity entity, BlockPos pos){
        entity.setPos(pos.getX(),pos.getY(),pos.getZ());
        entity.level.addFreshEntity(entity);
        this.entity = entity;
    }

    public void stopMoveEntity(){
        Set<PrioritizedGoal> goal = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, entity.goalSelector, "goals");
        for (PrioritizedGoal availableGoal: goal) {
            if (availableGoal.getGoal().toString().equals("MovePlayerEntity")){
                entity.goalSelector.removeGoal(availableGoal.getGoal());
            }
        }
    }

    public void mainHandItem(ItemStack itemStack) {
       entity.setItemSlot(EquipmentSlotType.MAINHAND, itemStack);
    }

    /*public void setAnim(String show){
        NpcEntity npc = (NpcEntity) entity;
        npc.setAnimation(show);
    }

    public void setEmote(String emote){
        NpcEntity npc = (NpcEntity) entity;
        npc.setEmote(emote);
    }
     */

    public void moveEntity(Vector3d vector3d, float speed){
        entity.goalSelector.addGoal(1, new MovePlayerEntity(entity, vector3d, speed));
    }

    public void rotate(float yaw){
        this.entity.yRotO = yaw;
    }

    public void mobSay(String text, PlayerEntity player){
        if (name == null){
            name = "Noname";
        }
        StoryUtils.sendMessage(player, name, text);
    }


    public String getName() {
        return name;
    }

    public void remove() {
        entity.remove();
    }

    public void setPos(double x, double y, double z) {
        entity.setPos(x, y, z);
    }
}
