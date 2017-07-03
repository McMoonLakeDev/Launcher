/*
 * Copyright (C) 2017 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.minecraft.moonlake.launcher.util

import com.minecraft.moonlake.launcher.layout.MuiPane
import javafx.scene.Node
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color

class MuiDepthUtils private constructor() {

    companion object {

        private val depth: Array<DropShadow> = arrayOf(
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .0), .0, .0, .0, .0),
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .26), 10.0, .12, -1.0, 2.0),
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .26), 15.0, .16, .0, 4.0),
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .26), 20.0, .19, .0, 6.0),
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .26), 25.0, .25, .0, 8.0),
                DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, .26), 30.0, .30, .0, 10.0))

        private fun safeLevel(level: Int): Int
                = if(level < 0) 0 else if(level > 5) 5 else level

        fun getShadowAt(level: Int): DropShadow
                = depth[safeLevel(level)]

        fun setNodeDepth(node: Node, level: Int) {
            val depth = depth[safeLevel(level)]
            node.effect = DropShadow(BlurType.GAUSSIAN, depth.color, depth.radius, depth.spread, depth.offsetX, depth.offsetY)
        }

        fun createNodeDepth(node: Node, level: Int): Node {
            val container = MuiPane(node)
            setNodeDepth(container, level)
            return container
        }
    }
}