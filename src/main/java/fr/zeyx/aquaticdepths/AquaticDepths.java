package fr.zeyx.aquaticdepths;

import fr.zeyx.aquaticdepths.blocks.BlockRegistry;
import fr.zeyx.aquaticdepths.client.gui.InGameOverlay;
import fr.zeyx.aquaticdepths.client.models.ArmorLayers;
import fr.zeyx.aquaticdepths.items.ItemRegistry;
import net.minecraft.client.Camera;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MODID)
public class AquaticDepths
{
    private static final Logger LOGGER = LogManager.getLogger();

    public AquaticDepths() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(ArmorLayers::initPost);
            ArmorLayers.init();
        });

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Aquatic Depths created by ZeyX_ with <3");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        InGameOverlay.register();
    }
}
