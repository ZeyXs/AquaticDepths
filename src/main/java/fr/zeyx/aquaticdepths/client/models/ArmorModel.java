package fr.zeyx.aquaticdepths.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@SuppressWarnings("ALL")
public class ArmorModel<T extends LivingEntity> extends HumanoidModel<T> implements IItemRenderProperties {

    protected boolean isChildHeadScaled = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_102007_");
    protected float childHeadScale = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_102010_");
    protected float childHeadOffsetY = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_170338_");
    protected float childHeadOffsetZ = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_170339_");
    protected float childBodyScale = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_102011_");
    protected float childBodyOffsetY = ObfuscationReflectionHelper.getPrivateValue(AgeableListModel.class, this, "f_102012_");

    public EquipmentSlot slot;
    ModelPart root, modelHead, modelBody, modelLeft_arm, modelRight_arm, modelBelt, modelLeft_leg, modelRight_leg, modelLeft_foot, modelRight_foot;;

    public ArmorModel(ModelPart root) {
        super(root);
        this.root = root;
        this.modelHead = root.getChild("Head");
        this.modelBody = root.getChild("Body");
        this.modelLeft_arm = root.getChild("LeftArm");
        this.modelRight_arm = root.getChild("RightArm");
        this.modelRight_leg = root.getChild("LeftLeg");
        this.modelLeft_leg = root.getChild("RightLeg");
        this.modelBelt = root.getChild("Belt");
        this.modelRight_foot = root.getChild("RightBoot");
        this.modelLeft_foot = root.getChild("LeftBoot");
    }

    public static PartDefinition createHumanoidAlias(MeshDefinition mesh) {
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("Head", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("Body", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("LeftArm", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("RightArm", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("LeftLeg", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("RightLeg", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("Belt", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("LeftBoot", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("RightBoot", new CubeListBuilder(), PartPose.ZERO);
        return root;
    }

    public void copyFromDefault(HumanoidModel model) {
        modelHead.copyFrom(model.head);
        modelBody.copyFrom(model.body);
        modelBelt.copyFrom(model.body);
        modelLeft_arm.copyFrom(model.leftArm);
        modelRight_arm.copyFrom(model.rightArm);
        modelLeft_leg.copyFrom(model.leftLeg);
        modelRight_leg.copyFrom(model.rightLeg);
        modelLeft_foot.copyFrom(model.leftLeg);
        modelRight_foot.copyFrom(model.rightLeg);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return slot == EquipmentSlot.HEAD ? ImmutableList.of(modelHead) : ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        if (slot == EquipmentSlot.CHEST)
            return ImmutableList.<ModelPart>of(modelBody, modelLeft_arm, modelRight_arm);
        if (slot == EquipmentSlot.LEGS)
            return ImmutableList.<ModelPart>of(modelLeft_leg, modelRight_leg, modelBelt);
        if (slot == EquipmentSlot.FEET)
            return ImmutableList.<ModelPart>of(modelLeft_foot, modelRight_foot);
        else return ImmutableList.of();
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        VertexConsumer iVertexBuilder = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.entityTranslucent(this.getTexture()));

        if (this.young)
        {
            matrixStackIn.pushPose();
            if (this.isChildHeadScaled)
            {
                float f = 1.5F / this.childHeadScale;
                matrixStackIn.scale(f, f, f);
            }

            matrixStackIn.translate(0.0D, (double) (this.childHeadOffsetY / 16.0F), (double) (this.childHeadOffsetZ / 16.0F));
            this.headParts().forEach((modelRenderer) ->
            {
                modelRenderer.render(matrixStackIn, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.popPose();
            matrixStackIn.pushPose();
            float f1 = 1.0F / this.childBodyScale;
            matrixStackIn.scale(f1, f1, f1);
            matrixStackIn.translate(0.0D, (double) (this.childBodyOffsetY / 16.0F), 0.0D);
            this.bodyParts().forEach((modelRenderer) -> {
                modelRenderer.render(matrixStackIn, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.popPose();
        }
        else
        {
            this.headParts().forEach((modelRenderer) ->
            {
                modelRenderer.render(matrixStackIn, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            this.bodyParts().forEach((modelRenderer) ->
            {
                modelRenderer.render(matrixStackIn, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
        }
    }

    protected ResourceLocation getTexture() {
        return null /*new ResourceLocation(Reference.MODID, "textures/models/armor/")*/;
    }
}
