package fr.zeyx.aquaticdepths.events;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.loot.FishingFishAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModifierSerializerEvent {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {

        event.getRegistry().registerAll(
                new FishingFishAdditionModifier.Serializer().setRegistryName(new ResourceLocation(Reference.MODID, "fish"))
        );

    }

}
