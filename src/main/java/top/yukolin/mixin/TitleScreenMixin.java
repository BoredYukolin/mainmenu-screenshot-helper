package top.yukolin.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.yukolin.MainmenuScreenshotHelper;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ModCheck;shouldReportAsModified()Z"))
    private void getCurrentVersion(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci,
                                   @Local LocalRef<String> string) {
        string.set(MainmenuScreenshotHelper.VERSION_TEXT);
    }
    
}
