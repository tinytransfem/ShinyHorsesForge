package gay.ttf.shinyhorses;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ShinyHorses {
    public ShinyHorses(IEventBus eventBus) {
        CommonClass.init();

    }
}