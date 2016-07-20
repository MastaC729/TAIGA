package com.sosnitzka.taiga.traits;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitSoulbound extends AbstractTrait {

    public TraitSoulbound() {
        super("souldbound", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
