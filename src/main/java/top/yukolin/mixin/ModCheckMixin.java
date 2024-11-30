package top.yukolin.mixin;

import net.minecraft.util.ModCheck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModCheck.class)
public abstract class ModCheckMixin {
    
    @Inject(method = "shouldReportAsModified", at = @At("HEAD"), cancellable = true)
    private void shouldReportAsModified(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        cir.cancel();
    }
    
}
