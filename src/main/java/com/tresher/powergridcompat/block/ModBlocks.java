package com.tresher.powergridcompat.block;


import com.tresher.powergridcompat.fluid.ModFluids;
import com.tresher.powergridcompat.item.ModItems;
import com.tresher.powergridcompat.powergrid_compat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;
public class ModBlocks {
    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (p_50763_) -> (Boolean)p_50763_.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(powergrid_compat.MOD_ID);

    public static final DeferredBlock<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block",
            ()->new LiquidBlock(ModFluids.SOURCE_SOAP_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));



    private static <T extends Block> DeferredBlock<T> registerBLock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
