package me.inassar.utils

import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceOrientation


fun getDeviceOrientation(): DeviceOrientation {
    return when (UIDevice.currentDevice.orientation) {
        UIDeviceOrientation.UIDeviceOrientationLandscapeRight -> DeviceOrientation(
            portrait = false,
            landscape = true
        )

        UIDeviceOrientation.UIDeviceOrientationPortraitUpsideDown -> DeviceOrientation(
            portrait = true,
            landscape = false
        )

        UIDeviceOrientation.UIDeviceOrientationPortrait -> DeviceOrientation(
            portrait = true,
            landscape = false
        )

        UIDeviceOrientation.UIDeviceOrientationLandscapeLeft -> DeviceOrientation(
            portrait = false,
            landscape = true
        )

        else -> DeviceOrientation(portrait = true, landscape = false)
    }
}

data class DeviceOrientation(val portrait: Boolean, val landscape: Boolean)