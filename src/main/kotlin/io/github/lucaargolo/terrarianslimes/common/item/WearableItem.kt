package io.github.lucaargolo.terrarianslimes.common.item

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.Equipment
import net.minecraft.item.Item

class WearableItem(settings: Settings, private val equipmentSlot: EquipmentSlot): Item(settings), Equipment {
    override fun getSlotType() = equipmentSlot
}