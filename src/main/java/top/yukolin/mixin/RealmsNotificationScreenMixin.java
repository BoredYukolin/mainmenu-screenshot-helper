package top.yukolin.mixin;


import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(RealmsNotificationsScreen.class)
public abstract class RealmsNotificationScreenMixin extends Screen {
    
    protected RealmsNotificationScreenMixin(Component component) {
        super(component);
    }
    
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        super.render(guiGraphics, i, j, f);
        int k = this.height / 4 + 48;
        int l = this.width / 2 + 100;
        int m = k + 48 + 2;
        int n = l - 3;
        
        guiGraphics.blitSprite(RenderType::guiTextured, ResourceLocation.withDefaultNamespace("icon/news"), n - 14, m + 1, 14, 14);
        n -= 16;
        
        guiGraphics.blitSprite(RenderType::guiTextured, ResourceLocation.withDefaultNamespace("icon/trial_available"), n - 10, m + 4, 8, 8);
        ci.cancel();
    }
}
