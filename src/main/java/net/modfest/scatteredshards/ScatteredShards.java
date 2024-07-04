package net.modfest.scatteredshards;

import net.modfest.scatteredshards.api.ScatteredShardsAPI;
import net.modfest.scatteredshards.load.ShardTypeLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.modfest.scatteredshards.api.shard.ShardType;
import net.modfest.scatteredshards.command.ShardCommand;
import net.modfest.scatteredshards.networking.ScatteredShardsNetworking;

public class ScatteredShards implements ModInitializer {

	public static final String ID = "scattered_shards";

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	public static Identifier id(String path) {
		return Identifier.of(ID, path);
	}
	
	public static String permission(String path) {
		return ID + "." + path;
	}

	@Override
	public void onInitialize() {
		//ScatteredShardsAPI.init();
		ShardType.register();
		ShardTypeLoader.register();
		ShardCommand.register();
		ScatteredShardsNetworking.register();
		ScatteredShardsContent.register();
	}
}
