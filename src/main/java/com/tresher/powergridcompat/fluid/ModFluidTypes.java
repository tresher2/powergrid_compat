package com.tresher.powergridcompat.fluid;

import net.minecraft.resources.ResourceLocation;
import com.tresher.powergridcompat.powergrid_compat;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES,powergrid_compat.MOD_ID);

    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.withDefaultNamespace("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.withDefaultNamespace("block/water_flow");
    public static final ResourceLocation SOAP_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(powergrid_compat.MOD_ID,"misc/in_soap_water");

    public static final DeferredHolder<FluidType, BaseFluidType> SOAP_WATER_FLUID_TYPE=register("soap_water_fluid",
            FluidType.Properties.create()
                    .canSwim(false)
                    .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
                    .lightLevel(2)
                    .density(15)
                    .viscosity(5)
    );
    private static DeferredHolder<FluidType, BaseFluidType> register(String name,FluidType.Properties properties){
        return FLUID_TYPES.register(name, ()-> new BaseFluidType(WATER_STILL_RL,WATER_FLOWING_RL,SOAP_OVERLAY_RL,
                0xA1E038D0 ,new Vector3f(224f/255f,56f/255f,208f/255f),properties));
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
