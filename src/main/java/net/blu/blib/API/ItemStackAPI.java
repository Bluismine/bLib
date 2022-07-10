package net.blu.blib.API;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ItemStackAPI {

    @NotNull
    String getName();
    @NotNull
    String getDisplayName();
    @NotNull
    ItemStack getSkull();
}
