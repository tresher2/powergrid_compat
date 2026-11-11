package com.tresher.powergridcompat.item;

import com.tresher.powergridcompat.fluid.ModFluids;
import com.tresher.powergridcompat.powergrid_compat;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(powergrid_compat.MOD_ID);

    public static final DeferredItem<Item> STAGEEDITOR = ITEMS.register("stageeditor",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
            ));
    public static final DeferredItem<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER.get(),new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
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
