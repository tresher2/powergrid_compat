package com.tresher.powergridcompat.item;

import com.tresher.powergridcompat.fluid.ModFluids;
import com.tresher.powergridcompat.powergrid_compat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Optional;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(powergrid_compat.MOD_ID);

    public static final DeferredItem<Item> DESTABILIZED_REDSTONE = ITEMS.register("destabilized_redstone",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)

            ));
    public static final DeferredItem<Item> DESTABILIZED_REDSTONE_BUCKET = ITEMS.register("destabilized_redstone_bucket",
            () -> new BucketItem(ModFluids.SOURCE_DESTABILIZED_REDSTONE.get(),new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
                    .rarity(Rarity.UNCOMMON)
            ));
    public static final DeferredItem<Item> MICROCONTROLLER = ITEMS.register("microcontroller",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties(-1,0.5F,true,0.7f, Optional.empty(), List.of()))
            ));

    //дублировать строчку выше, что бы создать ещё предмет, тут можно использовать _,
    // надо ещё прописать в меню,
    // в языках (через зяпятую) item.oresources.strangeitem = то же имя, что и в регистре
    // models/ если перетащить json в item, то можно создать дубликат и переименовать в тоже имя
    // в моделях указать текстуру



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
