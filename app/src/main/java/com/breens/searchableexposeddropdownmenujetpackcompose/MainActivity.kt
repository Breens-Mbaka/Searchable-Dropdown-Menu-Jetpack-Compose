package com.breens.searchableexposeddropdownmenujetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    val sports = mutableListOf(
                        Sport("Basketball", "🏀"),
                        Sport("Rugby", "🏉"),
                        Sport("Football", "⚽️"),
                        Sport("MMA", "🤼‍♂️"),
                        Sport("Motorsport", "🏁"),
                        Sport("Snooker", "🎱"),
                        Sport("Tennis", "🎾")
                    )
                    LazyColumn {
                        items(50) {
                            SearchableExpandedDropDownMenu(
                                listOfItems = sports,
                                modifier = Modifier.fillMaxWidth(),
                                onDropDownItemSelected = { item ->
                                    Toast.makeText(
                                        applicationContext,
                                        item.name,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                dropdownItem = { test ->
                                    DropDownItem(test = test)
                                },
                                defaultItem = {
                                    Log.e("DEFAULT_ITEM", it.name)
                                }
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropDownItem(test: Sport) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Text(text = test.emoji)
        Spacer(modifier = Modifier.width(12.dp))
        Text(test.name)
    }
}

data class Sport(
    val name: String,
    val emoji: String
) {
    override fun toString(): String {
        return "$emoji $name"
    }
}
