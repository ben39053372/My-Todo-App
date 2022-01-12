package com.ben39053372.TodoApp.utils

import timber.log.Timber

object MyLogTree: Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "Log[${element.fileName}:${element.lineNumber}] ${element.methodName}"
    }
}