package com.project.fitness.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

const val country = "id"
const val category = "sport"
const val API_KEY = "6d271d9b1fd8453185012ad59b8f4706"

private val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

fun runWithBackgroundThread(block: () -> Unit) = scope.launch { block }