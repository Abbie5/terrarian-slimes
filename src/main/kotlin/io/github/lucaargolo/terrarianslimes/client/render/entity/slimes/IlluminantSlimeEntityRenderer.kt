package io.github.lucaargolo.terrarianslimes.client.render.entity.slimes

import io.github.lucaargolo.terrarianslimes.client.render.entity.feature.IlluminantSlimeOverlayFeatureRenderer
import io.github.lucaargolo.terrarianslimes.common.entity.slimes.ModdedSlimeEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.util.math.MatrixStack

class IlluminantSlimeEntityRenderer(entityRenderDispatcher: EntityRenderDispatcher): ModdedSlimeEntityRenderer(entityRenderDispatcher) {

    init {
        features.clear()
        addFeature(IlluminantSlimeOverlayFeatureRenderer(this))
    }

    override fun render(slimeEntity: ModdedSlimeEntity, yaw: Float, tickDelta: Float, matrixStack: MatrixStack, vertexConsumers: VertexConsumerProvider?, light: Int) {
        super.render(slimeEntity, yaw, tickDelta, matrixStack, vertexConsumers, 15728880)
    }

}