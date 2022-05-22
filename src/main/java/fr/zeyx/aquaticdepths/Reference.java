package fr.zeyx.aquaticdepths;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Reference {

    public static final String MODID = "aquaticdepths";

    public static final CreativeModeTab AQUATIC_DEPTHS_TAB = new CreativeModeTab("aquaticDepthsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.WATER_BUCKET);
        }
    };

}
