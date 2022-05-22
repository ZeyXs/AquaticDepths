package fr.zeyx.aquaticdepths.items.armor;

import fr.zeyx.aquaticdepths.client.models.*;
import fr.zeyx.aquaticdepths.client.models.armor.DivingBootsModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingChestplateModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingHelmetModel;
import fr.zeyx.aquaticdepths.client.models.armor.DivingLeggingsModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

@SuppressWarnings("ALL")
public class DivingArmorItem extends ArmorItem {

    public DivingArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {

            static DivingHelmetModel divingHelmetModel;
            static DivingChestplateModel divingChestplateModel;
            static DivingLeggingsModel divingLeggingsModel;
            static DivingBootsModel divingBootsModel;

            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                switch (armorSlot) {
                    case HEAD -> {
                        if (divingHelmetModel == null)
                            divingHelmetModel = new DivingHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ArmorLayers.DIVING_HELMET));
                        divingHelmetModel.slot = slot;
                        divingHelmetModel.copyFromDefault(_default);
                        return divingHelmetModel;
                    }
                    case CHEST -> {
                        if (divingChestplateModel == null)
                            divingChestplateModel = new DivingChestplateModel(Minecraft.getInstance().getEntityModels().bakeLayer(ArmorLayers.DIVING_CHESTPLATE));
                        divingChestplateModel.slot = slot;
                        divingChestplateModel.copyFromDefault(_default);
                        return divingChestplateModel;
                    }
                    case LEGS -> {
                        if (divingLeggingsModel == null)
                            divingLeggingsModel = new DivingLeggingsModel(Minecraft.getInstance().getEntityModels().bakeLayer(ArmorLayers.DIVING_LEGGINGS));
                        divingLeggingsModel.slot = slot;
                        divingLeggingsModel.copyFromDefault(_default);
                        return divingLeggingsModel;
                    }
                    default -> {
                        if (divingBootsModel == null)
                            divingBootsModel = new DivingBootsModel(Minecraft.getInstance().getEntityModels().bakeLayer(ArmorLayers.DIVING_BOOTS));
                        divingBootsModel.slot = slot;
                        divingBootsModel.copyFromDefault(_default);
                        return divingBootsModel;
                    }
                }
            }
        });
    }
}
