package com.breens.searchableexposeddropdownmenujetpackcompose

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.breens.searchableexposeddropdownmenujetpackcompose.ui.theme.SearchableExposedDropDownMenuJetpackComposeTheme
import com.kanyidev.searchable_dropdown.SearchableExpandedDropDownMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchableExposedDropDownMenuJetpackComposeTheme {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    val sports =
                        mutableListOf(
                            "Basketball",
                            "Rugby",
                            "Football",
                            "MMA",
                            "Motorsport",
                            "Snooker",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                            "Tennis",
                        )
                    SearchableExpandedDropDownMenu(
                        listOfItems = sports,
                        modifier = Modifier.fillMaxWidth(),
                        onDropDownItemSelected = { item ->
                            Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
