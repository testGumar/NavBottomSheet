package com.app.native_app_with_flutter_module

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.native_app_with_flutter_module.reactnative.MyReactActivity
import com.app.native_app_with_flutter_module.ui.theme.Native_app_with_flutter_moduleTheme
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class MainActivity : ComponentActivity() {
//    private lateinit var channel: MethodChannel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.channel")
        channel.invokeMethod("sendToFlutter", "Hello from Android!")

        // Use cached engine to launch FlutterActivity
        FlutterEngineCache.getInstance().put("my_engine_id", flutterEngine)

        channel.setMethodCallHandler { call, result ->
                if (call.method == "sendToNative") {
//                    val message = call.argument<String>("message")
                    val args = call.arguments as Map<*, *> // Receiving an object
                    Log.d("FlutterToNative", "Received: $args")
                    result.success("Got your message!")
                }
            }


    setContent {
            Native_app_with_flutter_moduleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BoxWithFabButtons(innerPadding = innerPadding, channel = channel)
                }
            }
        }
    }


}

@Composable
fun BoxWithFabButtons(modifier: Modifier = Modifier, innerPadding: PaddingValues, channel: MethodChannel) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {

        Greeting(name = "Android", modifier = Modifier.align(Alignment.Center))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FloatingActionButton(onClick = {
                //context.startActivity(FlutterActivity.createDefaultIntent(context))
                channel.invokeMethod("sendToFlutter", "Counter = ${Math.random()}")
                context.startActivity(FlutterActivity.withCachedEngine("my_engine_id").build(context))
            }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Left FAB")
            }

            FloatingActionButton(onClick = { /* Right action */
                context.startActivity(Intent(context, MyReactActivity::class.java))
            }) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Right FAB")
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Native_app_with_flutter_moduleTheme {
        Greeting("Android")
    }
}