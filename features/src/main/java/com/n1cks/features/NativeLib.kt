package com.n1cks.features

class NativeLib {

    /**
     * A native method that is implemented by the 'features' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'features' library on application startup.
        init {
            System.loadLibrary("features")
        }
    }
}