package io.github.lucaargolo.terrarianslimes.client.render.entity.spike

import io.github.lucaargolo.terrarianslimes.common.entity.EntityCompendium
import io.github.lucaargolo.terrarianslimes.common.entity.spike.SpikeEntity
import io.github.lucaargolo.terrarianslimes.utils.ModIdentifier
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.ProjectileEntityRenderer
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

class SpikeEntityRenderer(context: EntityRendererFactory.Context): ProjectileEntityRenderer<SpikeEntity>(context) {

    override fun getTexture(entity: SpikeEntity): Identifier {
        return ModIdentifier("textures/entity/${Registries.ENTITY_TYPE.getId(entity.owner?.type ?: EntityCompendium.SPIKED_SLIME).path}.png")
    }

}