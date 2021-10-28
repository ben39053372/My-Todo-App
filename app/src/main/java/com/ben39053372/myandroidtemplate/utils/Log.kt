package com.ben39053372.myandroidtemplate.utils

import timber.log.Timber

class Log {
    companion object {
        fun d(msg: String) {
            Timber.d("-- [Debug]: $msg")
        }

        fun i(msg: String) {
            Timber.i("-- [INFO]: $msg")
        }

        fun e(msg: String) {
            Timber.e("-- [ERROR]: $msg")
        }

        fun warn(msg: String) {
            Timber.w("-- [WARN]: $msg")
        }

        fun d(msg: String, tag: String) {
            Timber.d("-- [Debug] - $tag : $msg")
        }

        fun i(msg: String, tag: String) {
            Timber.i("-- [INFO] - $tag : $msg")
        }

        fun e(msg: String, tag: String) {
            Timber.e("-- [ERROR] - $tag : $msg")
        }

        fun warn(msg: String, tag: String) {
            Timber.w("-- [WARN] - $tag : $msg")
        }
    }
}