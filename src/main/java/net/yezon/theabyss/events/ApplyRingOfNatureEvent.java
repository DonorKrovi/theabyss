package net.yezon.theabyss.events;

import net.yezon.theabyss.item.RingOfNatureItem;
import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class ApplyRingOfNatureEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyRingOfNature!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RingOfNatureItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 8
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if (itemstack.getItem() == RingOfNatureItem.block) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x + 1), (int) y, (int) z))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x + 1), (int) y, (int) z),
									(Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x + 1), (int) y, (int) z), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x - 1), (int) y, (int) z))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x - 1), (int) y, (int) z),
									(Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x - 1), (int) y, (int) z), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) (z + 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) (z + 1)),
									(Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) x, (int) y, (int) (z + 1)), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) (z - 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) (z - 1)),
									(Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) x, (int) y, (int) (z - 1)), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
									new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), (Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
									new BlockPos((int) (x + 1), (int) y, (int) (z - 1)), (Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x + 1), (int) y, (int) (z - 1)), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
									new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), (Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), 0);
					}
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))
							|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
									new BlockPos((int) (x - 1), (int) y, (int) (z + 1)), (Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos((int) (x - 1), (int) y, (int) (z + 1)), 0);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world)
							.playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("theabyss:spell_of_invisibility")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("theabyss:spell_of_invisibility")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				{
					double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).Mana
							- 8 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade);
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}