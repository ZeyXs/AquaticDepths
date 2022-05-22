package fr.zeyx.aquaticdepths.client.models.armor;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.client.models.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DivingLeggingsModel<T extends Entity> extends ArmorModel {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/models/armor/diving_layer_2.png");

	public DivingLeggingsModel(ModelPart model) {
		super(model);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 0);
		PartDefinition root = createHumanoidAlias(mesh);

		PartDefinition Body = root.addOrReplaceChild("Belt", CubeListBuilder.create()
				.texOffs(16, 0).addBox(-4.1F, 9.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = root.addOrReplaceChild("RightLeg", CubeListBuilder.create()
				.texOffs(0, 13).addBox(-2.2F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftLeg = root.addOrReplaceChild("LeftLeg", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	protected ResourceLocation getTexture() {
		return TEXTURE;
	}
}