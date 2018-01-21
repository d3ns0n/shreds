package de.d3ns0n.shreds.dummy

import de.d3ns0n.shreds.model.TextShred

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<Int, TextShred> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 0 until COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: TextShred) {
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): TextShred {
        return TextShred(position, "Item $position")
    }

}
