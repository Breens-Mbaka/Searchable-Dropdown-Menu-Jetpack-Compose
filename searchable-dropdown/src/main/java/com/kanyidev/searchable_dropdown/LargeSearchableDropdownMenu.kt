package com.kanyidev.searchable_dropdown

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class
)
@Composable
fun <T> LargeSearchableDropdownMenu(
    modifier: Modifier = Modifier,
    selectedOption: T?,
    onItemSelected: (item: T) -> Unit,
    selectedItemToString: (T) -> String = { it.toString() },
    title: String? = null,
    placeholder: String,
    options: List<T>,
    enabled: Boolean = true,
    isError: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
        disabledContainerColor = MaterialTheme.colorScheme.background,
        errorContainerColor = MaterialTheme.colorScheme.background,
    ),
    fieldLabelTextStyle: TextStyle = MaterialTheme.typography.labelSmall,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    placeholderTextStyle: TextStyle = MaterialTheme.typography.bodySmall.copy(
        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
    ),
    drawItem: @Composable (T, Boolean, Boolean, () -> Unit) -> Unit = { item, selected, itemEnabled, onClick ->
        DropdownMenuItem(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            text = item.toString(),
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
            textStyle = textStyle,
        )
    },
    optionsTitle: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    val showSearchOption by remember {
        derivedStateOf {
            options.size > 5
        }
    }

    Column {
        if (title != null) {
            Text(
                text = title,
                style = fieldLabelTextStyle,
            )
        }
        Box(modifier = modifier.height(IntrinsicSize.Min)) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .semantics { testTag = title ?: "field"; testTagsAsResourceId = true },
                readOnly = true,
                value = if (selectedOption != null) selectedItemToString(selectedOption) else "",
                onValueChange = {},
                shape = shape,
                textStyle = textStyle,
                singleLine = true,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = placeholderTextStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                trailingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        if (enabled) {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }
                        trailingIcon?.invoke()
                    }
                },
                colors = colors,
                isError = isError,
            )

            // Transparent clickable surface on top of OutlinedTextField
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .clickable(enabled = enabled) { expanded = true },
                color = Color.Transparent,
            ) {}
        }
    }

    if (expanded) {
        var searchedString by rememberSaveable { mutableStateOf("") }

        var filteredItems by remember { mutableStateOf(options) }

        val items = if (searchedString.isEmpty()) {
            options
        } else {
            filteredItems
        }

        Log.e("items", "items: $items")
        Log.e("filteredItems", "filtered: $filteredItems")


        PromptDialog(
            modifier = Modifier
                .wrapContentHeight()
                .heightIn(max = 400.dp)
                .fillMaxWidth(),
            onDismiss = {
                expanded = false
            },
            title = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    optionsTitle?.invoke()
                    if (showSearchOption) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = searchedString,
                            onValueChange = { searchStr ->
                                searchedString = searchStr
                                filteredItems = options.searchForAnItem(searchStr)
                            },
                            textStyle = textStyle,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Search,
                                    contentDescription = null
                                )
                            },
                            placeholder = {
                                Text(
                                    text = "Search...",
                                    style = MaterialTheme.typography.labelSmall,
                                )
                            },
                        )
                    }
                }
            }
        ) {
            val listState = rememberLazyListState()
            val index = options.indexOf(selectedOption)

            if (selectedOption != null && index != -1) {
                LaunchedEffect("ScrollToSelected") {
                    listState.scrollToItem(index = index)
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                state = listState,
            ) {
                itemsIndexed(items) { index, item ->
                    val selectedItem = item == selectedOption

                    drawItem(
                        item,
                        selectedItem,
                        true
                    ) {
                        onItemSelected(item)
                        expanded = false
                        searchedString = ""
                    }

                    if (index < items.lastIndex) {
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownMenuItem(
    text: String,
    textStyle: TextStyle,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val contentColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurface
        selected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onSurface
    }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(modifier = modifier
            .clickable(enabled) { onClick() }
            .fillMaxWidth()) {
            Text(
                text = text,
                style = textStyle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun PromptDialog(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    title: @Composable () -> Unit = {},
    dismissButtonContent: @Composable () -> Unit = {},
    confirmButtonContent: @Composable () -> Unit = {},
    dismissable: Boolean = true,
    dialogBackgroundColor: Color = MaterialTheme.colorScheme.background,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit,
) {
    AlertDialog(
        modifier = modifier.fillMaxWidth(),
        icon = icon,
        containerColor = dialogBackgroundColor,
        onDismissRequest = {
            if (dismissable) onDismiss()
        },
        title = title,
        text = content,
        dismissButton = dismissButtonContent,
        confirmButton = confirmButtonContent,
    )
}

fun <T> List<T>.searchForAnItem(
    searchStr: String,
): List<T> {
    val filteredItems = filter {
        it.toString().contains(
            searchStr,
            ignoreCase = true,
        )
    }
    println(filteredItems)
    return filteredItems
}