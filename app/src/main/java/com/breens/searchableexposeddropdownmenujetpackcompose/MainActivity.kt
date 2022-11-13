package com.breens.searchableexposeddropdownmenujetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.breens.searchableexposeddropdownmenujetpackcompose.ui.theme.SearchableExposedDropDownMenuJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchableExposedDropDownMenuJetpackComposeTheme {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    SearchableExpandedDropDownMenu()
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SearchableExpandedDropDownMenu() {

    var selectedOptionText by rememberSaveable { mutableStateOf("") }

    var searchedOption by rememberSaveable { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }

    val sports =
        mutableListOf("Basketball", "Rugby", "Football", "MMA", "Motorsport", "Snooker", "Tennis")

    var filteredSports = mutableListOf<String>()

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = selectedOptionText,
            readOnly = true,
            onValueChange = { selectedOptionText = it },
            placeholder = { Text(text = "Select Option") },
            trailingIcon = {
                IconToggleButton(checked = expanded, onCheckedChange = { expanded = it }) {
                    if (expanded) Icon(
                        imageVector = Icons.Outlined.KeyboardArrowUp,
                        contentDescription = null
                    ) else Icon(
                        imageVector = Icons.Outlined.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
        )
        if (expanded) {
            Card(modifier = Modifier.width(280.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = searchedOption,
                        onValueChange = { selectedSport ->
                            searchedOption = selectedSport
                            filteredSports = sports.filter {
                                it.contains(
                                    searchedOption,
                                    ignoreCase = true
                                )
                            } as MutableList<String>
                        }
                    )

                    if (filteredSports.isNotEmpty()) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            filteredSports.forEach { selectionOption ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedOptionText = selectionOption
                                        expanded = false
                                    }
                                ) {
                                    Text(text = selectionOption)
                                }
                            }
                        }
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            sports.forEach { selectionOption ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedOptionText = selectionOption
                                        expanded = false
                                    }
                                ) {
                                    Text(text = selectionOption)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
