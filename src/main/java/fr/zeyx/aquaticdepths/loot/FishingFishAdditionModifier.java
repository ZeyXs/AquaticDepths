package fr.zeyx.aquaticdepths.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FishingFishAdditionModifier extends LootModifier {

    private final Item item;
    private final int weight;

    protected FishingFishAdditionModifier(LootItemCondition[] conditionsIn, Item item, int weight) {
        super(conditionsIn);
        this.item = item;
        this.weight = weight;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() > ((double)weight / 100)) {
            generatedLoot.add(new ItemStack(item, 1));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<FishingFishAdditionModifier> {

        @Override
        public FishingFishAdditionModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "item")));
            int weight = GsonHelper.getAsInt(object, "weight");
            return new FishingFishAdditionModifier(conditionsIn, item, weight);
        }

        @Override
        public JsonObject write(FishingFishAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            return json;
        }
    }

}
