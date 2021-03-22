package io.github.lucaargolo.terrarianslimes.client.render.entity.feature

import io.github.lucaargolo.terrarianslimes.TerrarianSlimes
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.util.math.MatrixStack
import java.awt.Color

class RainbowSlimeOverlayFeatureRenderer(context: FeatureRendererContext<ModdedSlimeEntity, SlimeEntityModel<ModdedSlimeEntity>>): FeatureRenderer<ModdedSlimeEntity, SlimeEntityModel<ModdedSlimeEntity>>(context) {

    private val model: SlimeEntityModel<ModdedSlimeEntity> = SlimeEntityModel(0)

    override fun render(matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int, slimeEntity: ModdedSlimeEntity, limbAngle: Float, limbDistance: Float, tickDelta: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
        if (!slimeEntity.isInvisible) {
            this.contextModel?.copyStateTo(this.model)
            this.model.animateModel(slimeEntity, limbAngle, limbDistance, tickDelta)
            this.model.setAngles(slimeEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch)
            val overlayLayer = if(TerrarianSlimes.isCanvasLoaded) RenderLayer.getEntityTranslucent(getTexture(slimeEntity)) else RenderLayer.getItemEntityTranslucentCull(getTexture(slimeEntity))
            val vertexConsumer = vertexConsumers.getBuffer(overlayLayer)
            val color = Color.getHSBColor((slimeEntity.itemRotation + tickDelta) / 200, 1.0f, 1.0f)
            this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(slimeEntity, 0.0f), color.red/255f, color.blue/255f, color.green/255f, 1.0f)
        }
    }

}
