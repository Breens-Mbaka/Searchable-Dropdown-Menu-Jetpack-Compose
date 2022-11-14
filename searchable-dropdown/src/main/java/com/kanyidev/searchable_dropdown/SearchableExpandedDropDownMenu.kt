package com.kanyidev.searchable_dropdown

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun SearchableExpandedDropDownMenu(
    modifier: Modifier = Modifier,
    listOfItems: List<String>,
    enable: Boolean = false,
    placeholder: String = "Select Option",
    openedIcon: ImageVector = Icons.Outlined.KeyboardArrowUp,
    closedIcon: ImageVector = Icons.Outlined.KeyboardArrowDown,
    parentTextFieldCornerRadius: Dp = 12.dp,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    onDropDownItemSelected: (String) -> Unit = {}
) {

    var selectedOptionText by rememberSaveable { mutableStateOf("") }
    var searchedOption by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var filteredItems = mutableListOf<String>()
    var parentTextFieldSize by remember { mutableStateOf(Size.Zero) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = modifier
                .onGloballyPositioned { coordinates ->
                    parentTextFieldSize = coordinates.size.toSize()
                }
                .clickable {
                    expanded = !expanded
                },
            colors = colors,
            value = selectedOptionText,
            enabled = enable,
            onValueChange = { selectedOptionText = it },
            placeholder = {
                Text(text = placeholder)
            },
            trailingIcon = {
                IconToggleButton(
                    checked = expanded,
                    onCheckedChange = {
                        expanded = it
                    }
                ) {
                    if (expanded) Icon(
                        imageVector = openedIcon,
                        contentDescription = null
                    ) else Icon(
                        imageVector = closedIcon,
                        contentDescription = null
                    )
                }
            },
            shape = RoundedCornerShape(parentTextFieldCornerRadius)
        )
        if (expanded) {
            DropdownMenu(
                modifier = modifier,
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(28.dp)
                ) {
                    OutlinedTextField(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        value = searchedOption,
                        onValueChange = { selectedSport ->
                            searchedOption = selectedSport
                            filteredItems = listOfItems.filter {
                                it.contains(
                                    searchedOption,
                                    ignoreCase = true
                                )
                            }.toMutableList()
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
                        },
                        placeholder = {
                            Text(text = "Search")
                        }
                    )

                    val items = if (filteredItems.isEmpty()) {
                        listOfItems
                    } else {
                        filteredItems
                    }

                    items.forEach { selectedItem ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOptionText = selectedItem
                                onDropDownItemSelected(selectedItem)
                                searchedOption = ""
                                expanded = false
                            }
                        ) {
                            Text(text = selectedItem)
                        }
                    }
                }
            }
        }
    }
}