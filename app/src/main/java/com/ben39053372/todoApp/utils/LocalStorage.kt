package com.ben39053372.todoApp.utils

import android.content.Context

class LocalStorage {

    companion object {

        private const val LocalStorage = "LOCAL_STORAGE"
        private const val MODE = Context.MODE_PRIVATE

        fun get(context: Context, key: String): String? {
            return context.getSharedPreferences(LocalStorage, MODE).getString(key, "")
        }

        fun set(context: Context, key: String, value: String) {
            context.getSharedPreferences(LocalStorage, MODE).edit().putString(key, value).apply()
        }

        fun clearAll(context: Context) {
            context.getSharedPreferences(LocalStorage, MODE).edit().clear().apply()
        }
    }
}