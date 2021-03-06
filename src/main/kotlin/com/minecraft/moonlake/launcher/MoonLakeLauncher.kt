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

package com.minecraft.moonlake.launcher

import com.google.gson.GsonBuilder
import com.minecraft.moonlake.launcher.controller.MuiControllerUtils
import com.minecraft.moonlake.launcher.system.Platform
import com.minecraft.moonlake.launcher.ui.Test
import com.minecraft.moonlake.launcher.util.MuiUtils
import javafx.application.Application
import javafx.stage.Stage
import javafx.stage.StageStyle

class MoonLakeLauncher: Application() {

    /**************************************************************************
     *
     * Static
     *
     **************************************************************************/

    companion object {

        /**************************************************************************
         *
         * Public Member
         *
         **************************************************************************/

        val version = "1.0"
        val platform = Platform.getInfo()
        val logger = MoonLakeLauncherLogger()
        val gson = GsonBuilder().setPrettyPrinting().create()

        /**************************************************************************
         *
         * Public Method
         *
         **************************************************************************/

        fun launch(args: Array<String>) {
            launch(MoonLakeLauncher::class.java, *args)
        }
    }

    /**************************************************************************
     *
     * Private Member
     *
     **************************************************************************/

    private var primaryStage: Stage? = null

    /**************************************************************************
     *
     * Init
     *
     **************************************************************************/

    init {
        printLauncher()
    }

    /**************************************************************************
     *
     * Override Implements
     *
     **************************************************************************/

    override fun start(primaryStage: Stage) {
        this.primaryStage = MuiUtils.createMuiStage(primaryStage, Test::class.java, "MoonLake Launcher", StageStyle.TRANSPARENT)
        this.primaryStage().show()
    }

    /**************************************************************************
     *
     * Public Method
     *
     **************************************************************************/

    fun primaryStage(): Stage
            = primaryStage!!

    /**************************************************************************
     *
     * Private Implements
     *
     **************************************************************************/

    private fun printLauncher() {
        println()
        println("MoonLake Launcher v$version by Month_Light, lgou2w")
        println()
        println("System Info: ${platform.platform} ${platform.version} x${platform.bit}")
        println("System Total Memory Size: ${platform.totalMemory}")
        println()
    }
}
