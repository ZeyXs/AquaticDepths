package fr.zeyx.aquaticdepths.client.models.armor;

import fr.zeyx.aquaticdepths.Reference;
import fr.zeyx.aquaticdepths.client.models.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DivingBootsModel<T extends Entity> extends ArmorModel {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/models/armor/diving_layer_2.png");

	public DivingBootsModel(ModelPart model) {
		super(model);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 0);
		PartDefinition root = createHumanoidAlias(mesh);

		PartDefinition RightLeg = root.addOrReplaceChild("RightBoot", CubeListBuilder.create()
				.texOffs(16, 7).addBox(-2.0F, 8.25F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftLeg = root.addOrReplaceChild("LeftBoot", CubeListBuilder.create()
				.texOffs(16, 7).addBox(-2.0F, 8.25F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	protected ResourceLocation getTexture() {
		return TEXTURE;
	}
}