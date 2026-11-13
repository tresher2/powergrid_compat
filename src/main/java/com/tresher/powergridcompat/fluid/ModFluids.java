package com.tresher.powergridcompat.fluid;


import com.tresher.powergridcompat.block.ModBlocks;
import com.tresher.powergridcompat.item.ModItems;
import com.tresher.powergridcompat.powergrid_compat;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static  final DeferredRegister<Fluid> FLUIDS=
            DeferredRegister.create(Registries.FLUID, powergrid_compat.MOD_ID);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE_DESTABILIZED_REDSTONE =
            FLUIDS.register("destabilized_redstone_fluid",
                    () -> new BaseFlowingFluid.Source(ModFluids.DESTABILIZED_REDSTONE_FLUID_PROPERTIES));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_DESTABILIZED_REDSTONE =
            FLUIDS.register("destabilized_redstone_water",
                    () -> new BaseFlowingFluid.Flowing(ModFluids.DESTABILIZED_REDSTONE_FLUID_PROPERTIES));


    public static final BaseFlowingFluid.Properties DESTABILIZED_REDSTONE_FLUID_PROPERTIES = new  BaseFlowingFluid.Properties(
            ModFluidTypes.DESTABILIZED_REDSTONE_FLUID_TYPE,SOURCE_DESTABILIZED_REDSTONE,FLOWING_DESTABILIZED_REDSTONE)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.DESTABILIZED_REDSTONE_BLOCK)
            .bucket(ModItems.DESTABILIZED_REDSTONE_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}