package fr.zeyx.aquaticdepths.items;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.items.armor.ArmorMaterial;
import fr.zeyx.aquaticdepths.items.armor.DivingArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> DIVING_BOOTS = ITEMS.register("diving_boots", () -> new DivingArmorItem(ArmorMaterial.DIVING, EquipmentSlot.FEET, new Item.Properties().tab(Reference.AQUATIC_DEPTHS_TAB)));
    public static final RegistryObject<Item> DIVING_LEGGINGS = ITEMS.register("diving_leggings", () -> new DivingArmorItem(ArmorMaterial.DIVING, EquipmentSlot.LEGS, new Item.Properties().tab(Reference.AQUATIC_DEPTHS_TAB)));
    public static final RegistryObject<Item> DIVING_CHESTPLATE = ITEMS.register("diving_chestplate", () -> new DivingArmorItem(ArmorMaterial.DIVING, EquipmentSlot.CHEST, new Item.Properties().tab(Reference.AQUATIC_DEPTHS_TAB)));
    public static final RegistryObject<Item> DIVING_HELMET = ITEMS.register("diving_helmet", () -> new DivingArmorItem(ArmorMaterial.DIVING, EquipmentSlot.HEAD, new Item.Properties().tab(Reference.AQUATIC_DEPTHS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
