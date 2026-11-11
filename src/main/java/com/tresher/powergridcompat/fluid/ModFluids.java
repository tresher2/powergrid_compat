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

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE_SOAP_WATER =
            FLUIDS.register("soap_water_fluid",
                    () -> new BaseFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_SOAP_WATER =
            FLUIDS.register("flowing_soap_water",
                    () -> new BaseFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));


    public static final BaseFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new  BaseFlowingFluid.Properties(
            ModFluidTypes.SOAP_WATER_FLUID_TYPE,SOURCE_SOAP_WATER,FLOWING_SOAP_WATER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.SOAP_WATER_BLOCK)
            .bucket(ModItems.SOAP_WATER_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}