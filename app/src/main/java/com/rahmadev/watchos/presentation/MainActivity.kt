package com.rahmadev.watchos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            val mainViewModel = viewModel<MainViewModel>()
            val timerState by mainViewModel.timerState.collectAsStateWithLifecycle()
            val stopWatchText by mainViewModel.stopWatchText.collectAsStateWithLifecycle()

            WatchOSApp(
                state = timerState,
                text = stopWatchText,
                onToggleRunning = mainViewModel::toogleIsRunning,
                onReset = mainViewModel::resetTimer,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}