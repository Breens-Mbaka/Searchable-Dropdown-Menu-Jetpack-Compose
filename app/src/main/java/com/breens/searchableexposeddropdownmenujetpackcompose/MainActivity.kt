package com.breens.searchableexposeddropdownmenujetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.breens.searchableexposeddropdownmenujetpackcompose.ui.theme.SearchableExposedDropDownMenuJetpackComposeTheme
import com.kanyidev.searchable_dropdown.LargeSearchableDropdownMenu
import com.kanyidev.searchable_dropdown.SearchableExpandedDropDownMenuMaterial3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchableExposedDropDownMenuJetpackComposeTheme {
                val sports = mutableListOf(
                    Sport("Basketball", "🏀"),
                    Sport("Rugby", "🏉"),
                    Sport("Football", "⚽️"),
                    Sport("MMA", "🤼‍♂️"),
                    Sport("Motorsport", "🏁"),
                    Sport("Snooker", "🎱"),
                    Sport("Tennis", "🎾"),
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    contentPadding = PaddingValues(16.dp)
                ) {
                    item {
                        Text(
                            text = "Searchable Dropdown Menu",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        SearchableExpandedDropDownMenuMaterial3(
                            listOfItems = sports,
                            modifier = Modifier.fillMaxWidth(),
                            onDropDownItemSelected = { item ->
                                Toast.makeText(
                                    applicationContext,
                                    item.name,
                                    Toast.LENGTH_SHORT,
                                ).show()
                            },
                            dropdownItem = { test ->
                                DropDownItem(test = test)
                            },
                            defaultItem = {
                                Log.e("DEFAULT_ITEM", it.name)
                            },
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        Spacer(Modifier.height(16.dp))
                    }

                    item {
                        Text(
                            text = "Large Searchable Dropdown Menu",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        var selectedIndex by remember { mutableStateOf<String?>(null) }
                        LargeSearchableDropdownMenu(
                            title = "Sample",
                            placeholder = "Select",
                            options = listOf(
                                "Item 1",
                                "Item 2",
                                "tom",
                                "Item 3",
                                "Item 4",
                                "Item 5",
                                "Item 6",
                                "Item 7",
                                "joel",
                                "john",
                                "kevin",
                                "james",
                                "kiarie"
                            ),
                            selectedOption = selectedIndex,
                            onItemSelected = {
                                selectedIndex = it
                            },
                            optionsTitle = {
                                Text(
                                    text = "Select an item",
                                    style = MaterialTheme.typography.titleSmall,
                                )
                            }
                        )
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
            .wrapContentSize(),
    ) {
        Text(text = test.emoji)
        Spacer(modifier = Modifier.width(12.dp))
        Text(test.name)
    }
}

data class Sport(
    val name: String,
    val emoji: String,
) {
    override fun toString(): String {
        return "$emoji $name"
    }
}
