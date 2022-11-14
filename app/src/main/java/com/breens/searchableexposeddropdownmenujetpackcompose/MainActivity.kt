package com.breens.searchableexposeddropdownmenujetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
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
                val sports =
                    mutableListOf(
                        Test("Football", 1),
                        Test("Rugby", 2),
                        Test("Snooker", 2),
                        Test("Tennis", 4),
                        Test("Volleyball", 5),
                        Test("Basketball", 6)
                    )
                LazyColumn(modifier = Modifier.fillMaxSize(),contentPadding = PaddingValues(16.dp)) {
                    item {
                        SearchableExpandedDropDownMenu(
                            listOfItems = sports,
                            modifier = Modifier.fillMaxWidth(),
                            onDropDownItemSelected = { item ->
                                Toast.makeText(applicationContext, item.name, Toast.LENGTH_SHORT).show()
                            },
                            dropdownItem = { test ->
                                DropDownItem(test = test)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DropDownItem(test: Test) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Icon(
            Icons.Outlined.Check,
            contentDescription = "Check Mark"
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(test.name)
    }
}

data class Test(
    val name: String,
    val id: Int
) {
    override fun toString(): String {
        return name
    }
}