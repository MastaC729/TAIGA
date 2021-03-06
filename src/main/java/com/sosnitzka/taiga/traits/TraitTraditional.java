package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitTraditional extends AbstractTrait {


    public TraitTraditional() {
        super("traditional", 0xff33ff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        World w = e.getEntity().getEntityWorld();
        if (!w.isRemote && e.getSource().getEntity() instanceof EntityPlayer && e.getEntity() instanceof EntityCreature) {
            if (TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand()), identifier)) {
                String name = EntityList.getEntityString(e.getEntity());
            }
        }
    }

    public static class Data {

        String mobname;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.mobname = tag.getString("mob");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setString("amount", mobname);
        }
    }

}
