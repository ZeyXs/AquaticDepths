package fr.zeyx.aquaticdepths.client.models;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.client.models.armor.DivingBootsModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingChestplateModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingHelmetModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingLeggingsModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ArmorLayers {

    public static final ModelLayerLocation DIVING_HELMET = layer("diving_helmet");
    public static final ModelLayerLocation DIVING_CHESTPLATE = layer("diving_chestplate");
    public static final ModelLayerLocation DIVING_LEGGINGS = layer("diving_leggings");
    public static final ModelLayerLocation DIVING_BOOTS = layer("diving_boots");

    public static DivingHelmetModel<LivingEntity> helmetModel = null;
    public static DivingHelmetModel<LivingEntity> chestplateModel = null;
    public static DivingLeggingsModel<LivingEntity> divingLeggingsModel = null;
    public static DivingBootsModel<LivingEntity> divingBootsModel = null;

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ArmorLayers::initLayers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ArmorLayers::initModels);
    }

    public static void initPost(FMLClientSetupEvent event) {
    }

    private static void initLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ArmorLayers.DIVING_HELMET, DivingHelmetModel::createBodyLayer);
        event.registerLayerDefinition(ArmorLayers.DIVING_CHESTPLATE, DivingChestplateModel::createBodyLayer);
        event.registerLayerDefinition(ArmorLayers.DIVING_LEGGINGS, DivingLeggingsModel::createBodyLayer);
        event.registerLayerDefinition(ArmorLayers.DIVING_BOOTS, DivingBootsModel::createBodyLayer);
    }

    public static void initModels(EntityRenderersEvent.AddLayers event) {
        EntityModelSet model = Minecraft.getInstance().getEntityModels();
        helmetModel = new DivingHelmetModel<>(model.bakeLayer(DIVING_HELMET));
        chestplateModel = new DivingHelmetModel<>(model.bakeLayer(DIVING_CHESTPLATE));
        divingLeggingsModel = new DivingLeggingsModel<>(model.bakeLayer(DIVING_LEGGINGS));
        divingBootsModel = new DivingBootsModel<>(model.bakeLayer(DIVING_BOOTS));
    }

    private static ModelLayerLocation layer(String name) {
        return layer(name, "main");
    }

    private static ModelLayerLocation layer(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(Reference.MODID, name), layer);
    }
}
