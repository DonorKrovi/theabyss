package net.yezon.theabyss.events;

import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class Mana40Event {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).Mana < 40) {
			return false;
		} else if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).Mana == 40) {
			return true;
		}
		return true;
	}
}