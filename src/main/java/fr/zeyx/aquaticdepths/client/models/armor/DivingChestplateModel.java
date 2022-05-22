package fr.zeyx.aquaticdepths.client.models.armor;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.client.models.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

@SuppressWarnings("ALL")
public class DivingChestplateModel<T extends Entity> extends ArmorModel {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/models/armor/diving_layer_1.png");

	public DivingChestplateModel(ModelPart model) {
		super(model);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 0);
		PartDefinition root = createHumanoidAlias(mesh);

		PartDefinition body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.ZERO);

		PartDefinition chestplate = body.addOrReplaceChild("chestplate", CubeListBuilder.create()
		.texOffs(0, 0).addBox(-5.0F, -24.0F, -3.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 5).addBox(-5.0F, -24.25F, -2.0F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 0).addBox(-5.0F, -12.75F, -2.0F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lead = chestplate.addOrReplaceChild("lead", CubeListBuilder.create()
		.texOffs(0, 26).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 18).addBox(-2.0F, -18.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-4.0F, -24.0F, 3.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 20).addBox(-2.0F, -17.0F, 3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 34).addBox(-3.0F, -23.0F, 4.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(1.0F, -23.0F, 4.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = lead.addOrReplaceChild("cube_r1", CubeListBuilder.create()
		.texOffs(0, 40).addBox(3.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 40).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -21.0F, -4.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rightArm = root.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.ZERO);

		PartDefinition right_arm = rightArm.addOrReplaceChild("right_arm", CubeListBuilder.create()
		.texOffs(0, 48).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(16, 57).addBox(-8.0F, -15.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(5.0F, 22.0F, 0.0F));

		PartDefinition leftArm = root.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = leftArm.addOrReplaceChild("left_arm", CubeListBuilder.create()
		.texOffs(32, 48).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(16, 57).addBox(-8.0F, -15.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(7.0F, 22.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	protected ResourceLocation getTexture() {
		return TEXTURE;
	}
}