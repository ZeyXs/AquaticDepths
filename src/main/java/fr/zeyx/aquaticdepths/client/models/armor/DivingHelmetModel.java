package fr.zeyx.aquaticdepths.client.models.armor;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.client.models.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DivingHelmetModel<T extends Entity> extends ArmorModel {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/models/armor/diving_layer_1.png");

	public DivingHelmetModel(ModelPart model) {
		super(model);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 0);
		PartDefinition root = createHumanoidAlias(mesh);

		PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = Head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(24, 12).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(30, 46).addBox(-3.0F, -1.0F, -6.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-4.0F, -8.0F, -6.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 48).addBox(-4.0F, -7.0F, -6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 14).addBox(3.0F, -8.0F, -6.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 45).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right = bone.addOrReplaceChild("right", CubeListBuilder.create().texOffs(41, 56).addBox(-6.0F, -8.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 49).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 48).addBox(-6.0F, -8.0F, 3.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 55).addBox(-6.0F, -7.0F, -4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left = bone.addOrReplaceChild("left", CubeListBuilder.create().texOffs(41, 56).addBox(-6.0F, -8.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 49).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(54, 55).addBox(-6.0F, -8.0F, 3.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 43).addBox(-6.0F, -7.0F, -4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 0.0F));

		PartDefinition back = bone.addOrReplaceChild("back", CubeListBuilder.create().texOffs(46, 32).addBox(-4.0F, -7.0F, 5.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition bars1 = bone.addOrReplaceChild("bars1", CubeListBuilder.create().texOffs(15, 32).addBox(-6.0F, -7.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bars2 = bone.addOrReplaceChild("bars2", CubeListBuilder.create().texOffs(15, 32).addBox(-6.0F, -7.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 0.0F, 0.0F));

		PartDefinition bars3 = bone.addOrReplaceChild("bars3", CubeListBuilder.create().texOffs(62, 15).addBox(-4.0F, -7.0F, -7.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 57).addBox(4.0F, -7.0F, -7.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 29).addBox(-3.0F, 0.0F, -7.0F, 6.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 29).addBox(-3.0F, -8.0F, -7.0F, 6.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 32).addBox(-4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	protected ResourceLocation getTexture() {
		return TEXTURE;
	}
}